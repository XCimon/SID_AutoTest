package com.example.cog.crossline;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.cog.crossline.entity.Target;
import lombok.Builder;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.junit.Test;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.*;

/**
 * @Author: Cirmons
 * @Date: 2023-06-02
 */
@Slf4j
public class CrossLineTrackTest {
    
    private final static int FACE_LABEL = 37017;
    private final static int BODY_LABEL = 221488;
    
    // 初始化
    Map<Integer, List<Track>> trackMap = new HashMap<>();
    Map<Integer, Integer> idMap = new HashMap<>();
    
    
    @Test
    public void count() throws IOException {
        // 读取目标内容
        List<String> lines = FileUtils.readLines(new File("test/resources/cog/new-loujian1_LVL11-CAM02-20230413090000.txt"), "utf-8");
        
        Set<String> imgSet = new HashSet<>();
        lines.stream().forEach(l -> {
            JSONObject jsonObject = JSON.parseObject(l);
            
            imgSet.add(jsonObject.getString("imgUrl"));
        });
        
        log.info("" + imgSet.size());
        System.out.println(1);
    }
    
    
    @Test
    public void testTracks() throws IOException {
        
        
        // 读取目标内容
//        List<String> lines = FileUtils.readLines(new File("test/resources/cog/loujian1_LVL11-CAM02-20230413090000.txt"), "utf-8");
        List<String> lines = FileUtils.readLines(new File("test/resources/cog/new-loujian1_LVL11-CAM02-20230413090000.txt"), "utf-8");
        
        for (String line : lines) {
//            JSONArray modelResult = JSON.parseArray(line);
            JSONObject lineJson = JSON.parseObject(line);
            String imgUrl = lineJson.getString("imgUrl");
            String imageName = FilenameUtils.getName(imgUrl);
            JSONArray modelResult = lineJson.getJSONArray("modelResult");
            JSONArray targets = modelResult.getJSONObject(0).getJSONArray("targets");
            
            if (targets.size() <= 0) {
                log.debug(">>> [crossLine] target is empty, result str = {}", line);
                continue;
            }
//            if (targets.size() > 1) {
//                log.info(">>> [crossLine] target size more than 2, size : {}, str={}", targets.size(), line);
//            }
            
            
            try {
                for (int i = 0; i < targets.size(); i++) {
                    Target target = targets.getObject(i, Target.class);
                    if (target == null)
                        continue;
                    
                    
                    // DEBUG;看一下关联对象是否多个
                    if (target.getAssociations() != null && target.getAssociations().size() > 1) {
                        log.debug(">>> [crossLine] assciations more than 1, size : {}, label: {}, line: {}", target.getAssociations().size(), target.getLabel(), line);
                    }
                    
                    if (target.getLabel() == null) {
                        log.warn(">>> [crossLine] label is empty!");
                        continue;
                    }
                    
                    Integer trackId = null;
                    Integer ascociateTrackId = null;
                    Object faceRoi = null;
                    Object bodyRoi = null;
                    
                    if (target.getLabel() == FACE_LABEL) {
                        trackId = target.getTrackId();
                        ascociateTrackId = target.getAssociations() == null ? null : target.getAssociations().stream().findAny().map(a -> a.getTrackId()).orElse(null);
                        faceRoi = target.getRoi();
                        bodyRoi = target.getAssociations() == null ? null : target.getAssociations().stream().findAny().map(a -> a.getRoi()).orElse(null);
                    } else if (target.getLabel() == BODY_LABEL) {
                        Integer tmp = trackId;
                        trackId = ascociateTrackId;
                        ascociateTrackId = tmp;
                        Object tmpRoi = faceRoi;
                        faceRoi = bodyRoi;
                        bodyRoi = tmpRoi;
                    }

//                    switch (target.getLabel()) {
//                        case FACE_LABEL:
//                            trackId = target.getTrackId();
//                            ascociateTrackId = target.getAssociations().stream().findAny().map(a -> a.getTrackId()).orElse(null);
//                            break;
//
//                        case BODY_LABEL:
//                            trackId = target.getAssociations().stream().findAny().map(a -> a.getTrackId()).orElse(null);
//                            ascociateTrackId = target.getTrackId();
//                            break;
//                        default:
//                            //                        log.warn(">>> [crossLine] invalid target!");
//                            break;
//                    }
                    
                    if (trackId == null && ascociateTrackId == null) {
                        log.warn(">>> [crossLine] invalid target!");
                        continue;
                    }
                    
                    Track track = Track.builder().trackId(trackId).associateTrackId(ascociateTrackId)
                            .timestamp(Long.parseLong(target.getImage().getPts()))
                            .Label(target.getLabel())
                            .extraInfo(
                                    Map.of("image", target.getImage(),
                                            "faceRoi", faceRoi,
                                            "bodyRoi", bodyRoi,
                                            "imageName", imageName)
                            ).build();
                    
                    // 添加新目标
                    updateTrackMap(track, trackMap, idMap);
                }
            } catch (Exception e) {
                log.error(">>> [crossLine] update model result failed! result is={}", line, e);
            }
            
            
        }


//        Track newTarget = new Track(); // 这里假设你已经创建了一个新的 Target 对象
//        updateTrackMap(newTarget, trackMap, idMap);
//
        log.info(">>> crossLine result= {}", JSON.toJSONString(trackMap));
        System.out.println(1);
        
        // 画图
        trackMap.keySet().forEach(i-> {
            try {
                obtainTracks(trackMap,i);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
    
    
    private void obtainTracks(Map<Integer, List<Track>> trackMap, Integer trackId) throws IOException {
        
        String sourceDir = "/Users/xupeng/Desktop/loujian1/";
        String destDir = "/Users/xupeng/Desktop/loujian1/" + trackId.intValue();
        FileUtils.forceMkdir(new File(destDir));
        
        
        List<Track> tracks = trackMap.get(trackId);
        for (Track track : tracks) {
            Map<String, Object> extra = track.getExtraInfo();
            
            // 原始图片
            String imageName = (String) extra.get("imageName");
            String sourceImg = sourceDir + imageName;
            
            // faceRoi
            JSONObject faceRoiJson = JSON.parseObject(JSON.toJSONString(extra.get("faceRoi")));
            // bodyRoi
            JSONObject bodyRoiJson = JSON.parseObject(JSON.toJSONString(extra.get("bodyRoi")));
            
            
            BufferedImage image = ImageIO.read(new File(sourceImg));
            // 画框
            DrawRectangle.drawRectangleOnImage(image, new DrawRectangle.RectangleInfo(faceRoiJson.getInteger("left"), faceRoiJson.getInteger("top"), faceRoiJson.getInteger("width"), faceRoiJson.getInteger("height"), Color.RED, 3));
            DrawRectangle.drawRectangleOnImage(image, new DrawRectangle.RectangleInfo(bodyRoiJson.getInteger("left"), bodyRoiJson.getInteger("top"), bodyRoiJson.getInteger("width"), bodyRoiJson.getInteger("height"), Color.GREEN, 3));
            
            // 画文字
            DrawRectangle.drawTextOnImage(image,
                    new DrawRectangle.TextInfo(track.getTrackId() + "", faceRoiJson.getInteger("left"), faceRoiJson.getInteger("top")),
                    new DrawRectangle.TextInfo(track.getAssociateTrackId() + "", bodyRoiJson.getInteger("left"), bodyRoiJson.getInteger("top"))
            );
            
            // 保存新图
            String newImagePath = destDir + "/re-" + imageName;
            ImageIO.write(image, "jpg", new File(newImagePath));
            
        }
        
        
    }
    
    private void updateTrackMap(Track newTarget, Map<Integer, List<Track>> trackMap, Map<Integer, Integer> idMap) {
        int idA = newTarget.getTrackId();
        int idB = newTarget.getAssociateTrackId() == null ? 0 : newTarget.getAssociateTrackId();
        int trackId = idA != 0 ? idA : idMap.getOrDefault(idB, 0);
        
        // 如果没有找到相应的轨迹，创建新的轨迹
        if (!trackMap.containsKey(trackId)) {
            trackId = idA != 0 ? idA : idB;
            trackMap.put(trackId, new LinkedList<>());
            if (idA != 0 && idB != 0) {
                idMap.put(idB, idA);
            }
        }
        
        // 添加新目标到轨迹
        List<Track> trackList = trackMap.get(trackId);
        trackList.add(newTarget);

//        // 移除超过 10 秒的目标
//        long currentTime = System.currentTimeMillis();
//        while (!trackList.isEmpty() && currentTime - trackList.get(0).getTimestamp() > 10000) {
//            trackList.remove(0);
//        }
    }
    
    
    @Data
    @Builder
    public static class Track {
        private Integer trackId;
        private Integer associateTrackId;
        
        private Map<String, Object> extraInfo;
        private Long timestamp;
        private Integer Label;
    }
    
    
}

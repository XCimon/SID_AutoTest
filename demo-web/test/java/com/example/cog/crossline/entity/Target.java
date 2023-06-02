package com.example.cog.crossline.entity;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @Author: Cirmons
 * @Date: 2023-06-02
 */
@NoArgsConstructor
@Data
public class Target {
    
    
    @JSONField(name = "associations")
    private List<AssociationsDTO> associations;
    @JSONField(name = "image")
    private ImageDTO image;
    @JSONField(name = "from_detect")
    private Boolean fromDetect;
    @JSONField(name = "motion")
    private MotionDTO motion;
    @JSONField(name = "confidence")
    private Double confidence;
    @JSONField(name = "flock_index")
    private Integer flockIndex;
    @JSONField(name = "label")
    private Integer label;
    @JSONField(name = "roi")
    private RoiDTO roi;
    @JSONField(name = "motion_from_begin")
    private MotionFromBeginDTO motionFromBegin;
    @JSONField(name = "track_id")
    private Integer trackId;
    @JSONField(name = "id")
    private Integer id;
    @JSONField(name = "source_id")
    private Integer sourceId;
    @JSONField(name = "image_id")
    private Integer imageId;
    
    @NoArgsConstructor
    @Data
    public static class ImageDTO {
        @JSONField(name = "format")
        private String format;
        @JSONField(name = "width")
        private String width;
        @JSONField(name = "media")
        private String media;
        @JSONField(name = "type")
        private String type;
        @JSONField(name = "pts")
        private String pts;
        @JSONField(name = "height")
        private String height;
    }
    
    @NoArgsConstructor
    @Data
    public static class MotionDTO {
        @JSONField(name = "x")
        private Double x;
        @JSONField(name = "y")
        private Double y;
    }
    
    @NoArgsConstructor
    @Data
    public static class RoiDTO {
        @JSONField(name = "top")
        private Integer top;
        @JSONField(name = "left")
        private Integer left;
        @JSONField(name = "width")
        private Integer width;
        @JSONField(name = "height")
        private Integer height;
    }
    
    @NoArgsConstructor
    @Data
    public static class MotionFromBeginDTO {
        @JSONField(name = "x")
        private Double x;
        @JSONField(name = "y")
        private Double y;
    }
    
    @NoArgsConstructor
    @Data
    public static class AssociationsDTO {
        @JSONField(name = "association_score")
        private Double associationScore;
        @JSONField(name = "track_id")
        private Integer trackId;
        @JSONField(name = "id")
        private Integer id;
        @JSONField(name = "label")
        private Integer label;
        @JSONField(name = "association_type")
        private String associationType;
        @JSONField(name = "roi")
        private RoiDTO roi;
        
        @NoArgsConstructor
        @Data
        public static class RoiDTO {
            @JSONField(name = "top")
            private Integer top;
            @JSONField(name = "left")
            private Integer left;
            @JSONField(name = "width")
            private Integer width;
            @JSONField(name = "height")
            private Integer height;
        }
    }
}

package com.example.demo.components;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

/**
 * @Author: Cirmons
 * @Date: 2019-05-13
 */
@Slf4j
@Component
public class ModelLoader implements ApplicationListener<ContextRefreshedEvent>, Ordered {

//    @Resource
//    private OcrProperty ocrProperty;
//
//    @Autowired
//    private Map<OcrModelType, String> ocrModelMap;
//
//    @Autowired
//    private Map<String, HandlerFactory.KeyObject> modelPathPoolKeyMap;
    
    
    @Override
    public int getOrder() {
        return Ordered.HIGHEST_PRECEDENCE + 1;
    }
    
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        log.info(">>> init ModelMap...");
//        initOcrModelMap();
//        initModelPathPoolKeyMap();
        log.info(">>> completed to init ModelMap!");
    }

//    public void initOcrModelMap() {
//
//
//        OcrProperty.OcrModelConfig config = ocrProperty.getOcrModelConfig();
//        Field[] fields = config.getClass().getDeclaredFields();
//
//        try {
//            for (Field field : fields)
//                field.setAccessible(true);  // 抑制Java对私有属性的检查
//
//            String root = (String) Arrays.stream(fields)
//                    .filter(f -> f.getType().isAssignableFrom(String.class) && f.getName().toUpperCase().contains("root".toUpperCase()))
//                    .findFirst()
//                    .get()
//                    .get(config);
//
//            for (Field field : fields) {
//                if (field.getType().isAssignableFrom(String.class) && field.getName().toUpperCase().contains("root".toUpperCase()))
//                    continue;
//
//                String enumName = field.getName()
//                        .toUpperCase()
//                        .replaceAll("MODEL", "");
//                OcrModelType type = OcrModelType.getEnum(enumName);
//                String modelPath = (String) field.get(config);
//                ocrModelMap.put(type, StringUtils.isNotBlank(modelPath) ? root + modelPath : "");
//            }
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//
//
//    }
//
//    public void initModelPathPoolKeyMap() {
//        // 处理 ocrModel
//        for (Map.Entry<OcrModelType, String> entry : ocrModelMap.entrySet()) {
//            OcrModelType ocrType = entry.getKey();
//            String ocrModelPath = entry.getValue();
//
//            if (ocrType == OcrModelType.GENERAL) { // 特殊逻辑，general 创建两个句柄, map 中 key = model + OCR_GENERAL_0 或者 + OCR_GENERAL_1
//                modelPathPoolKeyMap.put(ocrModelPath + OCR_GENERAL_0.name(), new HandlerFactory.KeyObject(OCR_GENERAL_0, ocrModelPath));
//                modelPathPoolKeyMap.put(ocrModelPath + OCR_GENERAL_1.name(), new HandlerFactory.KeyObject(OCR_GENERAL_1, ocrModelPath));
//            } else
//                modelPathPoolKeyMap.put(ocrModelPath, new HandlerFactory.KeyObject(HandlerFactory.KeyType.OCR, ocrModelPath));
//        }
//
//        // 处理去水印model
//        String dewatermarkModelPath = ocrProperty.getFaceModelConfig().getRoot() + ocrProperty.getFaceModelConfig().getDewatermarkModel();
//        modelPathPoolKeyMap.put(dewatermarkModelPath, new HandlerFactory.KeyObject(HandlerFactory.KeyType.FACE, dewatermarkModelPath));
//    }
    
    
}

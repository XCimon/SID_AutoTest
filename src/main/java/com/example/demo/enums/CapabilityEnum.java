package com.example.demo.enums;

import java.util.Arrays;


/**
 * @Author: Cirmons
 * @Date: 2020-04-10
 */
public enum CapabilityEnum {
    SERVER_CAP_1V1("kwGWxsSvJIBU", ""),                     // 智能身份核验平台_服务端_1v1
    SERVER_CAP_1VN("csouBUfdYtMJ", ""),                     // 智能身份核验平台_服务端_1vn
    SERVER_CAP_ATTRIBUTE("GTgyjviONKuU", ""),               // 智能身份核验平台_服务端_人脸属性
    SERVER_CAP_FAKEFACE("dPHhTGegEBAO", ""),                // 智能身份核验平台_服务端_人脸单图防伪
    SERVER_CAP_LIVENESS("CvUeftVDIJXT", ""),                // 智能身份核验平台_服务端_交互活体_H5
    SERVER_CAP_SILENT("XKqBeDjiHRUu", ""),                  // 智能身份核验平台_服务端_静默活体_H5
    SERVER_CAP_QUALITY("LfDrBYhuPvlp", ""),                 // 智能身份核验平台_服务端_图像质量
    SERVER_CAP_DATASAFE("ZJedzSMifYqn", ""),                 // 智能身份核验平台_服务端_数据安全
    
    SERVER_CAP_1V1_CHANNEL("zMBKydomuXaj", ""),             // 智能身份核验平台_服务端_1v1_渠道版
    SERVER_CAP_1VN_CHANNEL("dxXLGCFUQyEf", ""),             // 智能身份核验平台_服务端_1vn_渠道版
    SERVER_CAP_1V1_CHANNEL_BASIC("ImqivKLUBVTt", ""),       // 智能身份核验平台_服务端_1v1_渠道入门版
    SERVER_CAP_1VN_CHANNEL_BASIC("IGpBvoAyMkTO", ""),       // 智能身份核验平台_服务端_1vn_渠道入门版
    
    SERVER_CAP_OCR_GENERAL("yrcLkXAvNOpf", "0"),                  // 智能身份核验平台_服务端_ocr_通用文字
    SERVER_CAP_OCR_BANKCARD("lzFmTeDfOhqU", "1"),                 // 智能身份核验平台_服务端_ocr_银行卡图片卡号和相关信息
    SERVER_CAP_OCR_IDCARD("speRznCuVmEk", "2"),                   // 智能身份核验平台_服务端_ocr_静态身份证图片
    SERVER_CAP_OCR_TEMP_IDCARD("oqQKkMaBGrnw", "3"),              // 智能身份核验平台_服务端_ocr_临时身证图片
    SERVER_CAP_OCR_EXPRESS_RECEIPT("msTQCxpKEBAU", "4"),          // 智能身份核验平台_服务端_ocr_快递单图片
    SERVER_CAP_OCR_BUSINESS_LICENSE("xWZoqkhCJNRK", "5"),         // 智能身份核验平台_服务端_ocr_营业执照
    SERVER_CAP_OCR_ORGANIZATION_CODE("vOCJIgkaFtYo", "6"),        // 智能身份核验平台_服务端_ocr_组织机构代码
    SERVER_CAP_OCR_VEHICLE_LICENSE("mbRJBrUhHwOo", "7"),          // 智能身份核验平台_服务端_ocr_行驶证
    SERVER_CAP_OCR_DRIVER_LICENSE("oItxwLJnaFKd", "8"),           // 智能身份核验平台_服务端_ocr_驾驶证
    SERVER_CAP_OCR_CAR_SALES_INVOICE("svQMDOKYpIbk", "9"),        // 智能身份核验平台_服务端_ocr_机动车统一销售发票
    SERVER_CAP_OCR_MEDICAL_DOC("ICenRMSacAyu", "10"),             // 智能身份核验平台_服务端_ocr_医疗票据
    SERVER_CAP_OCR_VAT_INVOICE("fDMrCcRtSxju", "11"),             // 智能身份核验平台_服务端_ocr_识别增值税发票
    SERVER_CAP_OCR_BANK_ACCOUNT("LKQilIMjNBAv", "12"),            // 智能身份核验平台_服务端_ocr_识别银行开户证明
    SERVER_CAP_OCR_DIPLOMA("kHsMCLqzvZrt", "13"),                 // 智能身份核验平台_服务端_ocr_学历证明
    SERVER_CAP_OCR_MARRIAGE_CERT("crCEVetUqSPu", "14"),           // 智能身份核验平台_服务端_ocr_识别结婚证
    SERVER_CAP_OCR_CHINESE_PASSPORT("KwdianVyeBkh", "15"),        // 智能身份核验平台_服务端_ocr_中国护照证
    SERVER_CAP_OCR_HK_IDCARD("TfpkbDeSUvWE", "16"),               // 智能身份核验平台_服务端_ocr_识别香港身份证
    SERVER_CAP_OCR_PASSPORT_MRZ("ihlWtjgokdMD", "17"),            // 智能身份核验平台_服务端_ocr_世界护照
    SERVER_CAP_OCR_GENERAL_HANDWRITING("yhUivPbWZluc", "18"),     // 智能身份核验平台_服务端_ocr_通用文字手写体
    SERVER_CAP_OCR_GENERAL_PRINT("AGmuhBQCqFtY", "19"),           // 智能身份核验平台_服务端_ocr_通用文字印刷体


//    SERVER_CAP_OCR_LICENSE("WTgbAGlyCoYR"),   // 智能身份核验平台_服务端_ocr_证件
//    SERVER_CAP_OCR_TICKET("lYTjaniNtFzK"),    // 智能身份核验平台_服务端_ocr_票据
    ;
    
    private String key;
    private String ocrAuthCode;
    
    CapabilityEnum(String key, String ocrAuthCode) {
        this.key = key;
        this.ocrAuthCode = ocrAuthCode;
    }
    
    
    public static CapabilityEnum capabilityOfKey(String key) {
        return Arrays.stream(CapabilityEnum.values()).filter(e -> e.key.equals(key)).findFirst().orElse(null);
    }
    
    public static CapabilityEnum capabilityOfOCRAuthCode(String ocrAuthCode) {
        return Arrays.stream(CapabilityEnum.values())
                .filter(e -> (e.ocrAuthCode != null && !"".equalsIgnoreCase(e.ocrAuthCode)))
                .filter(e -> ocrAuthCode.equalsIgnoreCase(e.ocrAuthCode))
                .findFirst().orElse(null);
    }
    
    
}


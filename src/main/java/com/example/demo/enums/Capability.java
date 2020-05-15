package com.example.demo.enums;

import lombok.Data;

/**
 * @Author: Cirmons
 * @Date: 2020-05-12
 */
@Data
public class Capability {
    Integer server_cap_1v1 = 1;                     // 智能身份核验平台_服务器_1v1
    Integer server_cap_1vn = 1;                     // 智能身份核验平台_服务器_1vn
    Integer server_cap_attribute = 0;               // 智能身份核验平台_服务器_人脸属性
    Integer server_cap_fakeface = 0;                // 智能身份核验平台_服务器_人脸单图防伪
    Integer server_cap_liveness = 1;                // 智能身份核验平台_服务器_交互活体_H5
    Integer server_cap_silent;                  // 智能身份核验平台_服务器_静默活体_H5
    Integer server_cap_quality;                 // 智能身份核验平台_服务器_图像质量
    Integer server_cap_datasafe;                // 智能身份核验平台_服务器_数据安全
    Integer server_cap_1v1_channel;             // 智能身份核验平台_服务器_1v1_渠道版
    Integer server_cap_1vn_channel;             // 智能身份核验平台_服务器_1vn_渠道版
    Integer server_cap_1v1_channel_basic;       // 智能身份核验平台_服务器_1v1_渠道入门版
    Integer server_cap_1vn_channel_basic;       // 智能身份核验平台_服务器_1vn_渠道入门版
}
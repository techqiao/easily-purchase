package com.epc.ossfile.domain;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "oss.qiniu.private")
@Data
public abstract class OssConfig {
    //oss 绑定的域名
    private String domain;
    //oss 路径前缀
    private String prefix;
    //oss ACCESS_KEY
    private String accessKey;
    //oss SECRET_KEY
    private String secretKey;
    //oss 存储空间名
    private String bucketName;
    // oss 凭证有效时间
    private String expireInSeconds;
}

package com.epc.ossutil.domain;

import com.qiniu.util.Auth;
import com.qiniu.util.StringMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * @author SongXing
 * @Description: 对象存储自动配置对象
 * @date ${date} ${time}
 */
// fixme 使用 spring 完成自動配置
public class OssTokenUtil {
    private static Logger logger = LoggerFactory.getLogger(OssTokenUtil.class);
    private static final String accessKey = "kGDUh3Ti7cpDCVGhMyOo708aP9H9LufVmgTeglKB";
    private static final String secretKey = "T3ORxW3zrNLL8tccld7ZUUKr8Rc158K2oxfoVPoH";

    private static final String bucket = "epc1688";
    private static final String domainOfBucket = "http://pf1bzqxm0.bkt.clouddn.com";
    private static final long expireInSeconds = 5*60; //token 5分钟 过期

    StringMap upPolicy = new StringMap();


    public static String getUpToken(){
        Auth auth = Auth.create(accessKey, secretKey);
        String upToken = auth.uploadToken(bucket,null,expireInSeconds,null);
        return upToken;
    }

    public static String getPrivatePath(String fileKey){
        Auth auth = Auth.create(accessKey, secretKey);

        String encodedFileName = null;
        try {
            encodedFileName = URLEncoder.encode(fileKey, "utf-8");
        } catch (UnsupportedEncodingException e) {
            logger.error("取文件时 URI 报错{0}",e.getMessage());
        }

        String publicUrl = String.format("%s/%s", domainOfBucket, encodedFileName);
        String finalUrl = auth.privateDownloadUrl(publicUrl, expireInSeconds);
        return finalUrl;
    }
}

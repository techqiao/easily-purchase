package com.epc.ossutil.test;


import com.qiniu.util.Auth;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class TestDownLoad {
    public static void main(String[] args) throws UnsupportedEncodingException {

        String domainOfBucket = "http://pf1bzqxm0.bkt.clouddn.com";
        // 客户端入参
        String fileName = "1.jpg";// userid




        String encodedFileName = URLEncoder.encode(fileName, "utf-8");
        String publicUrl = String.format("%s/%s", domainOfBucket, encodedFileName);
       // System.out.println(publicUrl);

        String accessKey = "kGDUh3Ti7cpDCVGhMyOo708aP9H9LufVmgTeglKB";
        String secretKey = "T3ORxW3zrNLL8tccld7ZUUKr8Rc158K2oxfoVPoH";
        String bucket = "epc1688";

        Auth auth = Auth.create(accessKey, secretKey);
        long expireInSeconds = 5*60; //5分钟 过期
        String finalUrl = auth.privateDownloadUrl(publicUrl, expireInSeconds);
        System.out.println(finalUrl);
    }
}

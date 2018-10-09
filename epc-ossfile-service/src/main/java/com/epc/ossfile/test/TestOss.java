package com.epc.ossfile.test;

import com.qiniu.util.Auth;
import com.qiniu.util.StringMap;

public class TestOss {
    public static void main(String[] args){
        String accessKey = "kGDUh3Ti7cpDCVGhMyOo708aP9H9LufVmgTeglKB";
        String secretKey = "T3ORxW3zrNLL8tccld7ZUUKr8Rc158K2oxfoVPoH";
        String bucket = "epc1688";

        Auth auth = Auth.create(accessKey, secretKey);
        String upToken0 = auth.uploadToken(bucket);
        System.out.println("新增Token"+upToken0);

        // 用于 更新和覆盖的 token
        String fileName = "key";
        String upDateToken1 = auth.uploadToken(bucket, fileName);
        System.out.println("更新Token:"+upDateToken1);
        // 返回格式
        StringMap putPolicy = new StringMap();
        // 自定义上传回复
        putPolicy.put("returnBody", "{\"key\":\"$(key)\",\"hash\":\"$(etag)\",\"bucket\":\"$(bucket)\",\"fsize\":$(fsize)}");

        long expireSeconds = 3600;//到期时间 1小时
        String upToken2 = auth.uploadToken(bucket, null, expireSeconds, putPolicy);

        System.out.println("指定返回格式的token："+upToken2);
    }
}

package com.epc.ossfile.test;

import com.google.gson.Gson;
import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;

public class TestUpload {
    public static void main(String[] args) {
        //构造一个带指定Zone对象的配置类
        Configuration cfg = new Configuration(Zone.zone0());
        //...其他参数参考类注释
        UploadManager uploadManager = new UploadManager(cfg);
        //...生成上传凭证，然后准备上传
        String accessKey = "kGDUh3Ti7cpDCVGhMyOo708aP9H9LufVmgTeglKB";
        String secretKey = "T3ORxW3zrNLL8tccld7ZUUKr8Rc158K2oxfoVPoH";
        String bucket = "epc1688";

        //如果是Windows情况下，格式是 D:\\qiniu\\test.png
        String localFilePath = "D:/fakepath/";
        //默认不指定key的情况下，以文件内容的hash值作为文件名
        String key = "7牛";

        Auth auth = Auth.create(accessKey, secretKey);
        String upToken = auth.uploadToken(bucket);
        System.out.println("上传token"+upToken);
        try {
            // 上传文件 id/userid/fileName
            //        bid/
            // busName.jpg
            Response response = uploadManager.put(localFilePath, key, upToken);
            //解析上传成功的结果
            DefaultPutRet putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);
            System.out.println(putRet.key);
            System.out.println(putRet.hash);
        } catch (QiniuException ex) {
            System.out.println(ex.getMessage());
            ex.getMessage();
            Response r = ex.response;
            System.err.println(r.toString());
            try {
                System.err.println(r.bodyString());
            } catch (QiniuException ex2) {
                //ignore
            }
        }
    }
}

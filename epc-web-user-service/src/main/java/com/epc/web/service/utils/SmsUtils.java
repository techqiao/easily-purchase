package com.epc.web.service.utils;


import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsRequest;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;
import com.epc.web.service.domain.MsgContent;
import com.google.gson.Gson;
import okhttp3.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.awt.*;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;


@Component
public class SmsUtils {
    private static final Logger logger = LoggerFactory.getLogger(SmsUtils.class);
    private static final String url ="http://smssh1.253.com/msg/send/json";
    @Value("${aliyun.access-key-id}")
    private String _accessKeyId;
    @Value("${aliyun.access-key-secret}")
    private String _accessKeySecret;

    public void sendVerifyCode( final String cellphone, final String verifyCode) {
        try {
            System.setProperty("sun.net.client.defaultConnectTimeout", "10000");
            System.setProperty("sun.net.client.defaultReadTimeout", "10000");
            IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", _accessKeyId, _accessKeySecret);
            DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou", "Dysmsapi", "dysmsapi.aliyuncs.com");
            IAcsClient acsClient = new DefaultAcsClient(profile);
            SendSmsRequest request = new SendSmsRequest();
            request.setMethod(MethodType.POST);
            request.setPhoneNumbers(cellphone);
            request.setSignName("易建采");
            request.setTemplateCode("SMS_142945110");
            request.setTemplateParam("{\"code\":\"" + verifyCode + "\"}");
            request.setOutId("yourOutId");
            SendSmsResponse sendSmsResponse = acsClient.getAcsResponse(request);
            if (sendSmsResponse.getCode() != null && sendSmsResponse.getCode().equals("OK")) {
                logger.warn("[发送短信] 向手机号{}发送短信成功.", cellphone);
            }
        } catch (Exception e) {
            logger.error("[发送短信] 向手机号{}发送短信失败. e = {}", cellphone, e.getMessage());
        }
    }


    public  void sendVerify( String cellphone,  String verifyCode) {
        Date  date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmm");
        String time=sdf.format(date);
        try {
            MsgContent msgContent = new MsgContent();
            msgContent.setAccount("CN7642221");
            msgContent.setPassword("U7XTxPN4j1014b");
            msgContent.setMsg("尊敬的用户您好，您本次操作的验证码为："+verifyCode+"，请勿泄漏 ！");
            msgContent.setPhone(cellphone);
            msgContent.setSendtime(time);
            msgContent.setReport("true");
            msgContent.setExtend("");
            msgContent.setUid("");
            proxy(msgContent,cellphone,verifyCode);
        } catch (Exception e) {
            logger.error("[发送短信] 向手机号{}发送短信失败. e = {}", cellphone, e.getMessage());
        }
    }

    public void proxy( MsgContent msgContent, String cellphone,  String verifyCode) {
        if (null != msgContent.getMsg() && null != msgContent.getPhone()) {
            Gson gson = new Gson();
            String json = gson.toJson(msgContent);
            OkHttpClient okHttpClient = (new OkHttpClient.Builder()).readTimeout(5L, TimeUnit.SECONDS).writeTimeout(5L, TimeUnit.SECONDS).connectTimeout(60L, TimeUnit.SECONDS).build();
           // RequestBody body = RequestBody.create(MEDIA_TYPE_JSON, json);

            RequestBody body = RequestBody.create(MediaType.parse("application/json"), json);

            Request request = (new okhttp3.Request.Builder()).post(body).url(url).build();
            okHttpClient.newCall(request).enqueue(new Callback() {
                @Override
                public void onFailure(Call call, IOException e) {
                    SmsUtils.logger.error("短信发送失败,e={}", e);
                    sendVerifyCode(cellphone,verifyCode);
                }
                @Override
                public void onResponse(Call call, Response response) throws IOException {
                    String result = response.body().string();
                    SmsUtils.logger.info( cellphone +" :短信发送成功，result={}", result);
                }
            });
        } else {
            logger.error("发送短信出现问题,msgContent={} ", msgContent.toString());
        }
    }

    public static void mains(String[] args){
        //new SmsUtils().sendVerify("13554199936‬","234233");
        String str = "133 0712 5915";
        String nstr= str.replaceAll("[^0-9a-zA-Z\u4e00-\u9fa5.，,。？“”]+","");

        System.out.println(nstr);

        Date  date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmm");
        String time=sdf.format(date);

        System.out.println(time);


    }

}

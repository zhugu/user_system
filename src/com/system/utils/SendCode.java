package com.system.utils;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsRequest;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;

import java.util.Random;

/**
 * @author 缪瑞祥
 */
public class SendCode {
    public static SendSmsResponse sendSms(String phoneNumber, String code) throws ClientException {
        System.setProperty("sun.net.client.defaultConnectTimeout", "10000");//不必修改
        System.setProperty("sun.net.client.defaultReadTimeout", "10000");//不必修改
        IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", "***", "***");//"***"分别填写自己的AccessKey ID和Secret
        DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou", "Dysmsapi", "dysmsapi.aliyuncs.com");//不必修改
        IAcsClient acsClient = new DefaultAcsClient(profile);//不必修改
        SendSmsRequest request = new SendSmsRequest();//不必修改
        request.setPhoneNumbers(phoneNumber);//****处填写接收方的手机号码
        request.setSignName("企业管理系统登录验证");//此处填写已申请的短信签名
        request.setTemplateCode("SMS_116562357");//此处填写获得的短信模版CODE
        request.setTemplateParam("{\"code\":\""+code+"\"}");//笔者的短信模版中有${code}, 因此此处对应填写验证码
        SendSmsResponse sendSmsResponse = acsClient.getAcsResponse(request);//不必修改
        return sendSmsResponse;
    }
//    public static void main(String[] args) throws ClientException, InterruptedException {
//        Random random = new Random();
//        StringBuffer captcha = new StringBuffer();
//        for (int i = 0;i<6;i ++){
//            captcha.append(random.nextInt(10));
//        }
//        SendSmsResponse response = sendSms("15195226887",captcha.toString());
//    }
}

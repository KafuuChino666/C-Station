package cn.o0u0o.service.sms.service.Impl;

import cn.o0u0o.service.sms.service.SmsService;
import cn.o0u0o.service.sms.util.SmsProperties;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsRequest;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class SmsServiceImpl implements SmsService {

    final String domain = "dysmsapi.aliyuncs.com";//短信API产品域名（接口地址固定，无需修改）
    final String product = "Dysmsapi";//短信API产品名称（短信产品名固定，无需修改）

    @Autowired
    private SmsProperties smsProperties;

    @Override
    public void send(String mobile, String checkCode) throws ClientException {
        //初始化ascClient,暂时不支持多region（请勿修改）
        IClientProfile profile = DefaultProfile.getProfile(smsProperties.getRegionId(), smsProperties.getKeyId(),
                smsProperties.getKeySecret());
        DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou", product, domain);
        IAcsClient acsClient = new DefaultAcsClient(profile);

        //组装请求对象
        SendSmsRequest request = new SendSmsRequest();
        //使用post提交
        request.setMethod(MethodType.POST);
        //必填:待发送手机号。
        request.setPhoneNumbers(mobile);
        //必填:短信签名-可在短信控制台中找到
        request.setSignName(smsProperties.getSignName());
        //必填:短信模板-可在短信控制台中找到，发送国际/港澳台消息时，请使用国际/港澳台短信模版
        request.setTemplateCode(smsProperties.getTemplateCode());
        //可选:模板中的变量替换JSON串,如模板内容为"亲爱的${name},您的验证码为${code}"时,此处的值为
        //友情提示:如果JSON中需要带换行符,请参照标准的JSON协议对换行符的要求,比如短信内容中包含\r\n的情况在JSON中需要表示成\\r\\n,否则会导致JSON在服务端解析失败
        //参考：request.setTemplateParam("{\"变量1\":\"值1\",\"变量2\":\"值2\",\"变量3\":\"值3\"}")
        request.setTemplateParam("{\"code\":\"" + checkCode +"\"}");

        //请求失败这里会抛ClientException异常
        SendSmsResponse sendSmsResponse = acsClient.getAcsResponse(request);
        if(sendSmsResponse.getCode() == null && !sendSmsResponse.getCode().equals("OK")) {
            log.info("短信发送错误!sendSmsResponseCode:" + sendSmsResponse.getCode() + ", message:" + sendSmsResponse.getMessage());
        }

        if ("isv.BUSINESS_LIMIT_CONTROL".equals(sendSmsResponse.getCode())) {
            log.error("短信发送过于频繁 " + "【code】" + sendSmsResponse.getCode() + ", 【message】" + sendSmsResponse.getMessage());
        }
    }
}

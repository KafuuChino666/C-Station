package cn.o0u0o.service.sms.service;

import com.aliyuncs.exceptions.ClientException;

public interface SmsService {
    void send(String mobile, String checkCode) throws ClientException;
}

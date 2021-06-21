package cn.o0u0o.service.sms.util;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.io.StringWriter;

/**
 * @author Guo Yangyang
 * @version 1.0
 * @date 2021/6/21 19:01
 */
public class JavaMailSenderUtil {

    public static Object sendGeneralMail(JavaMailSender mailSender, String formMail, String toMail, String subject, String txt) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(formMail);
        message.setTo(toMail);
        message.setSubject(subject);
        message.setText(txt);

        mailSender.send(message);
        return null;
    }

    public static void sendTemplateMail(Configuration configuration,JavaMailSender mailSender, String formMail, String toMail, String subject, Object model) throws IOException, TemplateException, MessagingException {
        // 配置模版文件
        Template template = configuration.getTemplate("authCode.ftl");

        // 结合 Object 对象渲染模版
        String html = FreeMarkerTemplateUtils.processTemplateIntoString(template, model);

        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper=new MimeMessageHelper(message,false,"utf8");
        helper.setFrom(formMail);
        helper.setTo(toMail);
        helper.setSubject(subject);
        helper.setText(html, true);

        mailSender.send(message);
    }

}

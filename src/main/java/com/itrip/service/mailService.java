package com.itrip.service;

import com.itrip.dao.ItripUserMapper;
import com.itrip.model.ItripUser;
import org.mybatis.logging.Logger;
import org.mybatis.logging.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeUtility;
import java.io.File;
import java.util.List;


@Service
public class mailService {
    @Value("${spring.mail.username}")
    private String from;
    @Autowired
    private JavaMailSender mailSender;
    @Autowired
    private ItripUserMapper iudao;
    Logger logger = LoggerFactory.getLogger(this.getClass());

    public void sendSimpleMail(String to,String title,String content){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(from);
        message.setTo(to);
        message.setSubject(title);
        message.setText(content);
        mailSender.send(message);
        System.out.println("邮件发送成功");
    }

    public void sendAttachmentsMail(String to, String title, String cotent, List<File> fileList){
        MimeMessage message = mailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(message,true);
            helper.setFrom(from);
            helper.setTo(to);
            helper.setSubject(title);
            helper.setText(cotent);
            String fileName = null;
            for (File file:fileList) {
                fileName = MimeUtility.encodeText(file.getName(), "GB2312", "B");
                helper.addAttachment(fileName, file);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        mailSender.send(message);
        System.out.println("邮件发送成功");
    }

    public boolean addUser(String usercode,String password,Integer code){
        ItripUser user = new ItripUser();
        user.setUsercode(usercode);
        user.setUserpassword(password);
        user.setCode(code);
        user.setUsername(usercode);
        return iudao.insert(user)>0?true:false;
    }

    public boolean addPhoneUser(String phone,String password,Integer code){
        ItripUser user = new ItripUser();
        user.setUsercode(phone);
        user.setUserpassword(password);
        user.setCode(code);
        user.setUsername(phone);
        return iudao.insert(user)>0?true:false;
    }
}

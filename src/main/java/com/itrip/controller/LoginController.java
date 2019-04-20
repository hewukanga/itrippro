package com.itrip.controller;

import com.itrip.utils.HttpUtils;
import org.apache.http.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.itrip.service.mailService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Controller
public class LoginController {
    @Autowired
    private mailService mailService;

    @RequestMapping("index")
    public String index(){
        return "index.html";
    }

    @RequestMapping("getCheckCode")
    @ResponseBody
    public String a(String email){
        String checkCode = String.valueOf(new Random().nextInt(899999) + 100000);
        String message = "您的注册验证码为："+checkCode;
        try {
            mailService.sendSimpleMail(email, "注册验证码", message);
        }catch (Exception e){
            return "";
        }
        return checkCode;
    }

    /** 短信验证注册
     * @param phone   手机号
     * @return
     */
    @RequestMapping("duanxin")
    @ResponseBody
    public String duanxin(String phone){
        String code = String.valueOf(new Random().nextInt(899999) + 100000);
        String host = "http://dingxin.market.alicloudapi.com";
        String path = "/dx/sendSms";
        String method = "POST";
        String appcode = "7bb1237fe1214b6d98212442325bfe19";
        Map<String, String> headers = new HashMap<String, String>();
        //最后在header中的格式(中间是英文空格)为Authorization:APPCODE 83359fd73fe94948385f570e3c139105
        headers.put("Authorization", "APPCODE " + appcode);
        Map<String, String> querys = new HashMap<String, String>();
        querys.put("mobile", phone);
        querys.put("param", "code:"+code);
        querys.put("tpl_id", "TP1711063");
        Map<String, String> bodys = new HashMap<String, String>();
        try {
            /**
             * 重要提示如下:
             * HttpUtils请从
             * https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/src/main/java/com/aliyun/api/gateway/demo/util/HttpUtils.java
             * 下载
             *
             * 相应的依赖请参照
             * https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/pom.xml
             */
            HttpResponse response = HttpUtils.doPost(host, path, method, headers, querys, bodys);
            System.out.println(response.toString());
            //获取response的body
            //System.out.println(EntityUtils.toString(response.getEntity()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return code;
    }

    @ResponseBody
    @RequestMapping("addUser")
    public boolean addUser(String usercode,String password,Integer code){
        System.out.println(usercode+password+code);
        boolean b = mailService.addUser(usercode,password,code);
        return b;
    }

    @ResponseBody
    @RequestMapping("addPhoneUser")
    public boolean addPhoneUser(String phone,String password,Integer code){
        boolean b = mailService.addPhoneUser(phone,password,code);
        return b;
    }
}

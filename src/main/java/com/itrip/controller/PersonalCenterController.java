package com.itrip.controller;

import com.itrip.model.Evaluate;
import com.itrip.model.ItripHotelOrder;
import com.itrip.model.ItripUser;
import com.itrip.service.PersonalCenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class PersonalCenterController {
    @Autowired
    private PersonalCenterService pservice;

    @RequestMapping("personalcenter")
    public String personalcenter(@RequestParam("userid") Integer userid, HttpSession session){
        ItripUser user  = pservice.findbyid(userid);
        List<ItripHotelOrder> list = pservice.findbyuserid(new Long((long)userid));//用户酒店订单 查到用户所有的酒店订单
        List<Evaluate> list1 = new ArrayList<Evaluate>();//评论
        for(int i =0;i<list.size();i++) {//
            Long hid = list.get(i).getId();//得到酒店订单id
            Evaluate e = pservice.findbyhid(hid);
            if(e!=null){
                list1.add(e);
            }
        }
        session.setAttribute("list1",list1);
        session.setAttribute("user",user);
        return "personal/Usercenter";
    }
}

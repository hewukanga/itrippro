package com.itrip.controller;

import com.github.pagehelper.PageInfo;
import com.itrip.model.ItripHotel;
import com.itrip.service.ItripHotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class HotelController {
    @Autowired
    private ItripHotelService hotelService;

    @RequestMapping("seleHotels")
    public String selectHotels(HttpSession session,String name, int hotellevel, String details, @RequestParam(value = "pageNo",defaultValue = "1") int pageNo, @RequestParam(value = "pageSize",defaultValue = "9")int pageSize){
        PageInfo<ItripHotel> page=hotelService.findBy(name,hotellevel,details,pageNo,pageSize);
        session.setAttribute("page",page);
        return "tavern/tavern_list.html";
    }
}

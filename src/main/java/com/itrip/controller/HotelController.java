package com.itrip.controller;

import com.github.pagehelper.PageInfo;
import com.itrip.model.*;
import com.itrip.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class HotelController {
    @Resource
    private ItripHotelService hotelService;
    @Resource
    private HotelRoomService hotelRoomService;
    @Resource
    private LabelDicService labelDicService;
    @Resource
    private CommentService commentService;
    @Resource
    private HotelViewService hotelViewService;
    @Resource
    private ItripDicService dicService;
    @Resource
    private UserService userService;


    @RequestMapping("/seleHotels")
    public String selectHotels( HttpSession session, Model model, HttpServletRequest request){
        String name=request.getParameter("name");
        String s=request.getParameter("hotellevel");
        int hotellevel=0;
        if(s!=null){
            hotellevel=Integer.parseInt(s);
        }
        String details=request.getParameter("details");
        //条件查询酒店
        List<ItripHotel> list=hotelService.findBy(name,hotellevel,details);
        //视图查询
        List<HotelView> hotelViews=new ArrayList<>();
        for (int i=0;i<list.size();i++) {
            HotelView view=hotelViewService.findHotel(list.get(i).getId());
            hotelViews.add(view);
        }
        session.setAttribute("views",hotelViews);
        session.setAttribute("hotels",list);
        session.setAttribute("cityname",name);
        return "tavern_list";
    }

    /**
     * 产看酒店详情
     * @return
     */
    @RequestMapping("/hotelDetail")
    public String hotelDetail(HttpServletRequest request,Model model,String hotelname){
        //根据酒店名称查看酒店详情
        ItripHotel hotel=hotelService.findDetail(hotelname);
        //查看酒店房间
        List<ItripHotelRoom> rooms=hotelRoomService.findByHotel(hotel.getId());
        //查看酒店评论
        List<ItripComment> comments=commentService.findByHotel(hotel.getId());
        List<ItripUser> users=new ArrayList<>();
        for (int i=0;i<comments.size();i++){
            ItripUser user=userService.findUser(comments.get(i).getUserid());
            users.add(user);
        }
       // List<ItripHotelRoom>
        model.addAttribute("hotel",hotel);
        model.addAttribute("rooms",rooms);
        model.addAttribute("comments",comments);
        model.addAttribute("users",users);
        return "hotelDetail";
    }

    @RequestMapping("/tavernindex")
    public String taverindex(Model model,Long cityid){
        //查找海外城市酒店
        List<HotelView> seacity=hotelViewService.findBy(3657);
        model.addAttribute("seacity",seacity);
        List<ItripAreaDic> seadic=dicService.findSea();
        model.addAttribute("seadic",seadic);
        //查找热门城市酒店
        List<HotelView> hotcity=hotelViewService.findBy(2);
        model.addAttribute("hotcity",hotcity);
        List<ItripAreaDic> hotdic=dicService.findHot();
        model.addAttribute("hotdic",hotdic);
        return "tavernindex";
    }

//    @RequestMapping("/selectindex")
//    public String hotelindex(){
//        return "";
//    }
}

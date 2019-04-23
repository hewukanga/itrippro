package com.itrip.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class JumpController {

    @RequestMapping("index")
    public String index(){
        return "index";
    }

    @RequestMapping("/tavernindex")
    public String taverindex(){
        return "tavernindex";
    }


    @RequestMapping("/travelindex")
    public String travelindex(){
        return "travelindex";
    }


    @RequestMapping("/strategyindex")
    public String strategyindex(){
        return "strategyindex";
    }

    @RequestMapping("/flyticket")
    public String flyticket(){
        return "flyTicket";
    }

    @RequestMapping("/login")
    public String login(){
        return "login";
    }

    @RequestMapping("/register")
    public String register(){
        return "register";
    }
}

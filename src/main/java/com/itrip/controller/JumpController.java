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
        return "tavern/index";
    }


    @RequestMapping("/travelindex")
    public String travelindex(){
        return "travel/index";
    }


    @RequestMapping("/strategyindex")
    public String strategyindex(){
        return "strategy/index";
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

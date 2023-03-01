package com.starry_sky.yang.controller;

import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
public class demoController {

    @RequestMapping("/demo")
    public String demo(Model model){
        System.out.println("hello,world");
        model.addAttribute("msg","hello,thymeleaf");
        return "demo";
    }



//    @RequestMapping("/login")
//    public String login(){
//        return "login";
//    }
}

package com.meandbooksteam2.shoppingmall.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
public class MainController {

    @GetMapping("/")
    public String main(HttpSession session){
        System.out.println(session.getAttribute("mem_no"));
        System.out.println(session.getAttribute("isAdmin"));
        return "index";
    }

    @GetMapping("/index")
    public String index(HttpSession session){
        System.out.println(session.getAttribute("mem_uid"));
        System.out.println(session.getAttribute("isAdmin"));
        return "redirect: ";
    }
}

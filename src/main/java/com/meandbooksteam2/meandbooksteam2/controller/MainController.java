package com.meandbooksteam2.meandbooksteam2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/")
    public String main(){
        return "index";
    }

    @GetMapping("/index")
    public String index(){
        return "redirect: ";
    }
}

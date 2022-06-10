package com.meandbooksteam2.shoppingmall.controller;

import com.meandbooksteam2.shoppingmall.service.mall.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
public class MainController {
    /*추천도서를 db에서 받아오기위해 의존 주입*/
    BookService service;
    @Autowired
    public void setService(BookService service) {
        this.service = service;
    }

    @GetMapping("/")
    public String main(HttpSession session, Model model){
        model.addAttribute("best",service.getRandomBest());
        model.addAttribute("mon_sp",service.getMonthlySpecial());
        return "index";
    }

    @GetMapping("/index")
    public String index(HttpSession session){
        System.out.println(session.getAttribute("mem_uid"));
        System.out.println(session.getAttribute("mem_no"));
        System.out.println(session.getAttribute("isAdmin"));
        return "redirect: ";
    }
}

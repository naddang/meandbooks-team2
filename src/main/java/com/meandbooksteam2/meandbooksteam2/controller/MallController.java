package com.meandbooksteam2.meandbooksteam2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/*책관련 페이지들의 요청을 처리하는 Controller 클래스입니다*/
@Controller
public class MallController {

    @GetMapping("/mall/bestSeller")
    public String bestSeller(){
        return "/mall/bestSell";
    }

    @GetMapping("/mall/bestCate")
    public String bestCate(){
        return "/mall/bestCate";
    }

    @GetMapping("/mall/bookInfo")
    public String bookInfo(){
        return "/mall/bookInfo";
    }

    @GetMapping("/mall/searchBook")
    public String searchBook(){
        return "/mall/searchBook";
    }

    @GetMapping("/mall/searchResult")
    public String searchResult(){
        return "/mall/searchResult";
    }
}

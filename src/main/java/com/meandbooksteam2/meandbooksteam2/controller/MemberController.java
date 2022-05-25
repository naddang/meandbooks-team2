package com.meandbooksteam2.meandbooksteam2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/*개인정보 관련 페이지들의 요청을 처리하는 Controller 클래스입니다*/
@Controller
public class MemberController {

    @GetMapping("/member/main")
    public String main(){
        return "/member/main";
    }

    @GetMapping("/member/cart")
    public String cart(){
        return "/member/cart";
    }

    @PostMapping("/member/login")
    public String login(){
        return "/member/login";
    }

    @GetMapping("/member/myOrders")
    public String myOrders(){
        return "/member/myOrders";
    }

    @PostMapping("/member/register")
    public String register(){
        return "/member/register";
    }

    @PostMapping("/member/updateMember")
    public String updateMember(){
        return "/member/updateMember";
    }
}

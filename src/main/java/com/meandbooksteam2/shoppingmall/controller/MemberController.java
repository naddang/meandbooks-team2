package com.meandbooksteam2.shoppingmall.controller;

import com.meandbooksteam2.shoppingmall.service.member.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;

/*개인정보 관련 페이지들의 요청을 처리하는 Controller 클래스입니다*/
@Controller
public class MemberController {

    //의존 주입
    MemberService service;
    @Autowired
    public void setService(MemberService service) {this.service = service;}

    @GetMapping("member/main")
    public String main(){
        return "member/main";
    }

    @GetMapping("member/cart")
    public String cart(HashMap<String, String> param, Model model){
        return "member/cart";
    }

    @GetMapping("member/login")
    public String login(){
        return "member/login";
    }

    @PostMapping("member/login_ok")
    public String loginOk(@RequestParam HashMap<String, String> param, HttpServletRequest request) {
        int loginResult = service.login(param);
        if (loginResult == 1) {
            HttpSession session = request.getSession();
            session.setAttribute("mem_uid", param.get("mem_uid"));
            session.setAttribute("isAdmin", service.isAdmin(param.get("mem_uid")));

            return "redirect:/index";
        }else {
            return "redirect:login";
        }
    }

    @GetMapping("member/myOrders")
    public String myOrders(HttpSession session, Model model){

        String mem_uid = (String)session.getAttribute("mem_uid");
        model.addAttribute("list", service.listMyOrders(mem_uid));

        return "member/myOrders";
    }

    @GetMapping("member/register")
    public String register(){

        return "member/register";
    }

    @PostMapping("member/register_ok")
    public String registerOk(@RequestParam HashMap<String, String> param){

        int re = service.register(param);

        if (re == 1) {
            return "member/login";
        }
        else {
            return "member/register";
        }
    }

    @PostMapping("member/updateMember")
    public String updateMember(HttpSession session, Model model){
        String mem_uid = (String) session.getAttribute("mem_uid");
        service.updateMyInfo(mem_uid);
        return "member/updateMember";
    }
}

package com.meandbooksteam2.shoppingmall.controller;

import com.meandbooksteam2.shoppingmall.dto.OrdersDto;
import com.meandbooksteam2.shoppingmall.service.member.CartService;
import com.meandbooksteam2.shoppingmall.service.member.MemberService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;

/*개인정보 관련 페이지들의 요청을 처리하는 Controller 클래스입니다*/
@Controller
public class MemberController {

    //의존 주입
    MemberService service;
    CartService cartService;

    @Autowired
    public void setCartService(CartService cartService) {
        this.cartService = cartService;
    }

    @Autowired
    public void setService(MemberService service) {this.service = service;}

    @GetMapping("member/main")
    public String main(){
        return "member/memberMain";
    }

    @GetMapping("member/cart")
    public String cart(Model model, HttpSession session){
        String mem_no = (String)session.getAttribute("mem_no");

        model.addAttribute("list", cartService.listCart(mem_no));
        return "member/cart";
    }

    @GetMapping("member/updateCart")
    public String updateCart(HashMap<String, String> param) {
        int re = cartService.updateCartStatus(param);

        if (re == 1){
            return "redirect:member/cart";
        }else {
            return "redirect:error";
        }
    }

    @GetMapping("member/deleteCart")
    public String deleteCart(@RequestParam HashMap<String, String> param) {
        int re = cartService.deleteCart(param);
        if (re == 1){
            return "redirect:/member/cart";
        }else {
            return "redirect:error";
        }
    }

    @GetMapping("member/login")
    public String login(){
        return "member/login";
    }

    @PostMapping("member/login_ok")
    public String loginOk(@RequestParam HashMap<String, String> param, HttpSession session) {
        int loginResult = service.login(param);
        if (loginResult == 1) {
            session.setAttribute("mem_no", service.getMemNo(param));
            session.setAttribute("isAdmin", service.isAdmin(param.get("mem_uid")));
            session.setAttribute("mem_uid", param.get("mem_uid"));

            return "redirect:/index";
        }else {
            return "redirect:login";
        }
    }
    @GetMapping("member/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "redirect:/index";
    }

    @GetMapping("member/myOrders")
    public String myOrders(HttpSession session, Model model){

        String mem_no = (String)session.getAttribute("mem_no");
        model.addAttribute("list", service.listMyOrders(mem_no));

        return "member/myOrders";
    }

    @GetMapping("member/viewOrders")
    public String viewOrders(@RequestParam HashMap<String, String> param, Model model){

        model.addAttribute("orders", service.viewMyOrder(param));

        return "member/viewOrders";
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

    @GetMapping("member/updateMember")
    public String updateMember(HttpSession session, Model model){
        String mem_no = (String) session.getAttribute("mem_no");
        model.addAttribute("member", service.viewMyInfo(mem_no));
        return "member/myInfo";
    }

    @PostMapping("member/updateMember_ok")
    public String updateMember_ok(@RequestParam HashMap<String, String> param, HttpSession session){
        //세션에 있는 사용자가 정상적으로 접근했는지 체크함
        int re = service.login(param);

        if (re == 1) {
            //몇 건이 수정되었는지 re에 담음
            re = service.updateMyInfo(param);
            //정상적으로 한 건이 수정된 경우
            if (re == 1) {
                return "redirect:/member/main";
            //결과에 문제가 있는 경우
            }else {
                return "redirect:/error";
            }
        }else {
            return "redirect:/error";
        }
    }
    @GetMapping("member/withdraw")
    public String withdraw(HttpSession session){
        return "member/withdraw";
    }

    @PostMapping("member/withdraw_ok")
    public String withdrawOk(HttpSession session, @RequestParam String mem_pwd){
        String mem_no = (String)session.getAttribute("mem_no");
        System.out.println(mem_no);
        System.out.println(mem_pwd);
        int re = service.withdraw(mem_no, mem_pwd);

        if (re == 1) {
            session.invalidate();

            return "redirect:/index";
        }

        return "member/withdraw";
    }

    /*비회원 주문 조회*/
    @GetMapping("member/viewNoMemOrder")
    public String viewNoMemOrder(@RequestParam HashMap<String, String> param, Model model) {
        model.addAttribute("orders", service.viewNoMemOrder(param));
        return "member/viewNoMemOrder";
    }

    @GetMapping("member/registerCheckId")
    public String registerCheckId(@RequestParam String mem_uid, Model model){
        System.out.println(service.checkId(mem_uid));
        model.addAttribute("check", service.checkId(mem_uid));

        return "member/registerCheckId";
    }
}

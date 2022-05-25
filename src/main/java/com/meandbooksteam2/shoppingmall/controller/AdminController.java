package com.meandbooksteam2.shoppingmall.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/*관리자 페이지들의 요청을 처리하는 Controller 클래스입니다*/
@Controller
public class AdminController {

    @GetMapping("/admin")
    public String menu(){
        return "/admin/menu";
    }

    @GetMapping("/admin/book")
    public String bookMenu(){
        return "/admin/book/menu";
    }

    @GetMapping("/admin/book/addBook")
    public String addBook(){
        return "/admin/book/addBook";
    }

    @GetMapping("/admin/book/updateBook")
    public String updateBook(){
        return "/admin/book/updateBook";
    }

    @GetMapping("/admin/member")
    public String listMember(){
        return "/admin/member/listMember";
    }

    @GetMapping("/admin/member/updateMember")
    public String updateMember(){
        return "/admin/member/updateMember";
    }

    @GetMapping("/admin/orders")
    public String listOrders(){
        return "/admin/orders/listOrders";
    }

    @GetMapping("/admin/orders/updateOrders")
    public String updateOrders(){
        return "/admin/orders/updateOrders";
    }
}

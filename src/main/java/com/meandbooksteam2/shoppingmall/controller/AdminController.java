package com.meandbooksteam2.shoppingmall.controller;

import com.meandbooksteam2.shoppingmall.dto.BookDto;
import com.meandbooksteam2.shoppingmall.service.admin.ManageBookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*관리자 페이지들의 요청을 처리하는 Controller 클래스입니다*/
@Controller
public class AdminController {

    @Autowired
    ManageBookServiceImpl bookService;

    @GetMapping("admin")
    public String adminMain(){
        return "admin/adminMain";
    }

    @GetMapping("admin/book")
    public String bookMenu(@RequestParam HashMap<String, String> param, Model model){
        List<BookDto> bookList = bookService.bookList(param);
        model.addAttribute("bookList", bookList);
        return "admin/book/listBook";
    }

    @PostMapping("admin/book/insertBook")
    public String insertBook(@RequestParam HashMap<String, String> param){

        int result = bookService.insertBook(param);

        if (result == 1) {
            return "redirect:admin/book";
        }else {
            return "redirect:admin/book/addBook";
        }
    }

    @GetMapping("admin/book/addBook")
    public String addBook(){
        return "admin/book/addBook";
    }

    @GetMapping("admin/book/updateBook")
    public String updateBook(@RequestParam HashMap<String, String> param){
        return "admin/book/updateBook";
    }

    @GetMapping("admin/book/update")
    public String updateBook(@RequestParam HashMap<String, String> param, Model model){

        int result = bookService.updateBook(param);

        if (result == 1) {
            return "redirect:admin/book";
        }else {
            return "redirect:error";
        }
    }

    @GetMapping("admin/member")
    public String listMember(){
        return "admin/member/listMember";
    }

    @GetMapping("admin/member/updateMember")
    public String updateMember(){
        return "admin/member/updateMember";
    }

    @GetMapping("admin/orders")
    public String listOrders(){
        return "admin/orders/listOrders";
    }

    @GetMapping("admin/orders/updateOrders")
    public String updateOrders(){
        return "admin/orders/updateOrders";
    }
}

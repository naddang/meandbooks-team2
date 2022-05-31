package com.meandbooksteam2.shoppingmall.controller;

import com.meandbooksteam2.shoppingmall.service.mall.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.HashMap;

/*책관련 페이지들의 요청을 처리하는 Controller 클래스입니다*/
@Controller
public class MallController {

    BookService service;
    @Autowired
    public void setService(BookService service) {
        this.service = service;
    }

    @GetMapping("mall")
    public String mall(){
        return "mall/bestSeller";
    }

    @GetMapping("mall/bestSeller")
    public String bestSeller(Model model){
        model.addAttribute("list", service.listAllBest());
        return "mall/bestSeller";
    }

    @GetMapping("mall/bestCate")
    public String bestCate(HashMap<String, String> param, Model model) {
        model.addAttribute("list", service.listCateBest(param));
        return "mall/bestCate";
    }

    @GetMapping("mall/bookInfo")
    public String bookInfo(HashMap<String, String> param, Model model) {
        model.addAttribute("book", service.viewBook(param));
        return "mall/bookInfo";
    }

    @GetMapping("mall/searchBook")
    public String searchBook(){
        return "mall/searchBook";
    }

    @GetMapping("mall/searchResult")
    public String searchResult(HashMap<String, String> param, Model model){
        model.addAttribute("list", service.listMallBook(param));
        return "mall/searchResult";
    }

    @GetMapping("mall/insertCart")
    public String insertCart(HashMap<String, String> param) {
        service.insertCart(param);
        return "redirect:mall/bookInfo?" + param.get("book_no");
    }
}

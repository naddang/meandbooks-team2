package com.meandbooksteam2.shoppingmall.controller;

import com.meandbooksteam2.shoppingmall.service.mall.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
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
        return "redirect:mall/bestSeller";
    }

    @GetMapping("mall/bestSeller")
    public String bestSeller(Model model){
        model.addAttribute("list", service.listAllBest());
        return "mall/bestSeller";
    }

    @GetMapping("mall/bestCate")
    public String bestCate(@RequestParam HashMap<String, String> param, Model model) {
        model.addAttribute("list", service.listCateBest(param));
        return "mall/bestCate";
    }

    @GetMapping("mall/viewBook")
    public String bookInfo(@RequestParam HashMap<String, String> param, Model model) {
        model.addAttribute("book", service.viewBook(param));
        model.addAttribute("reviews", service.listReview(param));
        model.addAttribute("cmts", service.listRevCmt(param));
        return "mall/viewBook";
    }

    @GetMapping("mall/searchBook")
    public String searchBook(){
        return "mall/searchBook";
    }

    @GetMapping("mall/searchResult")
    public String searchResult(@RequestParam HashMap<String, String> param, Model model){
        model.addAttribute("list", service.listMallBook(param));
        return "mall/searchResult";
    }

    @GetMapping("mall/insertCart")
    public String insertCart(@RequestParam HashMap<String, String> param, HttpSession session) {
        if (session.getAttribute("mem_no") == null) {
            return "redirect:/mall/viewBook?book_no=" + param.get("book_no");
        }
        param.put("mem_no", (String)session.getAttribute("mem_no"));
        service.insertCart(param);
        return "redirect:/mall/viewBook?book_no=" + param.get("book_no");
    }
}

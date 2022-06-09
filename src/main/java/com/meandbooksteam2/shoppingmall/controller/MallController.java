package com.meandbooksteam2.shoppingmall.controller;

import com.meandbooksteam2.shoppingmall.dto.BookDto;
import com.meandbooksteam2.shoppingmall.service.mall.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;

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
    public String bestCate() {
        return "mall/bestCate";
    }

    @GetMapping("/mall/bestCateResult")
    public String bestCateResult(@RequestParam HashMap<String, String> param, Model model){
        String category = param.get("category");
        model.addAttribute("category", category);
        model.addAttribute("cateBest", service.listCateBest(param));
        System.out.println(category);
        return "mall/bestCateResult";
    }

    @GetMapping("mall/viewBook")
    public String bookInfo(@RequestParam HashMap<String, String> param, Model model) {
        model.addAttribute("book", service.viewBook(param));
        model.addAttribute("reviews", service.listReview(param));
        model.addAttribute("cmts", service.listRevCmt(param));
        System.out.println(service.listRevCmt(param).size());
        return "mall/viewBook";
    }

    @GetMapping("mall/searchBook")
    public String searchBook(){
        return "mall/searchBook";
    }

    @GetMapping("mall/searchResult")
    public String searchResult(@ModelAttribute("params") BookDto params, Model model){
        List<BookDto> list = service.listMallBook(params);
        model.addAttribute("list", list);

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

    @GetMapping("mall/writeReview")
    public String writeReview(@RequestParam HashMap<String, String> param, Model model) {
        model.addAttribute(service.viewBook(param));
        return "mall/writeReview";
    }

    @PostMapping("mall/insertReview")
    public String insertReview(@RequestParam HashMap<String, String> param) {
        int re = service.insertReview(param);

        if (re == 1) {
            return "redirect:/mall/viewBook?book_no=" + param.get("book_no");
        }else {
            return "error";
        }
    }

    @PostMapping("/mall/insertRevCmt")
    public String insertRevCmt(@RequestParam HashMap<String, String> param) {
        int re = service.insertRevCmt(param);

        if (re == 1) {
            return "redirect:/mall/viewBook?book_no=" + param.get("book_no");
        }else {
            return "error";
        }

    }
}

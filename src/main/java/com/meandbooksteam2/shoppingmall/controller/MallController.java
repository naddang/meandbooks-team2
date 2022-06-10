package com.meandbooksteam2.shoppingmall.controller;

import com.meandbooksteam2.shoppingmall.dto.BookDto;
import com.meandbooksteam2.shoppingmall.service.mall.BookService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
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
    public String bookInfo(@RequestParam HashMap<String, String> param, Model model, HttpSession session) {
        //리뷰 작성 권한을 받아오기위한 변수들
        String mem_no = (String) session.getAttribute("mem_no");
        String book_no = param.get("book_no");

        model.addAttribute("book", service.viewBook(param));//책 정보
        model.addAttribute("reviews", service.listReview(param));//리뷰 목록
        model.addAttribute("cmts", service.listRevCmt(param));//댓글 목록
        System.out.println("리뷰권한 : " + service.reviewAuth(mem_no, book_no));
        System.out.println("댓글 사이즈 : " + service.listRevCmt(param).size());
        model.addAttribute("reviewAuth", service.reviewAuth(mem_no, book_no));//리뷰 작성 권한
        
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
    public String writeReview(@RequestParam HashMap<String, String> param, Model model, HttpSession session) {
        String mem_no = (String) session.getAttribute("mem_no");
        String book_no = param.get("book_no");

        if (service.reviewAuth(mem_no, book_no) == 0) {
            return "redirect:mall/viewBook?book_no=" + book_no;
        }
        model.addAttribute(service.viewBook(param));
        return "mall/writeReview";
    }

    @PostMapping("mall/insertReview")
    public String insertReview(@RequestParam HashMap<String, String> param, HttpSession session) {
        int re = service.insertReview(param);

        String mem_no = (String) session.getAttribute("mem_no");
        String book_no = param.get("book_no");

        if (service.reviewAuth(mem_no, book_no) == 0) {
            return "redirect:mall/viewBook?book_no=" + book_no;
        }

        if (re == 1) {
            return "redirect:/mall/viewBook?book_no=" + param.get("book_no");
        }else {
            return "error";
        }
    }

    @PostMapping("mall/insertRevCmt")
    public String insertRevCmt(@RequestParam HashMap<String, String> param) {
        int re = service.insertRevCmt(param);

        if (re == 1) {
            return "redirect:/mall/viewBook?book_no=" + param.get("book_no");
        }else {
            return "error";
        }

    }

    @GetMapping("mall/updateReview")
    public String updateReview(@RequestParam String rev_no, Model model) throws IOException {
        model.addAttribute("rev", service.getOneRev(rev_no));
        return "mall/updateReview";
    }
    @PostMapping("mall/updateReview_ok")
    public void updateReview_ok(@RequestParam HashMap<String, String> param, HttpServletResponse response) throws IOException {
        int re = service.updateReview(param);

        goBack(response, re);
    }

    @GetMapping("mall/updateRevCmt")
    public void updateRevCmt(@RequestParam HashMap<String, String> param, HttpServletResponse response) throws IOException {
        int re = service.updateRevCmt(param);

        goBack(response, re);
    }

    @GetMapping("mall/deleteReview")
    public void deleteReview(@RequestParam HashMap<String, String> param, HttpServletResponse response) throws IOException {
        int re = service.deleteReview(param);

        goBack(response, re);
    }

    private void goBack(HttpServletResponse response, int re) throws IOException {
        if (re == 1) {
            response.setContentType("text/html; charset=euc-kr");
            PrintWriter out = response.getWriter();
            out.println("<script>");
            out.println("alert('성공했습니다.');");
            out.println("window.location = document.referrer;");
            out.println("</script>");

            out.flush();
        }else {
            response.setContentType("text/html; charset=euc-kr");
            PrintWriter out = response.getWriter();
            out.println("<script>");
            out.println("alert('실패했습니다.');");
            out.println("window.location = document.referrer;");
            out.println("</script>");

            out.flush();
        }
    }

    @GetMapping("mall/deleteRevCmt")
    public void deleteRevCmt(@RequestParam HashMap<String, String> param, HttpServletResponse response) throws IOException {
        int re = service.deleteRevCmt(param);

        goBack(response, re);
    }
}

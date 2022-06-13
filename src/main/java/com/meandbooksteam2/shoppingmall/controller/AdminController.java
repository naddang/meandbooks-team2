package com.meandbooksteam2.shoppingmall.controller;

import com.meandbooksteam2.shoppingmall.dto.*;
import com.meandbooksteam2.shoppingmall.service.admin.ManageBookServiceImpl;
import com.meandbooksteam2.shoppingmall.service.admin.ManageMemberServiceImpl;
import com.meandbooksteam2.shoppingmall.service.admin.ManageOrdersServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

/*관리자 페이지들의 요청을 처리하는 Controller 클래스입니다*/
@Controller
public class AdminController {

    ManageBookServiceImpl bookService;
    ManageOrdersServiceImpl ordersService;
    ManageMemberServiceImpl memberService;

    @Autowired
    public void setBookService(ManageBookServiceImpl bookService) {
        this.bookService = bookService;
    }
    @Autowired
    public void setOrdersService(ManageOrdersServiceImpl ordersService) {
        this.ordersService = ordersService;
    }
    @Autowired
    public void setMemberService(ManageMemberServiceImpl memberService) {
        this.memberService = memberService;
    }


    @GetMapping("admin")
    public String adminMain(HttpSession session){
        if (session.getAttribute("isAdmin").toString().equals("0")) {
            return "redirect:/";
        }
        return "admin/adminMain";
    }

    /*전체 책 목록 리스트*/
    @GetMapping("admin/book")
    public String bookMenu(@ModelAttribute("params") BookDto params, Model model){
        List<BookDto> bookList = bookService.listBook(params);
        model.addAttribute("list", bookList);

        return "admin/book/listBook";
    }

    /*검색 책 목록 리스트*/
    @GetMapping("admin/book/searchBook")
    public String searchBookList(@ModelAttribute("params") BookDto params, Model model) {
        List<BookDto> list = bookService.listSearchBook(params);
        model.addAttribute("list", list);

        return "admin/book/listBook";
    }

//    @GetMapping("admin/book")
//    public String bookMenu(@RequestParam HashMap<String, String> param, Model model){
//        List<BookDto> bookList = bookService.bookList(param);
//        model.addAttribute("bookList", bookList);
//        return "admin/book/listBook";
//    }

    @PostMapping("admin/book/insertBook")
    public String insertBook(@RequestParam HashMap<String, String> param, @RequestParam("book_img") @RequestBody List<MultipartFile> files) throws Exception {
        try{
            //프로젝트 안의 book-imgs 디렉토리에 저장
            for(int i=0;i<files.size();i++){
                files.get(i).transferTo(new File("src/main/resources/static/imgs/book-imgs/"+files.get(i).getOriginalFilename()));
            }
            param.put("book_img", files.get(0).getOriginalFilename());
        }catch (IllegalStateException | IOException e){
            e.printStackTrace();
        }
        bookService.insertBook(param);
        return "redirect:/admin/book";

//        int result = bookService.insertBook(param, multipartHttpServletRequest);
//
//        if (result == 1) {
//            return "redirect:/admin/book";
//        }else {
//            return "redirect:/admin/book/addBook";
//        }
    }

    @GetMapping("admin/book/addBook")
    public String addBook(){
        return "admin/book/addBook";
    }

    @GetMapping("admin/book/updateBook")
    public String updateBook(@RequestParam HashMap<String, String> param, Model model){
        model.addAttribute("view", bookService.viewBook(param));
        return "admin/book/updateBook";
    }

    @GetMapping("admin/book/update_ok")
    public String updateBookOk(@RequestParam HashMap<String, String> param){

        int result = bookService.updateBook(param);

        if (result == 1) {
            return "redirect:/admin/book";
        }else {
            return "redirect:/error";
        }
    }

    @GetMapping("admin/book/delete")
    public String deleteBook(@RequestParam HashMap<String, String> param) {

        int result = bookService.deleteBook(param);

        if (result == 1) {
            return "redirect:/admin/book";
        }else {
            return "redirect:/error";
        }
    }

    /*회원 리스트*/
    @GetMapping("admin/member")
    public String listMember(@ModelAttribute("params") MemberDto params, Model model){

        List<MemberDto> list = memberService.listMember(params);
        model.addAttribute("list", list);

        return "admin/member/listMember";
    }

    /*검색 회원 목록 리스트*/
    @GetMapping("admin/member/searchMember")
    public String searchMemberList(@ModelAttribute("params") MemberDto params, Model model) {
        List<MemberDto> list = memberService.listSearchMember(params);
        model.addAttribute("list", list);

        return "admin/member/listMember";
    }

    @GetMapping("admin/member/updateMember")
    public String updateMember(@RequestParam HashMap<String, String> param, Model model){
        model.addAttribute("member", memberService.viewMember(param));
        return "admin/member/updateMember";
    }

    @GetMapping("admin/member/updateMember_ok")
    public String updateMemberOk(@RequestParam HashMap<String, String> param, Model model){
        int re = memberService.updateMember(param);
        //정상적으로 한 건이 수정된 경우
        if (re == 1){
            return "redirect:/admin/member";
        }else {
            return "redirect:error";
        }
    }

    /*주문 목록*/
    @GetMapping("admin/orders")
    public String listOrders(@ModelAttribute("params") OrdersDto params, Model model){
        model.addAttribute("list", ordersService.listOrders(params));
        return "admin/orders/listOrders";
    }

    /*검색 주문 목록 리스트*/
    @GetMapping("admin/orders/searchOrders")
    public String searchOrdersList(@ModelAttribute("params") OrdersDto params, Model model) {

        model.addAttribute("list", ordersService.listSearchOrders(params));

        return "admin/orders/listOrders";
    }

    /*비회원 주문 목록*/
    @GetMapping("admin/orders/noMemOrders")
    public String listNoMemOrders(@ModelAttribute("params") NoMemOrdersDto params, Model model){
        model.addAttribute("list", ordersService.listNoMemOrders(params));
        return "admin/orders/listNoMemOrders";
    }

    /*비회원 검색 주문 목록 리스트*/
    @GetMapping("admin/orders/searchNoMemOrders")
    public String searchOrdersList(@ModelAttribute("params") NoMemOrdersDto params, Model model) {

        model.addAttribute("list", ordersService.listSearchNoMemOrders(params));

        return "admin/orders/listNoMemOrders";
    }

    @GetMapping("admin/orders/updateOrders")
    public String updateOrders(@RequestParam HashMap<String, String> param, Model model){
        model.addAttribute("orders", ordersService.getOneOrder(param));
        return "admin/orders/updateOrders";
    }

    @GetMapping("admin/orders/updateOrders_ok")
    public String updateOrdersOk(@RequestParam HashMap<String, String> param, Model model, HttpSession session){
        int re = ordersService.updateOrdersStatus(param);
        model.addAttribute("page", "1");
        if (re == 1) {
            return "redirect:/admin/orders";
        }else {
            return "error";
        }
    }

    //비회원 주문정보 업데이트
    @GetMapping("admin/orders/updateNoMemOrders")
    public String updateNoMemOrders(@RequestParam HashMap<String, String> param, Model model){
        model.addAttribute("orders", ordersService.getNoMemOneOrder(param));
        return "admin/orders/updateNoMemOrders";
    }

    //비회원 주문정보 업데이트
    @GetMapping("admin/orders/updateNoMemOrders_ok")
    public String updateNoMemOrdersOk(@RequestParam HashMap<String, String> param, Model model, HttpSession session){
        int re = ordersService.updateNoMemOrdersStatus(param);
        model.addAttribute("page", "1");
        if (re == 1) {
            return "redirect:/admin/orders/noMemOrders";
        }else {
            return "error";
        }
    }
}

package com.meandbooksteam2.shoppingmall.controller;

import com.meandbooksteam2.shoppingmall.dto.BookDto;
import com.meandbooksteam2.shoppingmall.service.orders.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*주문 페이지들의 요청을 처리하는 Controller 클래스입니다*/
@Controller
public class OrdersController {
    OrdersService service;

    @Autowired
    public void setService(OrdersService service) {
        this.service = service;
    }

    //회원번호를 매개변수로 한 메서드를이용해 input 에 값들을 넣어줌
    @GetMapping("orders/ordersPage")
    public String ordersPage(@RequestParam HashMap<String, String> param, Model model, HttpSession session){
        String id = (String)session.getAttribute("mem_no");
        System.out.println(id);
        System.out.println("========");
        System.out.println(param.get("mem_no"));
        model.addAttribute("qty", param.get("cart_qty"));
        model.addAttribute("member", service.getMyInfo(id));
        model.addAttribute("book", service.getBookInfo(param));
        return "orders/ordersPage";
    }

    @PostMapping("orders/ordersPage")
    public String ordersPagePost(@RequestParam("cart_no") String[] cart_no, @RequestParam("cart_qty") int[] cart_qty, Model model, HttpSession session){
        String id = (String)session.getAttribute("mem_no"); // 세션에있는 회원번호
        List<BookDto> list = new ArrayList<>();
        int sum = 0;
        int amount = 0;
        System.out.println(cart_no.length);
        System.out.println(cart_qty.length);
        for (int i = 0; i < cart_no.length; i++) { //cart_no의 길이만큼 list에 bookdto객체를 담아줌
            BookDto book = service.getCartBookInfo(cart_no[i]);
            list.add(book);
            amount += cart_qty[i];
            sum += book.getBook_price() * cart_qty[i];
        }
        
        model.addAttribute("list", list);
        model.addAttribute("qty", cart_qty);
        model.addAttribute("member", service.getMyInfo(id));
        model.addAttribute("amount", amount);
        model.addAttribute("sum", sum);
        //모델에 담아서 리턴
        return "orders/ordersPagePost";
    }
    //주문할때 사용할 메서드
    @PostMapping("orders/insertOrder")
    public String insertOrder(@RequestParam HashMap<String, String> param, Model model){
        System.out.println(param.get("mem_no"));
        System.out.println(param.size());
        System.out.println(param.get("book_no"));

        if (param.get("mem_no") == null || param.get("mem_no").equals("")) {
            service.insertNoMemOrder(param);
            service.subBookStock(param);
        }else {
            service.insertOrder(param);
            service.subBookStock(param);
            service.updateMileageUp(param.get("mem_no"));
        }


        return "redirect:/orders/ordersDone?orders_no="+param.get("orders_no");
    }

    //제대로 들어간 경우 완료페이지에서 주문번호를 매개변수로 데이터에 저장된 값을 받아올수있도록 함
    @GetMapping("orders/ordersDone")
    public String orderDone(@RequestParam HashMap<String, String> param, Model model){
        model.addAttribute("orders", service.getOneOrder(param));
        return "orders/ordersDone";
    }
}

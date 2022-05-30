package com.meandbooksteam2.shoppingmall.controller;

import com.meandbooksteam2.shoppingmall.service.orders.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;

/*주문 페이지들의 요청을 처리하는 Controller 클래스입니다*/
@Controller
public class OrdersController {
    OrdersService service;

    @Autowired
    public void setService(OrdersService service) {
        this.service = service;
    }

    //회원번호를 매개변수로 한 메서드를이용해 input 에 값들을 넣어줌
    @GetMapping("order/ordersPage")
    public String ordersPage(@RequestParam HashMap<String, String> param, Model model){
        model.addAttribute("member", service.getMyInfo(param));
        return "order/ordersPage";
    }
    
    //주문할때 사용할 메서드
    @PostMapping("order/insertOrder")
    public String insertOrder(@RequestParam HashMap<String, String> param, Model model){
        int re = service.insertOrder(param);

        if (re == 1) {
            return "redirect:order/orderDone";
        }else {
            return "redirect:error";
        }
    }

    //제대로 들어간 경우 완료페이지에서 주문번호를 매개변수로 데이터에 저장된 값을 받아올수있도록 함
    @PostMapping("order/orderDone")
    public String orderDone(@RequestParam HashMap<String, String> param, Model model){
        model.addAttribute("orders", service.getOneOrder(param));
        return "order/orderDone";
    }
}

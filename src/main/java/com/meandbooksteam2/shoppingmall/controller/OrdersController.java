package com.meandbooksteam2.shoppingmall.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

/*주문 페이지들의 요청을 처리하는 Controller 클래스입니다*/
@Controller
public class OrdersController {
    @PostMapping("/order/ordersPage")
    public String ordersPage(){
        return "/order/ordersPage";
    }

    @PostMapping("/order/orderDone")
    public String orderDone(){
        return "/order/orderDone";
    }
}

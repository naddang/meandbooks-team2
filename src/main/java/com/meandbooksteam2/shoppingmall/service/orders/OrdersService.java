package com.meandbooksteam2.shoppingmall.service.orders;

import com.meandbooksteam2.shoppingmall.dao.orders.OrdersDao;
import com.meandbooksteam2.shoppingmall.dto.MemberDto;
import com.meandbooksteam2.shoppingmall.dto.OrdersDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;

@Service
public class OrdersService {

    private OrdersDao dao;
    //DI
    @Autowired
    public void setDao(OrdersDao dao) {this.dao = dao;}

    /*주문정보를 DB에 삽입하는 메서드*/
    public int insertOrder(HashMap<String, String> param){

        param.put("orders_no", getOrdersNo());

        return dao.insertOrder(param);
    }

    //하나의 주문 정보를 자세히 볼 수 있게하는 메서드
    public OrdersDto getOneOrder(HashMap<String, String> param){
        return dao.getOneOrder(param);
    }

    //나의 주문 목록을 가져오는 메서드
    public List<OrdersDto> getMyOrderList(HashMap<String, String> param) {
        return dao.getMyOrderList(param);
    }

    //넣어야할 주문번호를 리턴하는 메서드
    private String getOrdersNo() {
        LocalDate now = LocalDate.now();
        //yyMMdd+0000형태의 문자열이 담김
        String defaultNumberType = now.getYear() + now.getMonthValue() + now.getDayOfMonth() + "0000";
        //오늘 주문 건수 조회
        int order_no = dao.getTodayOrder();
        
        //위의 변수들을 더해 주문번호를 만듬
        long L_orders_no = (Long.parseLong(defaultNumberType) + order_no + 1);

        return Long.toString(L_orders_no);
    }

    //주문할때 기본값으로 넣을 개인정보를 받아오는 메서드
    public MemberDto getMyInfo(HashMap<String, String> param) {
        return dao.getMyInfo(param);
    }
}

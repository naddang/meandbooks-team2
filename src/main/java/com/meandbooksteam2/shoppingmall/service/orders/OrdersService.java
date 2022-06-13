package com.meandbooksteam2.shoppingmall.service.orders;

import com.meandbooksteam2.shoppingmall.dao.orders.OrdersDao;
import com.meandbooksteam2.shoppingmall.dto.BookDto;
import com.meandbooksteam2.shoppingmall.dto.MemberDto;
import com.meandbooksteam2.shoppingmall.dto.OrdersDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
    public int insertNoMemOrder(HashMap<String, String> param){

        param.put("orders_no", getNoMemOrdersNo());

        return dao.insertNoMemOrder(param);
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
        //yyMMdd+형태의 문자열이 담김
        String defaultNumberType = LocalDate.now().format(DateTimeFormatter.ofPattern("yyMMdd")) + "0000";
        //오늘 주문 건수 조회
        int order_no = dao.getTodayOrder();
        
        //위의 변수들을 더해 주문번호를 만듬
        long L_orders_no = (Long.parseLong(defaultNumberType) + order_no + 1);

        return Long.toString(L_orders_no);
    }
    //넣어야할 주문번호를 리턴하는 메서드
    private String getNoMemOrdersNo() {
        //yyMMdd+형태의 문자열이 담김
        String defaultNumberType = LocalDate.now().format(DateTimeFormatter.ofPattern("yyMMdd")) + "0000";
        //오늘 주문 건수 조회

//        int order_no = dao.getTodayOrder();
        int order_no = dao.getTodayNoMemOrder();

        //위의 변수들을 더해 주문번호를 만듬
        long L_orders_no = (Long.parseLong(defaultNumberType) + order_no + 1);

        return Long.toString(L_orders_no);
    }

    public int subBookStock(HashMap<String, String> param) {
        return dao.subBookStock(param);
    }

    //주문할때 기본값으로 넣을 개인정보를 받아오는 메서드
    public MemberDto getMyInfo(String mem_no) {
        return dao.getMyInfo(mem_no);
    }

    public BookDto getBookInfo(HashMap<String, String> param){
        return dao.getBookInfo(param);
    }

    // 주문시 마일리지 사용이 있을 경우
    public int updateMileageDown(String mem_no) {return dao.updateMileageDown(mem_no);}

    // 주문완료시 마일리지 적립
    public int updateMileageUp(String mem_no) {return dao.updateMileageUp(mem_no);}
    public BookDto getCartBookInfo(String cart_no){
        return dao.getCartBookInfo(cart_no);
    }
}

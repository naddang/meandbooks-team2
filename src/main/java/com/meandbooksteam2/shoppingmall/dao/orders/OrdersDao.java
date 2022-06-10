package com.meandbooksteam2.shoppingmall.dao.orders;

import com.meandbooksteam2.shoppingmall.dto.BookDto;
import com.meandbooksteam2.shoppingmall.dto.MemberDto;
import com.meandbooksteam2.shoppingmall.dto.OrdersDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface OrdersDao {
    int insertOrder(HashMap<String, String> param);
    int insertNoMemOrder(HashMap<String, String> param);
    OrdersDto getOneOrder(HashMap<String, String> param);
    int getTodayOrder();
    int getTodayNoMemOrder();
    List<OrdersDto> getMyOrderList(HashMap<String, String> param);
    MemberDto getMyInfo(String mem_no);
    BookDto getBookInfo(HashMap<String, String> param);
    BookDto getCartBookInfo(String cart_no);
    int subBookStock(HashMap<String, String> param);

    //성공하면 int를 리턴함
    int updateMileageDown(String mem_no);
    int updateMileageUp(String mem_no);
}

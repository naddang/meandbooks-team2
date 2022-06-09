package com.meandbooksteam2.shoppingmall.dao.orders;

import com.meandbooksteam2.shoppingmall.dto.BookDto;
import com.meandbooksteam2.shoppingmall.dto.MemberDto;
import com.meandbooksteam2.shoppingmall.dto.OrdersDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface OrdersDao {
    public int insertOrder(HashMap<String, String> param);
    public int insertNoMemOrder(HashMap<String, String> param);
    public OrdersDto getOneOrder(HashMap<String, String> param);
    public int getTodayOrder();
    public int getTodayNoMemOrder();
    public List<OrdersDto> getMyOrderList(HashMap<String, String> param);
    public MemberDto getMyInfo(String mem_no);
    public BookDto getBookInfo(HashMap<String, String> param);
    int subBookStock(HashMap<String, String> param);
}

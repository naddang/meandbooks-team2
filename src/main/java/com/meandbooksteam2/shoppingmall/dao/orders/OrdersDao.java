package com.meandbooksteam2.shoppingmall.dao.orders;

import com.meandbooksteam2.shoppingmall.dto.MemberDto;
import com.meandbooksteam2.shoppingmall.dto.OrdersDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface OrdersDao {
    public int insertOrder(HashMap<String, String> param);
    public OrdersDto getOneOrder(HashMap<String, String> param);
    public int getTodayOrder();
    public List<OrdersDto> getMyOrderList(HashMap<String, String> param);
    public MemberDto getMyInfo(HashMap<String, String> param);
}

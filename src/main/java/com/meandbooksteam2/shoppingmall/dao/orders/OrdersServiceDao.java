package com.meandbooksteam2.shoppingmall.dao.orders;

import com.meandbooksteam2.shoppingmall.dto.OrdersDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;

@Mapper
public interface OrdersServiceDao {
    public int insertOrder(HashMap<String, String> param);
    public OrdersDto getMyOrder(HashMap<String, String> param);
}

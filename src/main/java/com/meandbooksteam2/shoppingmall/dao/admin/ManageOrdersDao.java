package com.meandbooksteam2.shoppingmall.dao.admin;

import com.meandbooksteam2.shoppingmall.dto.OrdersDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface ManageOrdersDao<E> {
    public List<OrdersDto> listOrders(HashMap<String, String> param);
    public List<OrdersDto> searchOrders(HashMap<String, String> param);
    public OrdersDto viewOrders(HashMap<String, String> param);
    public int updateOrdersStatus(HashMap<String, String> param);
}

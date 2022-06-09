package com.meandbooksteam2.shoppingmall.dao.admin;

import com.meandbooksteam2.shoppingmall.dto.MemberDto;
import com.meandbooksteam2.shoppingmall.dto.OrdersDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface ManageOrdersDao {
//    public List<OrdersDto> listOrders(HashMap<String, String> param);
//    public List<OrdersDto> searchOrders(HashMap<String, String> param);
    public OrdersDto viewOrders(HashMap<String, String> param);
    public OrdersDto getOneOrder(HashMap<String, String> param);
    public int updateOrdersStatus(HashMap<String, String> param);

    /*전체 책 목록*/
    List<OrdersDto> listOrders(OrdersDto params);

    /*전체 책 목록을 위한 데이터 갯수*/
    int selectOrdersTotalCount(OrdersDto params);

    /*검색 책 목록*/
    List<OrdersDto> listSearchOrders(OrdersDto params);

    /*검색 책 목록을 위한 데이터 갯수*/
    int selectOrdersSearchTotalCount(OrdersDto params);
}

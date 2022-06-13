package com.meandbooksteam2.shoppingmall.dao.admin;

import com.meandbooksteam2.shoppingmall.dto.MemberDto;
import com.meandbooksteam2.shoppingmall.dto.NoMemOrdersDto;
import com.meandbooksteam2.shoppingmall.dto.OrdersDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface ManageOrdersDao {
    /*회원*/
    public OrdersDto viewOrders(HashMap<String, String> param);
    public OrdersDto getOneOrder(HashMap<String, String> param);
    public int updateOrdersStatus(HashMap<String, String> param);

    /*비회원*/
    public NoMemOrdersDto viewNoMemOrders(HashMap<String, String> param);
    public NoMemOrdersDto getNoMemOneOrder(HashMap<String, String> param);
    public int updateNoMemOrdersStatus(HashMap<String, String> param);

    /*전체 주문 목록*/
    List<OrdersDto> listOrders(OrdersDto params);

    /*전체 주문 목록을 위한 데이터 갯수*/
    int selectOrdersTotalCount(OrdersDto params);

    /*검색 주문 목록*/
    List<OrdersDto> listSearchOrders(OrdersDto params);

    /*검색 주문 목록을 위한 데이터 갯수*/
    int selectOrdersSearchTotalCount(OrdersDto params);

    /*위는 회원, 아래는 비회원*/

    /*전체 주문 목록*/
    List<NoMemOrdersDto> listNoMemOrders(NoMemOrdersDto params);

    /*전체 주문 목록을 위한 데이터 갯수*/
    int selectNoMemOrdersTotalCount(NoMemOrdersDto params);

    /*검색 주문 목록*/
    List<NoMemOrdersDto> listSearchNoMemOrders(NoMemOrdersDto params);

    /*검색 주문 목록을 위한 데이터 갯수*/
    int selectOrdersSearchNoMemTotalCount(NoMemOrdersDto params);
}

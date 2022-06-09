package com.meandbooksteam2.shoppingmall.service.admin;

import com.meandbooksteam2.shoppingmall.dao.admin.ManageOrdersDao;
import com.meandbooksteam2.shoppingmall.dto.MemberDto;
import com.meandbooksteam2.shoppingmall.dto.OrdersDto;
import com.meandbooksteam2.shoppingmall.dto.PaginationInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;

@Service
public class ManageOrdersServiceImpl {
    ManageOrdersDao dao;

    @Autowired
    public void setDao(ManageOrdersDao dao) {
        this.dao = dao;
    }

    public int updateOrdersStatus(HashMap<String, String> param) {
        return dao.updateOrdersStatus(param);
    }

//    public List<OrdersDto> listOrders(HashMap<String, String> param) {
//        return dao.listOrders(param);
//    }

//    public List<OrdersDto> searchOrders(HashMap<String, String> param) {
//        return dao.searchOrders(param);
//    }

    public OrdersDto viewOrders(HashMap<String, String> param) {
        return dao.viewOrders(param);
    }
    public OrdersDto getOneOrder(HashMap<String, String> param) {
        return dao.getOneOrder(param);
    }

    /*주문 관리 화면에서 기준에 맞춰 주문 목록을 보여주는 메서드*/
    public List<OrdersDto> listOrders(OrdersDto params) {
        List<OrdersDto> list = Collections.emptyList();

        int ordersTotalCount = dao.selectOrdersTotalCount(params);

        PaginationInfo paginationInfo = new PaginationInfo(params);
        paginationInfo.setTotalRecordCount(ordersTotalCount);

        params.setPaginationInfo(paginationInfo);

        if (ordersTotalCount > 0) {
            list = dao.listOrders(params);
        }

        return list;
    }

    /*keyword를 받아 주문 리스트를 리턴하는 메서드*/
    public List<OrdersDto> listSearchOrders(OrdersDto params) {
        List<OrdersDto> list = Collections.emptyList();

        int ordersSearchTotalCount = dao.selectOrdersSearchTotalCount(params);

        PaginationInfo paginationInfo = new PaginationInfo(params);
        paginationInfo.setTotalRecordCount(ordersSearchTotalCount);

        params.setPaginationInfo(paginationInfo);

        if (ordersSearchTotalCount > 0) {
            list = dao.listSearchOrders(params);
        }

        return list;
    }
}

package com.meandbooksteam2.shoppingmall.service.admin;

import com.meandbooksteam2.shoppingmall.dao.admin.ManageOrdersDao;
import com.meandbooksteam2.shoppingmall.dto.OrdersDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public List<OrdersDto> listOrders(HashMap<String, String> param) {
        return dao.listOrders(param);
    }

    public List<OrdersDto> searchOrders(HashMap<String, String> param) {
        return dao.searchOrders(param);
    }

    public OrdersDto viewOrders(HashMap<String, String> param) {
        return dao.viewOrders(param);
    }
    public OrdersDto getOneOrder(HashMap<String, String> param) {
        return dao.getOneOrder(param);
    }
}

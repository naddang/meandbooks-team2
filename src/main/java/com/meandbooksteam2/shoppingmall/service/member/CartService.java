package com.meandbooksteam2.shoppingmall.service.member;

import com.meandbooksteam2.shoppingmall.dao.member.CartServiceDao;
import com.meandbooksteam2.shoppingmall.dto.CartDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class CartService {
    private CartServiceDao dao;
    @Autowired
    public void setDao(CartServiceDao dao) {
        this.dao = dao;
    }

    //장바구니 목록 조회
    public List<CartDto> listCart(String mem_no) {
        return dao.listCart(mem_no);
    }

    //장바구니 수정
    public int updateCartStatus(HashMap<String,String> param){
        return dao.updateCartStatus(param);
    }

    //장바구니 삭제
    public int deleteCart(HashMap<String,String> param) {
        return dao.deleteCart(param);
    }
}

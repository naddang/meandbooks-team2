package com.meandbooksteam2.shoppingmall.dao.member;

import com.meandbooksteam2.shoppingmall.dto.CartDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface CartServiceDao {
    //장바구니 목록 조회
    List<CartDto> listCart(String mem_no);

    //장바구니 수정
    int updateCartStatus(HashMap<String,String> param);

    //장바구니 삭제
    int deleteCart(HashMap<String,String> param);
}

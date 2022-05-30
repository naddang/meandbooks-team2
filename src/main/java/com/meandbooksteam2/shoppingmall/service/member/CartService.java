package com.meandbooksteam2.shoppingmall.service.member;

import com.meandbooksteam2.shoppingmall.dao.mall.BookServiceDao;
import com.meandbooksteam2.shoppingmall.dto.BookDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;

@Service
public class CartService {
    BookServiceDao dao;
    @Autowired
    public void setDao(BookServiceDao dao) {this.dao = dao;}

    public List<BookDto> listAllBest(){
        return dao.listAllBest();
    }

    public List<BookDto> listCateBest(HashMap<String, String> param){
        return dao.listCateBest(param);
    }

    public List<BookDto> listMallBook(HashMap<String, String> param){
        return dao.listMallBook(param);
    }

    public BookDto viewBook(HashMap<String, String> param){
        return dao.viewBook(param);
    }

    public int insertCart(HashMap<String, String> param){
        param.put("cart_no", getCartNo());
        int re = dao.insertCart(param);

        return re;
    }
    
    private String getCartNo(){
        String defaultNumberType = LocalDate.now().format(DateTimeFormatter.ofPattern("yyMmdd"));
        //오늘 장바구니 건수 조회
        int cart_no = dao.getTodayCart(defaultNumberType);


        //위의 변수들을 더해 카트번호를 만듬
        long L_cart_no = (Long.parseLong(defaultNumberType + "0000") + cart_no + 1);

        return Long.toString(L_cart_no);
    }
}

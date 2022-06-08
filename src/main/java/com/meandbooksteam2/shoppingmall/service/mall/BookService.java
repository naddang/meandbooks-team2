package com.meandbooksteam2.shoppingmall.service.mall;

import com.meandbooksteam2.shoppingmall.dao.mall.BookServiceDao;
import com.meandbooksteam2.shoppingmall.dto.BookDto;
import com.meandbooksteam2.shoppingmall.dto.PaginationInfo;
import com.meandbooksteam2.shoppingmall.dto.RevCmtDto;
import com.meandbooksteam2.shoppingmall.dto.ReviewDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

@Service
public class BookService {
    BookServiceDao dao;
    @Autowired
    public void setDao(BookServiceDao dao) {this.dao = dao;}

    public List<BookDto> listAllBest(){
        return dao.listAllBest();
    }

    public List<BookDto> listCateBest(HashMap<String, String> param){
        return dao.listCateBest(param);
    }

    public List<BookDto> listMallBook(BookDto params){
        List<BookDto> list = Collections.emptyList();

        int allCount = dao.selectSearchedCount(params);

        PaginationInfo paginationInfo = new PaginationInfo(params);
        paginationInfo.setTotalRecordCount(allCount);

        params.setPaginationInfo(paginationInfo);

        if (allCount > 0){
            list = dao.listMallBook(params);
        }

        return list;
    }
    public List<BookDto> listMallBookCate(HashMap<String, String> param){
        return dao.listMallBookCate(param);
    }

    public BookDto viewBook(HashMap<String, String> param){
        return dao.viewBook(param);
    }

    public int insertCart(HashMap<String, String> param){
        param.put("cart_no", getCartNo());
        System.out.println(param.get("mem_no"));
        System.out.println(param.get("book_no"));
        System.out.println(param.get("cart_no"));
        System.out.println(param.get("cart_qty"));
        int re = dao.insertCart(param);

        return re;
    }

    public List<ReviewDto> listReview(HashMap<String, String> param){
        return dao.listReview(param);
    }

    public List<RevCmtDto> listRevCmt(HashMap<String, String> param){
        return dao.listRevCmt(param);
    }

    public int updateReview(HashMap<String, String> param){
        return dao.updateReview(param);
    }
    public int deleteReview(HashMap<String, String> param){
        return dao.deleteReview(param);
    }

    public int updateRevCmt(HashMap<String, String> param){
        return dao.updateRevCmt(param);
    }
    public int deleteRevCmt(HashMap<String, String> param){
        return dao.deleteRevCmt(param);
    }

    private String getCartNo(){
        String defaultNumberType = LocalDate.now().format(DateTimeFormatter.ofPattern("yyMMdd"));
        //오늘 장바구니 건수 조회
        int cart_no = dao.getTodayCart(defaultNumberType);


        //위의 변수들을 더해 카트번호를 만듬
        long L_cart_no = (Long.parseLong(defaultNumberType + "0000") + cart_no + 1);

        return Long.toString(L_cart_no);
    }

    public int insertReview(HashMap<String, String> param){
        return dao.insertReview(param);
    }

    public int insertRevCmt(HashMap<String, String> param){
        return dao.insertRevCmt(param);
    }
}

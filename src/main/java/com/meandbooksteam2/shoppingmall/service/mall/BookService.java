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
        System.out.println("서비스 댓글 사이즈" + dao.listRevCmt(param).size());
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
        long cart_no = 0;

        if (dao.getTodayCart(defaultNumberType) == 0) {
            cart_no = Long.parseLong(defaultNumberType + "0000");
        }else {
            cart_no = dao.getTodayCart(defaultNumberType);
        }

        return String.valueOf(cart_no + 1);
    }

    public int insertReview(HashMap<String, String> param){
        return dao.insertReview(param);
    }

    public int insertRevCmt(HashMap<String, String> param){
        return dao.insertRevCmt(param);
    }

    public BookDto getRandomBest(){
        return dao.getRandomBest();
    }
    public BookDto getMonthlySpecial(){
        return dao.getMonthlySpecial();
    }
    public int reviewAuth(String mem_no, String book_no){
        int re = dao.reviewAuth(mem_no, book_no);

        if (re > 0) {
            return 1;
        }else {
            return 0;
        }
    }

    public RevCmtDto getOneCmt(String cmt_no) {
        return dao.getOneCmt(cmt_no);
    }

    public ReviewDto getOneRev(String rev_no) {
        return dao.getOneRev(rev_no);
    }
}

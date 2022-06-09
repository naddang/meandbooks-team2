package com.meandbooksteam2.shoppingmall.dao.mall;

import com.meandbooksteam2.shoppingmall.dto.BookDto;
import com.meandbooksteam2.shoppingmall.dto.RevCmtDto;
import com.meandbooksteam2.shoppingmall.dto.ReviewDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface BookServiceDao {
    public List<BookDto> listAllBest();

    public List<BookDto> listCateBest(HashMap<String, String> param);

    public BookDto viewBook(HashMap<String, String> param);

    public List<BookDto> listMallBook(BookDto bookDto);

    public List<BookDto> listMallBookCate(HashMap<String, String> param);

    public int insertCart(HashMap<String, String> param);

    public int getTodayCart(String formattingDate);

    public List<ReviewDto> listReview(HashMap<String, String> param);
    public int updateReview(HashMap<String, String> param);
    public int deleteReview(HashMap<String, String> param);

    public List<RevCmtDto> listRevCmt(HashMap<String, String> param);
    public int updateRevCmt(HashMap<String, String> param);
    public int deleteRevCmt(HashMap<String, String> param);
    public int selectSearchedCount(BookDto params);
    int insertReview(HashMap<String, String> param);
    int insertRevCmt(HashMap<String, String> param);

}

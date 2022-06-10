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
    public List<BookDto> listMallBook(BookDto bookDto);
    public List<BookDto> listMallBookCate(HashMap<String, String> param);
    public int selectSearchedCount(BookDto params);

    public BookDto viewBook(HashMap<String, String> param);
    int reviewAuth(String mem_no, String book_no);

    public int insertCart(HashMap<String, String> param);
    public long getTodayCart(String formattingDate);

    public List<ReviewDto> listReview(HashMap<String, String> param);
    int insertReview(HashMap<String, String> param);
    ReviewDto getOneRev(String rev_no);
    public int updateReview(HashMap<String, String> param);
    public int deleteReview(HashMap<String, String> param);

    public List<RevCmtDto> listRevCmt(HashMap<String, String> param);
    RevCmtDto getOneCmt(String cmt_no);
    int insertRevCmt(HashMap<String, String> param);
    public int updateRevCmt(HashMap<String, String> param);
    public int deleteRevCmt(HashMap<String, String> param);

    BookDto getRandomBest();
    BookDto getMonthlySpecial();
}

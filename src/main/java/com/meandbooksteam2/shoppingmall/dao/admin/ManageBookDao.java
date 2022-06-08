package com.meandbooksteam2.shoppingmall.dao.admin;

import com.meandbooksteam2.shoppingmall.dto.BookDto;
import com.meandbooksteam2.shoppingmall.dto.NoticeDto;
import org.apache.ibatis.annotations.Mapper;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;

@Mapper
public interface ManageBookDao {
//     public List<BookDto> listBook(HashMap<String, String> param);
//     public List<BookDto> searchBook(HashMap<String, String> param);
     public BookDto viewBook(HashMap<String, String> param);
     public int insertBook(HashMap<String, String> param);
     public int updateBook(HashMap<String, String> param);
     public int deleteBook(HashMap<String, String> param);
     public long getBookNo(HashMap<String, String> param);

     /*전체 책 목록*/
     List<BookDto> listBook(BookDto params);

     /*전체 책 목록을 위한 데이터 갯수*/
     int selectBookTotalCount(BookDto params);

     /*검색 책 목록*/
     List<BookDto> listSearchBook(BookDto params);

     /*검색 책 목록을 위한 데이터 갯수*/
     int selectBookSearchTotalCount(BookDto params);

}

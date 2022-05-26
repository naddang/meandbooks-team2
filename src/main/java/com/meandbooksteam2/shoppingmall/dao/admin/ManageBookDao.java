package com.meandbooksteam2.shoppingmall.dao.admin;

import com.meandbooksteam2.shoppingmall.dto.BookDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface ManageBookDao {
     public List<BookDto> listBook(HashMap<String, String> param);
     public List<BookDto> searchBook(HashMap<String, String> param);
     public BookDto viewBook(HashMap<String, String> param);
     public int insertBook(HashMap<String, String> param);
     public int updateBook(HashMap<String, String> param);
     public int deleteBook(HashMap<String, String> param);
     public String getBookNo(HashMap<String, String> param);
}

package com.meandbooksteam2.shoppingmall.dao.mall;

import com.meandbooksteam2.shoppingmall.dto.BookDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface BookServiceDao {
    public List<BookDto> listAllBest();

    public List<BookDto> listCateBest(HashMap<String, String> param);

    public BookDto viewBook(HashMap<String, String> param);

    public List<BookDto> listMallBook(HashMap<String, String> param);

    public int insertCart(HashMap<String, String> param);

    public int getTodayCart(String formattingDate);
}

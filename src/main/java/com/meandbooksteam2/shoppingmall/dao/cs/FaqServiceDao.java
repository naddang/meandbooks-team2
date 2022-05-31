package com.meandbooksteam2.shoppingmall.dao.cs;

import com.meandbooksteam2.shoppingmall.dto.FaqDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface FaqServiceDao {
    //FAQ 작성
    int insertFaq(HashMap<String,String> param);

    //삭제
    int deleteFaq(HashMap<String,String> param);

    //수정하기 위한 개별 FAQ 확인
    FaqDto viewFaq(HashMap<String, String> param);

    //수정
    int updateFaqStatus(HashMap<String,String> param);

    //목록 조회
    List<FaqDto> listFaq();
}

package com.meandbooksteam2.shoppingmall.dao.cs;

import com.meandbooksteam2.shoppingmall.dto.NoticeDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface NoticeServiceDao {
    //공지 작성
    int insertNotice(HashMap<String,String> param);

    //공지 삭제
    int deleteNotice(HashMap<String,String> param);

    //공지 수정
    int updateNoticeStatus(HashMap<String,String> param);

    //공지 목록
//    List<NoticeDto> listNotice(HashMap<String,String> param); - 페이징 처리 때 사용
    List<NoticeDto> listNotice();

    //개별 공지 조회
    NoticeDto viewNotice(HashMap<String,String> param);

    //검색으로 공지 조회
//    List<NoticeDto> searchNotice(HashMap<String,String> param); - 페이징 처리 때 사용
    List<NoticeDto> searchNotice();
}

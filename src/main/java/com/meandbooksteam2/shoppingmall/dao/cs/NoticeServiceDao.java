package com.meandbooksteam2.shoppingmall.dao.cs;

import com.meandbooksteam2.shoppingmall.dto.Criteria;
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

//    //공지 목록
//    List<NoticeDto> listNotice(Criteria param); //- 페이징 처리 때 사용
////    List<NoticeDto> listNotice();
//
//    //전체 게시글 수
//    int getTotal(Criteria param);

    /*전체 공지 목록*/
    List<NoticeDto> listNotice(NoticeDto params);

    /*전체 공지 목록을 위한 데이터 갯수*/
    int selectNoticeTotalCount(NoticeDto params);

    //개별 공지 조회
    NoticeDto viewNotice(HashMap<String,String> param);

    /*검색공지 목록*/
    List<NoticeDto> listSearchNotice(NoticeDto params);

    /*검색 공지 목록을 위한 데이터 갯수*/
    int selectNoticeSearchTotalCount(NoticeDto params);

}

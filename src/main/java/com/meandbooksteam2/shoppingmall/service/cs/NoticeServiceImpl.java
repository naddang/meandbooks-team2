package com.meandbooksteam2.shoppingmall.service.cs;

import com.meandbooksteam2.shoppingmall.dao.cs.NoticeServiceDao;
import com.meandbooksteam2.shoppingmall.dto.NoticeDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class NoticeServiceImpl{

    NoticeServiceDao dao;

    @Autowired
    public void setDao(NoticeServiceDao dao) {
        this.dao = dao;
    }

    //공지 작성
    public int insertNotice(HashMap<String, String> param) {
        return dao.insertNotice(param);
    }

    //공지 삭제
    public int deleteNotice(HashMap<String, String> param) {
        return dao.deleteNotice(param);
    }

    //공지 수정
    public int updateNoticeStatus(HashMap<String, String> param) {
        return dao.updateNoticeStatus(param);
    }

    //공지 목록
//    public List<NoticeDto> listNotice(HashMap<String, String> param) { - 페이징 처리할 때 사용
    public List<NoticeDto> listNotice() {
        return dao.listNotice();
    }

    //개별 공지 조회
    public NoticeDto viewNotice(HashMap<String, String> param) {
        return dao.viewNotice(param);
    }

    //검색으로 공지 조회
//    public List<NoticeDto> searchNotice(HashMap<String, String> param) { - 페이징 처리할 때 사용
    public List<NoticeDto> searchNotice() {
        return dao.searchNotice();
    }
}

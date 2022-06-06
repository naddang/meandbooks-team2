package com.meandbooksteam2.shoppingmall.service.cs;

import com.meandbooksteam2.shoppingmall.dao.cs.QnaServiceDao;
import com.meandbooksteam2.shoppingmall.dto.PaginationInfo;
import com.meandbooksteam2.shoppingmall.dto.QnaADto;
import com.meandbooksteam2.shoppingmall.dto.QnaQDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

@Service
public class QnaServiceImpl {

    QnaServiceDao dao;

    @Autowired
    public void setDao(QnaServiceDao dao) {
        this.dao = dao;
    }

    //문의 목록
//    List<QnaQDto> listQna(HashMap<String,String> param) { - 페이징 처리할 때 사용
//    public List<QnaQDto> listQna() {
//        return dao.listQna();
//    }

    //문의 작성(회원이 작성 - 게시물에 수정, 삭제에 필요한 비밀번호 입력)
    public int insertQnaQ(HashMap<String,String> param) {
        return dao.insertQnaQ(param);
    }

    //개별 문의 조회
    public QnaQDto viewQnaQ(HashMap<String, String> param) {
        return dao.viewQnaQ(param);
    }

    //회원이 자기 문의 수정(비밀번호 체크랑 같이 쓰면 되지 않을까 싶은 마음)
    public int updateQnaQStatus(HashMap<String,String> param) {
        return dao.updateQnaQStatus(param);
    }

    //문의 작성시 입력한 비밀번호와 비교
    public int checkQnaPW(HashMap<String,String> param) {
        return dao.checkQnaPW(param);
    }

    //문의 질문 삭제
    public int deleteQnaQ(HashMap<String, String> param) {
        return dao.deleteQnaQ(param);
    }

    //관리자가 답변 작성
    public int insertQnaA(HashMap<String, String> param) {
        return dao.insertQnaA(param);
    }

    //답변 상태 수정
    public int updateAccessLevel(HashMap<String, String> param) {
        return dao.updateAccessLevel(param);
    }

    //관리자가 답변 수정
    public int updateQnaAStatus(HashMap<String, String> param) {
        return dao.updateQnaAStatus(param);
    }

    //개별 문의에 대한 관리자의 답변 조회
    public QnaADto viewQnaA(HashMap<String, String> param) {
        return dao.viewQnaA(param);
    }

    //문의 답변 삭제
    public int deleteQnaA(HashMap<String, String> param) {
        return dao.deleteQnaA(param);
    }

    public List<QnaQDto> memListQna(String mem_no) {
        return dao.memListQna(mem_no);
    }

    public List<QnaQDto> adminListQna(QnaQDto params) {
        List<QnaQDto> list = Collections.emptyList();

        int qnaTotalCount = dao.selectQnaTotalCount(params);

        PaginationInfo paginationInfo = new PaginationInfo(params);
        paginationInfo.setTotalRecordCount(qnaTotalCount);

        params.setPaginationInfo(paginationInfo);

        if (qnaTotalCount > 0) {
            list = dao.adminListQna(params);
        }

        return list;
    }

    public List<QnaQDto> searchQna(QnaQDto params) {
        List<QnaQDto> list = Collections.emptyList();

        int qnaTotalCount = dao.selectQnaSearchTotalCount(params);

        PaginationInfo paginationInfo = new PaginationInfo(params);
        paginationInfo.setTotalRecordCount(qnaTotalCount);

        params.setPaginationInfo(paginationInfo);

        if (qnaTotalCount > 0) {
            list = dao.searchQna(params);
        }

        return list;
    }
}

package com.meandbooksteam2.shoppingmall.dao.cs;

import com.meandbooksteam2.shoppingmall.dto.QnaADto;
import com.meandbooksteam2.shoppingmall.dto.QnaQDto;
import org.apache.ibatis.annotations.Mapper;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;

@Mapper
public interface QnaServiceDao {
    //문의 목록
//    List<QnaQDto> listQna(HashMap<String,String> param); - 페이징 처리에서 사용
//    List<QnaQDto> listQna();

    //문의 작성(회원이 작성 - 게시물에 수정, 삭제에 필요한 비밀번호 입력)
    int insertQnaQ(HashMap<String,String> param);

    //개별 문의 조회
    QnaQDto viewQnaQ(HashMap<String,String> param);

    //회원이 자기 문의 수정(비밀번호 체크랑 같이 쓰면 되지 않을까 싶은 마음)
    int updateQnaQStatus(HashMap<String,String> param);

    //문의 작성시 입력한 비밀번호와 비교
    int checkQnaPW(HashMap<String,String> param);

    //질문 삭제
    int deleteQnaQ(HashMap<String, String> param);

    //관리자가 답변 작성
    int insertQnaA(HashMap<String,String> param);

    //관리자가 답변 수정
    int updateQnaAStatus(HashMap<String,String> param);

    //개별 문의에 대한 관리자의 답변 조회
    QnaADto viewQnaA(HashMap<String,String> param);

    //문의 답변 삭제
    int deleteQnaA(HashMap<String, String> param);

    //관리자가 보는 qna 목록
    List<QnaQDto> adminListQna(QnaQDto params);

    int selectQnaTotalCount(QnaQDto params);

    //회원이 보는 qna 목록
    List<QnaQDto> memListQna(String mem_no);

    //답변 상태 수정
    int updateAccessLevel(HashMap<String, String> param);

    //검색
    List<QnaQDto> searchQna(QnaQDto params);

    int selectQnaSearchTotalCount(QnaQDto params);
}

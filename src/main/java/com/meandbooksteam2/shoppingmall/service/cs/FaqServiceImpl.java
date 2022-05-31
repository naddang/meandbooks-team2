package com.meandbooksteam2.shoppingmall.service.cs;

import com.meandbooksteam2.shoppingmall.dao.cs.FaqServiceDao;
import com.meandbooksteam2.shoppingmall.dto.FaqDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class FaqServiceImpl {

    FaqServiceDao dao;

    @Autowired
    public void setDao(FaqServiceDao dao) {
        this.dao = dao;
    }

    //FAQ 작성
    public int insertFaq(HashMap<String,String> param) {

        return dao.insertFaq(param);
    }

    //삭제
    public int deleteFaq(HashMap<String,String> param) {

        return dao.deleteFaq(param);
    }

    //개별로 확인
    public FaqDto viewFaq(HashMap<String, String> param) {
        return dao.viewFaq(param);
    }

    //수정
    public int updateFaqStatus(HashMap<String,String> param) {

        return dao.updateFaqStatus(param);
    }

    //목록 조회
    public List<FaqDto> listFaq() {

        return dao.listFaq();
    }
}

package com.meandbooksteam2.shoppingmall.service.admin;

import com.meandbooksteam2.shoppingmall.dao.admin.ManageMemberDao;
import com.meandbooksteam2.shoppingmall.dto.BookDto;
import com.meandbooksteam2.shoppingmall.dto.MemberDto;
import com.meandbooksteam2.shoppingmall.dto.PaginationInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;

@Service
public class ManageMemberServiceImpl {
    ManageMemberDao dao;

    @Autowired
    public void setDao(ManageMemberDao dao) {
        this.dao = dao;
    }

//    public List<MemberDto> listMember(HashMap<String, String> param){
//        return dao.listMember(param);
//    }
    public int updateMember(HashMap<String, String> param){
        return dao.updateMember(param);
    }
    public MemberDto viewMember(HashMap<String, String> param){
        return dao.viewMember(param);
    }
//    public List<MemberDto> searchMember(HashMap<String, String> param){
//        return dao.searchMember(param);
//    }

    /*회원 관리 화면에서 기준에 맞춰 회원 목록을 보여주는 메서드*/
    public List<MemberDto> listMember(MemberDto params) {
        List<MemberDto> list = Collections.emptyList();

        int memberTotalCount = dao.selectMemberTotalCount(params);

        PaginationInfo paginationInfo = new PaginationInfo(params);
        paginationInfo.setTotalRecordCount(memberTotalCount);

        params.setPaginationInfo(paginationInfo);

        if (memberTotalCount > 0) {
            list = dao.listMember(params);
        }

        return list;
    }

    /*keyword를 받아 회원 리스트를 리턴하는 메서드*/
    public List<MemberDto> listSearchMember(MemberDto params) {
        List<MemberDto> list = Collections.emptyList();

        int memberSearchTotalCount = dao.selectMemberSearchTotalCount(params);

        PaginationInfo paginationInfo = new PaginationInfo(params);
        paginationInfo.setTotalRecordCount(memberSearchTotalCount);

        params.setPaginationInfo(paginationInfo);

        if (memberSearchTotalCount > 0) {
            list = dao.listSearchMember(params);
        }

        return list;
    }
}

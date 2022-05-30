package com.meandbooksteam2.shoppingmall.service.admin;

import com.meandbooksteam2.shoppingmall.dao.admin.ManageMemberDao;
import com.meandbooksteam2.shoppingmall.dto.MemberDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class ManageMemberServiceImpl {
    ManageMemberDao dao;

    @Autowired
    public void setDao(ManageMemberDao dao) {
        this.dao = dao;
    }

    public List<MemberDto> listMember(HashMap<String, String> param){
        return dao.listMember(param);
    }
    public int updateMember(HashMap<String, String> param){
        return dao.updateMember(param);
    }
    public MemberDto viewMember(HashMap<String, String> param){
        return dao.viewMember(param);
    }
    public List<MemberDto> searchMember(HashMap<String, String> param){
        return dao.searchMember(param);
    }
}

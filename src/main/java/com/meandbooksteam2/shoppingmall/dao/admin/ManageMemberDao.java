package com.meandbooksteam2.shoppingmall.dao.admin;

import com.meandbooksteam2.shoppingmall.dto.MemberDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface ManageMemberDao {
    public List<MemberDto> listMember();
    public void updateMember();
    public MemberDto viewMember();
    public List<MemberDto> searchMember();
}

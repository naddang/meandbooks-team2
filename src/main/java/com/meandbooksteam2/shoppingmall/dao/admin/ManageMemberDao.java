package com.meandbooksteam2.shoppingmall.dao.admin;

import com.meandbooksteam2.shoppingmall.dto.BookDto;
import com.meandbooksteam2.shoppingmall.dto.MemberDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface ManageMemberDao {
//    public List<MemberDto> listMember(HashMap<String, String> param);
    public int updateMember(HashMap<String, String> param);
    public MemberDto viewMember(HashMap<String, String> param);
//    public List<MemberDto> searchMember(HashMap<String, String> param);

    /*전체 책 목록*/
    List<MemberDto> listMember(MemberDto params);

    /*전체 책 목록을 위한 데이터 갯수*/
    int selectMemberTotalCount(MemberDto params);

    /*검색 책 목록*/
    List<MemberDto> listSearchMember(MemberDto params);

    /*검색 책 목록을 위한 데이터 갯수*/
    int selectMemberSearchTotalCount(MemberDto params);
}

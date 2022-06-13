package com.meandbooksteam2.shoppingmall.dao.member;

import com.meandbooksteam2.shoppingmall.dto.MemberDto;
import com.meandbooksteam2.shoppingmall.dto.NoMemOrdersDto;
import com.meandbooksteam2.shoppingmall.dto.OrdersDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface MemberServiceDao {
//    //여기서 비밀번호 받은 다음에 컨트롤러에서 분기처리로 처리
//    List<MemberDto> checkId(HashMap<String,String> param);

    //쿼리에서 값 받아서 값이 1개만 리턴되는 경우에만 컨트롤러에서 분기처리로 로그인
    int login(HashMap<String,String> param);

    //회원가입
    int register(HashMap<String,String> param);

    //중복아이디 조회
    int checkId(String mem_uid);

    //내 정보 조회
    MemberDto viewMyInfo(String mem_no);

    //내 정보 수정
    int updateMyInfo (HashMap<String,String> param);


    //내 주문목록 조회
    List<OrdersDto> listMyOrders(String mem_no);

    //나의 개별 주문 조회
    OrdersDto viewMyOrder(HashMap<String,String> param);

    //주문취소(관리자가 상태변경 전에 주문취소 가능하도록 할 거여서)
    int cancelOrder(HashMap<String,String> param);

    //환불신청
    int refund(HashMap<String,String> param);

    //비회원 주문조회
    NoMemOrdersDto viewNoMemOrder(HashMap<String,String> param);

    //비회원 환불신청
    int refundNoMem(HashMap<String,String> param);

    //비회원 주문취소
    int cancelNoMemOrder(HashMap<String,String> param);

    public int getTodayRefund();
    public int getTodayNoMemberRefund();
    public int isAdmin(String mem_uid);
    public String getMemNo(HashMap<String, String> param);

    public int withdraw(String mem_no, String mem_pwd);

}

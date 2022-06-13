package com.meandbooksteam2.shoppingmall.service.member;

import com.meandbooksteam2.shoppingmall.dao.member.MemberServiceDao;
import com.meandbooksteam2.shoppingmall.dto.MemberDto;
import com.meandbooksteam2.shoppingmall.dto.NoMemOrdersDto;
import com.meandbooksteam2.shoppingmall.dto.OrdersDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class MemberService {
    MemberServiceDao dao;

    @Autowired
    public void setDao(MemberServiceDao dao) {
        this.dao = dao;
    }

    public int login(HashMap<String, String> param) {
        int re = dao.login(param);

        return re;
    }

    public int isAdmin(String mem_uid) {
        int re = dao.isAdmin(mem_uid);
        return re;
    }

    //회원가입 메서드
    public int register(HashMap<String, String> param) {
        int re = dao.register(param);
        return re;
    }

    //아이디 중복체크 메서드
    public int checkId(String mem_uid) {
        int re = dao.checkId(mem_uid);
        return re;
    }

    //나의 개인정보를 확인할 수 있게하는 메서드
    public MemberDto viewMyInfo(String mem_no) {
        return dao.viewMyInfo(mem_no);
    }

    //개인정보를 수정하는 메서드
    public int updateMyInfo(HashMap<String, String> param) {
        int re = dao.updateMyInfo(param);

        return re;
    }

    /*본인의 모든 주문정보를 가져오는 메서드*/
    public List<OrdersDto> listMyOrders(String mem_no) {
        ArrayList<OrdersDto> list = (ArrayList<OrdersDto>) dao.listMyOrders(mem_no);

        return list;
    }

    /*한 건에대한 주문정보를 가져오는 메서드*/
    public OrdersDto viewMyOrder(HashMap<String, String> param) {
        return dao.viewMyOrder(param);
    }
    /*처리 대기중이라면 직접 취소할 수 있게하는 메서드*/
    public int cancelOrder(HashMap<String, String> param) {
        int re = dao.cancelOrder(param);

        return re;
    }

    public int requestRefund(HashMap<String, String> param) {
        param.put("refund_no", getRefundNo());

        int re = dao.refund(param);

        return re;
    }

    public int requestRefundNoMem(HashMap<String, String> param) {
        param.put("refund_no", getNoMemberRefundNo());

        int re = dao.refundNoMem(param);

        return re;
    }

    public NoMemOrdersDto viewNoMemOrder(HashMap<String, String> param) {
        return dao.viewNoMemOrder(param);
    }

    public int cancelNoMemOrder(HashMap<String, String> param) {
        int re = dao.cancelNoMemOrder(param);

        return re;
    }

    private String getRefundNo(){
        LocalDate now = LocalDate.now();
        //yyMMdd+0000형태의 문자열이 담김
        String defaultNumberType = now.getYear() + now.getMonthValue() + now.getDayOfMonth() + "0000";
        //오늘 환불 건수 조회
        int refund_no = dao.getTodayRefund();

        //위의 변수들을 더해 주문번호를 만듬
        long L_refund_no = (Long.parseLong(defaultNumberType) + refund_no + 1);

        return Long.toString(L_refund_no);
    }

    private String getNoMemberRefundNo() {
        LocalDate now = LocalDate.now();
        //yyMMdd+0000형태의 문자열이 담김
        String defaultNumberType = now.getYear() + now.getMonthValue() + now.getDayOfMonth() + "0000";
        //오늘 환불 건수 조회
        int refund_no = dao.getTodayNoMemberRefund();

        //위의 변수들을 더해 주문번호를 만듬
        long L_refund_no = (Long.parseLong(defaultNumberType) + refund_no + 1);

        return Long.toString(L_refund_no);
    }

    public String getMemNo(HashMap<String, String> param){
        return dao.getMemNo(param);
    }

    public int withdraw(String mem_no, String mem_pwd){
        int re = dao.withdraw(mem_no, mem_pwd);
        return re;
    }

}

package com.meandbooksteam2.shoppingmall.dto;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
public class RevCmtDto {
    private int cmt_no;
    private int rev_no;
    private int mem_no;
    private String cmt_content;
    private String cmt_date;
    private ReviewDto review;
    private MemberDto member;
}

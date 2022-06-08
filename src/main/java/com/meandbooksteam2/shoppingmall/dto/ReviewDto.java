package com.meandbooksteam2.shoppingmall.dto;

import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;

@Getter
@Setter
public class ReviewDto {
    private int rev_no;
    private int mem_no;
    private String book_no;
    private String rev_title;
    private String rev_content;
    private int rev_rating;
    private String rev_date;
    private MemberDto member;
    private RevCmtDto rev_cmt;
}

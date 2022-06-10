package com.meandbooksteam2.shoppingmall.dto;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
public class QnaQDto extends CommonDto{
    private int q_no;
    private int mem_no;
    private String q_title;
    private String q_content;
    private String q_pwd; //필요 없음
    private String q_date;
    private int q_cate;
    private int access_level; //답변 여부

}

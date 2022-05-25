package com.meandbooksteam2.meandbooksteam2.dto;

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
    private Timestamp cmt_date;
}

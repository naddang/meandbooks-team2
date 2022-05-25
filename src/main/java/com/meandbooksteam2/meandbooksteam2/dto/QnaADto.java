package com.meandbooksteam2.meandbooksteam2.dto;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
public class QnaADto {
    private int a_no;
    private int q_no;
    private int mem_no;
    private String a_content;
    private Timestamp a_date;
}

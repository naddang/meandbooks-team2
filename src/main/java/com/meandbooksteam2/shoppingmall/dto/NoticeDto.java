package com.meandbooksteam2.shoppingmall.dto;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
public class NoticeDto {
    private int noti_no;
    private String noti_title;
    private String noti_content;
    private Timestamp noti_date;

}

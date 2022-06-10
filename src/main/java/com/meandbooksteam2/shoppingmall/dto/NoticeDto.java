package com.meandbooksteam2.shoppingmall.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
public class NoticeDto extends CommonDto{
    private int noti_no;
    private String noti_title;
    private String noti_content;
    private String noti_date;

}

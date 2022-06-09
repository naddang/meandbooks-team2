package com.meandbooksteam2.shoppingmall.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrdersDto extends CommonDto{
    private String orders_no;
    private int mem_no;
    private String book_no;
    private String orders_nm;
    private String orders_phoneNo;
    private String orders_addr1;
    private String orders_addr2;
    private String orders_addr3;
    private String orders_date;
    private int orders_qty;
    private int orders_status;
    private int sum;
    private MemberDto member;
    private BookDto book;
}

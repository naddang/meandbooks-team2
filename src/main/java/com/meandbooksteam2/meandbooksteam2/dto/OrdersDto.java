package com.meandbooksteam2.meandbooksteam2.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrdersDto {
    private String orders_no;
    private int mem_no;
    private String book_no;
    private String orders_nm;
    private String orders_phoneNo;
    private String orders_addr;
    private int orders_qty;
    private int orders_status;
}

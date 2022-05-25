package com.meandbooksteam2.shoppingmall.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NoMemOrdersDto {
    private String orders_no;
    private String book_no;
    private String orders_nm;
    private String orders_phoneNo;
    private String orders_addr;
    private int orders_qty;
    private int orders_status;
}

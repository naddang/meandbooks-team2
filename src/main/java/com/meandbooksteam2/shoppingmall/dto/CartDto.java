package com.meandbooksteam2.shoppingmall.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CartDto {
    private String cart_no;
    private int mem_no;
    private String book_no;
    private int cart_qty;
    private int sum;
    private BookDto book;
}

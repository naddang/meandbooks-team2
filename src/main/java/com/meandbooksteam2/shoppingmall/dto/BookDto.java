package com.meandbooksteam2.shoppingmall.dto;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
public class BookDto extends CommonDto{
    private String book_no;
    private String book_nm;
    private String book_desc;
    private String book_img;
    private String book_pub;
    private String book_author;
    private String book_isbn;
    private int book_page;
    private int book_price;
    private int book_stock;
    private String book_pub_date;
    private OrdersDto ordersDto;
}

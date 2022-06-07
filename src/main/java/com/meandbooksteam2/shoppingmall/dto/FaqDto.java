package com.meandbooksteam2.shoppingmall.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FaqDto {
    private int faq_no;
    private int faq_cate;
    private String faq_title;
    private String faq_content;
}

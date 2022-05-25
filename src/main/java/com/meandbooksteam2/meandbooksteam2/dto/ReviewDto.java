package com.meandbooksteam2.meandbooksteam2.dto;

import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;

@Getter
@Setter
public class ReviewDto {
    private int rev_no;
    private int mem_no;
    private String book_no;
    private String rev_title;
    private String rev_content;
    private int rev_rating;
    private Timestamp rev_date;
}

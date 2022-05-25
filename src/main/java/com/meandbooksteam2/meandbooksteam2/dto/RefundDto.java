package com.meandbooksteam2.meandbooksteam2.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RefundDto {
    private String refund_no;
    private String orders_no;
    private String refund_desc;
    private int refund_status;
}

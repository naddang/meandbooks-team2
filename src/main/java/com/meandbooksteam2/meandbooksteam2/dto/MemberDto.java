package com.meandbooksteam2.meandbooksteam2.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberDto {
    private int mem_no;
    private String mem_uid;
    private String mem_pwd;
    private String mem_nm;
    private String mem_phoneNo;
    private String mem_addr;
    private String mem_email;
    private int mem_mileage;
    /*권한과 관련된 필드*/
    private int is_admin;
    private int accessible;
}

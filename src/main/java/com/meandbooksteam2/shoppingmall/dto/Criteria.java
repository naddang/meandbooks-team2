package com.meandbooksteam2.shoppingmall.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

//@Data
@Getter
@Setter
public class Criteria {

//    /* 현재 페이지 번호 */
//    private int pageNum;
//
//    /* 페이지 표시 개수 */
//    private int amount;
//
//    /* 페이지 skip */
//    private int skip;
//
//    /* 검색 타입 */
//    private String type;
//
//    /* 검색 키워드 */
//    private String keyword;
//
//    /* Criteria 생성자 */
//    public Criteria(int pageNum, int amount) {
//        this.pageNum = pageNum;
//        this.amount = amount;
//        this.skip = (pageNum - 1) * amount;
//    }
//
//    /* Criteria 기본 생성자 */
//    public Criteria() {
//        this(1, 10);
//    }
//
//    /* 검색 타입 데이터 배열 변환 */
//    public String[] getTypeArr() {
//        return type == null ? new String[]{} : type.split("");
//    }
//
//    public void setPageNum(int pageNum) {
//        this.pageNum = pageNum;
//        this.skip = (pageNum - 1) * this.amount;
//    }
//
//    public void setAmount(int amount) {
//        this.amount = amount;
//        this.skip = (this.pageNum - 1) * amount;
//    }
//
//    public String makeQueryString(int pageNum) {
//
//        UriComponents uriComponents = UriComponentsBuilder.newInstance()
//                .queryParam("pageNum", pageNum)
//                .queryParam("amount", amount)
//                .queryParam("searchType", type)
//                .queryParam("keyword", keyword)
//                .build()
//                .encode();
//
//        return uriComponents.toUriString();
//    }

    /** 현재 페이지 번호 */
    private int currentPageNo;

    /** 페이지당 출력할 데이터 개수 */
    private int recordsPerPage;

    /** 화면 하단에 출력할 페이지 사이즈 */
    private int pageSize;

    /** 검색 키워드 */
    private String searchKeyword;

    /** 검색 유형 */
    private String searchType;

    public Criteria() {
        this.currentPageNo = 1;
        this.recordsPerPage = 10;
        this.pageSize = 10;
    }

//    public int getStartPage() {
//        return (currentPageNo - 1) * recordsPerPage;
//    }

    public String makeQueryString(int pageNo) {

        UriComponents uriComponents = UriComponentsBuilder.newInstance()
                .queryParam("currentPageNo", pageNo)
                .queryParam("recordsPerPage", recordsPerPage)
                .queryParam("pageSize", pageSize)
                .queryParam("searchType", searchType)
                .queryParam("searchKeyword", searchKeyword)
                .build()
                .encode();

        return uriComponents.toUriString();
    }

}
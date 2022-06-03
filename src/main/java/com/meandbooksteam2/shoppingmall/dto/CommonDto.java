package com.meandbooksteam2.shoppingmall.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommonDto extends Criteria {

    /**
     * 페이징 정보
     */
    private PaginationInfo paginationInfo;
}
package com.wang.common.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Variables {

    private String categorySlug;

    private Integer skip;

    private Integer limit;

    private Filters filters;

}

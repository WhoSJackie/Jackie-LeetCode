package com.wang.common.vo;

import javassist.compiler.ast.Variable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LeetCodeRequestVo {

    private String operationName;

    private String query;

    private Variables variables;

}

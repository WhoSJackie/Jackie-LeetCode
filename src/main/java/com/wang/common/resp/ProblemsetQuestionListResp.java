package com.wang.common.resp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
public class ProblemsetQuestionListResp {

    private String __typename;

    private List<Questions> questions;

    private boolean hasMore;

    private Integer total;

}

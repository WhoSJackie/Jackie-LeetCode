package com.wang.common.resp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class Questions {

    private String __typename;

    private Double acRate;

    private String difficulty;

    private String status;

    private String frontendQuestionId;

    private String title;

    private String titleSlug;
}

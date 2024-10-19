package com.wang.javaL.IO.reportProcessor.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TbFieldPojo {

    private String fname;

    private String fcname;

    private String type;

    private boolean pkFlag;

    private boolean requiredFlag;


}

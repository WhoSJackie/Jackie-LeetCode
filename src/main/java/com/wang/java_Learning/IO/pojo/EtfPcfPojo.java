package com.wang.java_Learning.IO.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EtfPcfPojo {

    private String fundinstrumentid;

    private String  creationredemptionunit;

    private String tradingday;

    private String pretradingday;

    private String navpercu;

    private String nav;

    private String precashcomponent;

    private String estimatedcashcomponent;

    private String maxcashratio;

    private String publishiopvflag;

    private String creationredemptionswitch;

    private String recordnumber;

    private String allcashflag;

    private String allcashamount;

    private String allcashpremiumrate;

    private String allcashdiscountrate;

    private String rtgsflag;

}

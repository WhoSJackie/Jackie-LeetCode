package com.wang.java_Learning.algorithm.code;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HuffmanObj implements Comparable<HuffmanObj>{

    private String val;

    private Integer rate;


    @Override
    public int compareTo(@NotNull HuffmanObj o) {
        return this.rate.compareTo(o.rate);
    }
}

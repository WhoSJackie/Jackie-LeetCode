package com.wang.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Getter
public enum JdbcTypeEnum {

    GAUSSDB("GAUSSDB","org.postgresql.Driver"),
    POSTGRESQL("POSTGRESQL","org.postgresql.Driver"),
    MYSQL("MYSQL","com.mysql.cj.jdbc.Driver");

    private final String value;
    private final String driverName;

}

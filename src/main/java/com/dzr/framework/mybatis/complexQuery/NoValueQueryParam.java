package com.dzr.framework.mybatis.complexQuery;

import lombok.Getter;

public class NoValueQueryParam extends CustomQueryParam {

    @Getter
    private String condition;

    public NoValueQueryParam(String property, String condition) {
        super.property = property;
        this.condition = condition;
    }
}

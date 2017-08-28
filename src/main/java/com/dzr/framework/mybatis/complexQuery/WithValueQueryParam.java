package com.dzr.framework.mybatis.complexQuery;

import lombok.Getter;

public class WithValueQueryParam extends CustomQueryParam {

    @Getter
    private Object value;

    @Getter
    private String operator;

    public WithValueQueryParam(String property, String operator, Object value) {
        super.property = property;
        this.operator = operator;
        this.value = value;
    }

}

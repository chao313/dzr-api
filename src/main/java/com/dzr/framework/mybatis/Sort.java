package com.dzr.framework.mybatis;

import lombok.Data;

import java.io.Serializable;

@Data
public class Sort implements Serializable {

    private static final long serialVersionUID = 7026434198845897214L;
    private String property;
    private String direction;

}

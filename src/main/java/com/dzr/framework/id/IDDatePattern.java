package com.dzr.framework.id;

public enum IDDatePattern {
    PATTERN_MILLIS("yyMMddHHmmssSSS"),
    PATTERN_SECONDS("yyMMddHHmmss"),
    PATTERN_MINUTES("yyMMddHHmm"),
    PATTERN_HOURS("yyMMddHH"),
    PATTERN_DAY("yyMMdd"),;

    private String code;


    private IDDatePattern(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}


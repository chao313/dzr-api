package com.dzr.framework.constant.enums;

/**
 * Created by qiuyangjun on 2014/12/2.
 */
public enum UserStatus {
    NORMAL("正常"), FROZEN("冻结");
    private String type;

    private UserStatus(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return type;
    }
}

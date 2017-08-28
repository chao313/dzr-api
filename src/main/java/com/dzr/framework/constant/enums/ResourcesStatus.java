package com.dzr.framework.constant.enums;


/**
 * Created by qiuyangjun on 2015/1/9.
 */
public enum  ResourcesStatus {
    NORMAL("正常"), FROZEN("冻结");
    private String type;

    private ResourcesStatus(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return type;
    }
}

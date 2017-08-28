package com.dzr.framework.constant.enums;

/**
 * Created by qiuyangjun on 2015/1/9.
 */
public enum ResourcesType {
    MENU("菜单"),BUTTON("按钮"),API("页面调用API接口");

    private String type;

    private ResourcesType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return type;
    }
}

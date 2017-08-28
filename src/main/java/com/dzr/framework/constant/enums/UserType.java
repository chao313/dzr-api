package com.dzr.framework.constant.enums;

public enum UserType {
	ADMIN("管理员"), USER("普通用户");
	private String type;

	private UserType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return type;
	}

}

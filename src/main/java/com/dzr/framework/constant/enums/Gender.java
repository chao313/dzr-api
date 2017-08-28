package com.dzr.framework.constant.enums;

public enum Gender {
	M("男"),F("女");
	
	private String type;
	private Gender(String type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return type;
	}
}

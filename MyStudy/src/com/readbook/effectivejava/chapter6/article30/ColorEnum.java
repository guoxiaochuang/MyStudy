package com.readbook.effectivejava.chapter6.article30;

public enum ColorEnum {
	RED("红色"), BLUE("蓝色"), GREEN("绿色");
	private final String name;

	private ColorEnum(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

}

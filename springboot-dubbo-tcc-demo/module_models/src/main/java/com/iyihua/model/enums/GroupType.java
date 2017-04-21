package com.iyihua.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum GroupType {

	CATEGORY(0, "category"), PROJECT(1, "project"), LOCATION(2, "location");

	private final int id;
	private final String key;

	GroupType(int id, String key) {
		this.id = id;
		this.key = key;
	}
	
	public int getId() {
		return id;
	}
	public String getKey() {
		return key;
	}

	private static final Map<String, GroupType> keyToEnum = new HashMap<String, GroupType>();
	static {
		for (GroupType gt : GroupType.values())
			keyToEnum.put(gt.getKey(), gt);
	}

	public static GroupType fromString(String symbol) {
		return keyToEnum.get(symbol);
	}

	public static void main(String[] args) {
		System.out.println(fromString("category"));
	}
}

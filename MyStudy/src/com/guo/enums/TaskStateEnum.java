package com.guo.enums;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by wdw on 2019/3/7.
 * 任务执行状态
 */

public enum TaskStateEnum {
	Excuting("执行中", 1),
	Finished("已完成", 2),
	Canceled("已取消 ", 3);

	/** 枚举值 */
	private int value;
	/** key */
	private String key;

	private TaskStateEnum(String key, int value) {
		this.value = value;
		this.key = key;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String desc) {
		this.key = desc;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}

	public static TaskStateEnum getEnum(int value) {
		TaskStateEnum resultEnum = null;
		TaskStateEnum[] enumAry = TaskStateEnum.values();
		for (int i = 0; i < enumAry.length; i++) {
			if (enumAry[i].getValue() == value) {
				resultEnum = enumAry[i];
				break;
			}
		}
		return resultEnum;
	}

	public static TaskStateEnum getEnum(String key) {
		TaskStateEnum resultEnum = null;
		TaskStateEnum[] enumAry = TaskStateEnum.values();
		for (int i = 0; i < enumAry.length; i++) {
			if (enumAry[i].getKey().equals(key)) {
				resultEnum = enumAry[i];
				break;
			}
		}
		return resultEnum;
	}

	public static Map<String, Map<String, Object>> toMap() {
		TaskStateEnum[] ary = TaskStateEnum.values();
		Map<String, Map<String, Object>> enumMap = new HashMap<String, Map<String, Object>>();
		for (int num = 0; num < ary.length; num++) {
			Map<String, Object> map = new HashMap<String, Object>();
			String key = String.valueOf(getEnum(ary[num].getValue()));
			map.put("key", ary[num].getKey());
			map.put("value", String.valueOf(ary[num].getValue()));

			enumMap.put(key, map);
		}
		return enumMap;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static List toList() {
		TaskStateEnum[] ary = TaskStateEnum.values();
		List list = new ArrayList();
		for (int i = 0; i < ary.length; i++) {
			Map<String, String> map = new HashMap<String, String>();
			map.put("key", ary[i].getKey());
			map.put("value", String.valueOf(ary[i].getValue()));

			list.add(map);
		}
		return list;
	}

	/**
	 * 取枚举的json字符串
	 *
	 * @return
	 */
	public static String getJsonStr() {
		TaskStateEnum[] enums = TaskStateEnum.values();
		StringBuffer jsonStr = new StringBuffer("[");
		for (TaskStateEnum senum : enums) {
			if (!"[".equals(jsonStr.toString())) {
				jsonStr.append(",");
			}
			jsonStr.append("{id:'").append(senum).append("',key:'").append(senum.getKey()).append("',value:'")
					.append(senum.getValue()).append("'}");
		}
		jsonStr.append("]");

		return jsonStr.toString();
	}
}

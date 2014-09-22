package com.pactera.util;

import net.sf.json.JSONObject;

public class JsonTools {
	
	public JsonTools(){
		
	}

	/*
	 * @param key 表示json字符串的头信息
	 * @param value 对解析的集合的类型
	 */
	public static String createJsonString(String key, Object value){
		JSONObject jsonObject = new JSONObject();
		jsonObject.put(key, value);
		return jsonObject.toString();
	}
}

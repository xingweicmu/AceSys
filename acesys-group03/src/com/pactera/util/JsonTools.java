package com.pactera.util;

import net.sf.json.JSONObject;

public class JsonTools {
	
	public JsonTools(){
		
	}

	/*
	 * @param key ��ʾjson�ַ�����ͷ��Ϣ
	 * @param value �Խ����ļ��ϵ�����
	 */
	public static String createJsonString(String key, Object value){
		JSONObject jsonObject = new JSONObject();
		jsonObject.put(key, value);
		return jsonObject.toString();
	}
}

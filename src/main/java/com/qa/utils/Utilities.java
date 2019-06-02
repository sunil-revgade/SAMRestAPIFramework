package com.qa.utils;

import java.util.HashMap;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.simple.parser.ParseException;

public class Utilities {
	

	public static String getValueByJSONPath(JSONObject resposejson, String jPath) throws JSONException
	{
		Object obj = resposejson;
		for(String s:jPath.split("/"))
		{
			if(!s.isEmpty())
			{
				if(!(s.contains("[") || s.contains("]")))
				{
					obj = 	((JSONObject) obj).get(s);
				}
				else if(s.contains("[") || s.contains("]"))
				{
					obj = ((JSONArray)((JSONObject) obj).get(s.split("\\[")[0])).get(Integer.parseInt(s.split("\\[")[1].replace("]", "")));
				}
			}
		}
		return obj.toString();
	}
	
	public static Object getValueByNode(JSONObject jNode) throws JSONException, ParseException
	{
		JSONObject jo = jNode; 
		Object data = jo.get("data");
		/*String a = data.toString();
		
		HashMap<String, String> hm = new HashMap<String, String>();
		
		Object[] aa = a.split(",");
		System.out.println("!!!!!!!!!!!!!!!"+aa[0]);
		for(int i =0;i<aa.length-1;i++)
		{
			String bb= (String) aa[i];
			Object[] ab = bb.split(":");
		//	System.out.println("Key :"+ab[0].toString().trim()+" : Value : "+ab[1]);
			
			hm.put(ab[0].toString().trim(), ab[1].toString().trim());
			System.out.println(hm);
		}*/
        return data;
	}

}

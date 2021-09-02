package apiTest;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONObject;

public class jsonParser {

	
	public static void main(String[] args) throws Exception {
		
		
		File f = new File("C:\\Users\\aa\\Desktop\\examJson.txt");
		
		Scanner sc = new Scanner(f);
		
		StringBuilder sb = new StringBuilder();
		
		while (sc.hasNext()) {
			sb.append(sc.next());
		}
		
		sc.close();
		
		String targetStr = sb.toString(); 
		System.out.println(targetStr);
		JSONObject jObject = new JSONObject(targetStr);
		JSONObject resp = jObject.getJSONObject("response");
		JSONObject body = resp.getJSONObject("body");
		JSONObject items = body.getJSONObject("items");
		JSONArray itemArray = items.getJSONArray("item"); 
		
		List<Map<String, String>> hmapList = new ArrayList<Map<String,String>>();
		
		for (int i = 0; i < itemArray.length(); i++) {
			
			Map<String, String> hMap = new HashMap<String, String>();
			hmapList.add(hMap);
			
			JSONObject obj = itemArray.getJSONObject(i);
			
			Iterator<String> keys = obj.keys();
			
			while (keys.hasNext()) {
				
				//타입 확인
				String key = (String)keys.next();
				hMap.put(key, String.valueOf(obj.get(key)));
			}
		}
		
		
		for (Map<String, String> rsMap : hmapList) {
			
			Iterator<String> keys = rsMap.keySet().iterator();
			while (keys.hasNext()) {
				String key =keys.next();
				System.out.println(String.format("key : %s , value : %s", key , rsMap.get(key)));
			}
			System.out.println();
		}
	}
}

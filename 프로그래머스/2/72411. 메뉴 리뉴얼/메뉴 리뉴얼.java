import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
class Solution {
    static public String[] solution(String[] orders, int[] course) {
		List<String> list = new ArrayList<>();
		for(int i=0; i<course.length; i++){
			List<String> tempList = courseFunction(course[i], orders);
			for(String str : tempList){
				list.add(str);
			}
		}
		Collections.sort(list);
		return list.toArray(new String[list.size()]);
	}
    static List<String> courseFunction(int number, String[] orders){
		HashMap<String, Integer> ha = new HashMap<>();
		for(int i=0; i<orders.length; i++){
			int count = 0;
			dfs(number, orders[i], count, "", 0, ha);
		}
		
		List<String> list = new ArrayList<>();
		int max = 0;
		Iterator<String> it = ha.keySet().iterator();
		while(it.hasNext()){
			String key = it.next();
			if(ha.get(key) > 1){
				if(max < ha.get(key)){
					max = ha.get(key);
					list.clear();
					list.add(key);
				}else if(max == ha.get(key)){
					list.add(key);
				}
			}
			
		}
		return list;
	}
	
	static void dfs(int number, String order, int count, String getStr, int getInt, HashMap<String, Integer> ha){
		count++;
		if(count == number){
			for(int i=getInt; i<order.length(); i++){
				String temp = getStr + String.valueOf(order.charAt(i));
				char[] StringtoChar = temp.toCharArray();
				Arrays.sort(StringtoChar);
				String SortedString = new String(StringtoChar);
				if(ha.containsKey(SortedString)) ha.replace(SortedString, ha.get(SortedString)+1);
				else ha.put(SortedString, 1);
			}
			return;
		}else{
			for(int i=getInt; i<order.length(); i++){
				String temp = getStr + String.valueOf(order.charAt(i));
				char[] StringtoChar = temp.toCharArray();
				Arrays.sort(StringtoChar);
				String SortedString = new String(StringtoChar);
				dfs(number, order, count, SortedString, i+1, ha);
			}
		}
	}
}
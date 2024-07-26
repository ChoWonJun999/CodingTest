import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        Set<String> repoSet = new HashSet<>();
		for(String str : report){
			repoSet.add(str);
		}
        
		HashMap<String, Set<String>> repo = new HashMap<>();
		HashMap<String, Integer> stop = new HashMap<>();
		
		for(String str : repoSet){
			String[] temp = str.split(" ");
			if(!stop.containsKey(temp[1])) stop.put(temp[1], 1);
			else stop.replace(temp[1], stop.get(temp[1])+1);
			
			Set<String> set = new HashSet<>();
			if(!repo.containsKey(temp[0])){
				set.add(temp[1]);
				repo.put(temp[0], set);
			}else{
				if(repo.get(temp[0]) != null) set = repo.get(temp[0]);
				set.add(temp[1]);
				repo.replace(temp[0], set);
			}
		}
		
		List<String> list = new ArrayList<>();
		for(String key : stop.keySet()){
			Integer value = stop.get(key);
			if(value >= k) list.add(key);
		}
		
		int[] answer = new int[id_list.length];
		
		for(int i=0; i<id_list.length; i++){
			if(repo.get(id_list[i]) != null){
				Set<String> temp = repo.get(id_list[i]);
				for(String str1 : temp){
					for(String ss : list){
						if(str1.equals(ss)){
							answer[i] += 1;
						}
					}
				}
			}
		}
		return answer;
    }
}
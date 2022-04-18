package Kakao;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class GetReport {
	public static void main(String[] args) {
		String[] id_list = {"muzi", "frodo", "apeach", "neo"};
		String[] report = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
		int k = 2;
		
		// [2,1,1,0]
		System.out.print("[");
		for(int i=0; i<solution(id_list, report, k).length; i++){
			if(i == solution(id_list, report, k).length-1){
				System.out.print(solution(id_list, report, k)[i]);
			}else{
				System.out.print(solution(id_list, report, k)[i] + ", ");
			}
		}
		System.out.println("]");
		
		String[] id_list1 = {"con", "ryan"};
		String[] report1 = {"ryan con", "ryan con", "ryan con", "ryan con"};
		int k1 = 3;
		
		// [0,0]
		System.out.print("[");
		for(int i=0; i<solution(id_list1, report1, k1).length; i++){
			if(i == solution(id_list1, report1, k1).length-1){
				System.out.print(solution(id_list1, report1, k1)[i]);
			}else{
				System.out.print(solution(id_list1, report1, k1)[i] + ", ");
			}
		}
		System.out.println("]");
	}
	public static int[] solution(String[] id_list, String[] report, int k) {
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
class OtherSolution{
	public int[] solution(String[] id_list, String[] report, int k) {
		List<String> list = Arrays.stream(report).distinct().collect(Collectors.toList());
		HashMap<String, Integer> count = new HashMap<>();
		for (String s : list) {
			String target = s.split(" ")[1];
			count.put(target, count.getOrDefault(target, 0) + 1);
		}
		
		return Arrays.stream(id_list).map(_user -> {
			final String user = _user;
			List<String> reportList = list.stream().filter(s -> s.startsWith(user + " ")).collect(Collectors.toList());
			return reportList.stream().filter(s -> count.getOrDefault(s.split(" ")[1], 0) >= k).count();
		}).mapToInt(Long::intValue).toArray();
	}
}
package Kakao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;

public class TakingAGroupPhoto {
	
	static int functionCount = 0;
	static String[] condition;
	static int cnt;
	static int deepCnt;
	
	public static void main(String[] args) {
		int n = 2;
		String[] data = {"N~F=0", "R~T>2"};
//		String[] data = {"A~C=0", "C~F=0", "F~J=0", "J~M=0", "M~N=0", "N~R=0", "R~T=0"};
		
		int sol = solution(n, data);
		
		System.out.println(sol);	// 3648
		
		System.out.println();
		
		functionCount = 0;
		
		int n1 = 2;
		String[] data1 = {"M~C<2", "C~M>1"};
		int sol1 = solution(n1, data1);
		System.out.println(sol1);	// 0
	}
	
	// 다른 사람 정답
	static String[] arr = {"A","C","F","J","M","N","R","T"};
	static String[] result = new String[8];
	static boolean[] used = new boolean[8];
	static int answer;
	
	public static int solution(int n, String[] data) {
		answer = 0;
		perm(0, data);
		return answer;
	}
	
	static void perm(int cnt, String[] data){
		if(cnt==8){
			String s = "";
			for(int i=0; i<arr.length; i++){
				s+=result[i];
			}
			for(int i=0; i<data.length; i++){
				int start = s.indexOf(data[i].charAt(0));
				int end = s.indexOf(data[i].charAt(2));
				
				if(data[i].charAt(3)=='=' && Math.abs(start-end)-1!=data[i].charAt(4)-'0'){
					return;
				}else if(data[i].charAt(3)=='<' && Math.abs(start-end)-1>=data[i].charAt(4)-'0'){
					return;
				}else if(data[i].charAt(3)=='>' && Math.abs(start-end)-1<=data[i].charAt(4)-'0'){
					return;
				}
			}
			answer++;
			return;
		}
		
		for(int i=0; i<arr.length; i++){
			if(!used[i]){
				used[i] = true;
				result[cnt] = arr[i];
				perm(cnt+1, data);
				used[i] = false;
			}
		}
	}
	
	/*
	// 내 정답~~~~~
	public static int solution(int n, String[] data) {
		condition = data;
		cnt = 0;
		deepCnt = 0;
		
		HashMap<String, Integer> friends = new HashMap<>();
		friends.put("A", -1);
		friends.put("C", -1);
		friends.put("F", -1);
		friends.put("J", -1);
		friends.put("M", -1);
		friends.put("N", -1);
		friends.put("R", -1);
		friends.put("T", -1);
		
		HashMap<Integer, Boolean> position = new HashMap<>();
		for(int i=0; i<8; i++) position.put(i, false);
		
		dfs(0, friends, position);
		
		return cnt*factual(deepCnt);
	}
	
	static void dfs(int deep, HashMap<String, Integer> friends, HashMap<Integer, Boolean> position){
		String[] getCondition = condition[deep].split("");
		deep++;
		
		int x = friends.get(getCondition[0]);
		int y = friends.get(getCondition[2]);
		int abs = x<y ? y-x : x-y;
		int value = Integer.valueOf(getCondition[4])+1;
		
		if(x==-1 && y==-1){
			for(int i=0; i<8; i++){
				if(position.get(i)) continue;
				
				friends.replace(getCondition[0], i);
				position.replace(i, true);
				
				for(int j=0; j<8; j++){
					if(position.get(j)) continue;
					
					friends.replace(getCondition[2], j);
					position.replace(j, true);
					
					abs = i<j ? j-i : i-j;
					
					switch(getCondition[3]){
						case "<" :
							if(abs<value){
								countOrDfs(deep, friends, position);
							}
							break;
						case ">" :
							if(abs>value){
								countOrDfs(deep, friends, position);
							}
							break;
						default:
							if(abs==value){
								countOrDfs(deep, friends, position);
							}
							break;
					}
					friends.replace(getCondition[2], -1);
					position.replace(j, false);
				}
				friends.replace(getCondition[0], -1);
				position.replace(i, false);
			}
		}else if(x==-1 || y==-1){
			String temp = "";
			
			if(x==-1) temp = getCondition[0];
			else if(y==-1) temp = getCondition[2];
			
			for(int i=0; i<8; i++){
				if(position.get(i)) continue;
				friends.replace(temp, i);
				position.replace(i, true);
				
				x = friends.get(getCondition[0]);
				y = friends.get(getCondition[2]);
				
				abs = x<y ? y-x : x-y;
				switch(getCondition[3]){
					case "<" :
						if(abs<value){
							countOrDfs(deep, friends, position);
						}
						break;
					case ">" :
						if(abs>value){
							countOrDfs(deep, friends, position);
						}
						break;
					default:
						if(abs==value){
							countOrDfs(deep, friends, position);
						}
						break;
				}
				friends.replace(temp, -1);
				position.replace(i, false);
			}
		}else{
			switch(getCondition[3]){
				case "<" :
					if(abs<value){
						countOrDfs(deep, friends, position);
					}else return;
					break;
				case ">" :
					if(abs>value){
						countOrDfs(deep, friends, position);
					}else return;
					break;
				default:
					if(abs==value){
						countOrDfs(deep, friends, position);
					}else return;
					break;
			}
		}
	}
	
	static void countOrDfs(int deep, HashMap<String, Integer> friends, HashMap<Integer, Boolean> position){
		if(condition.length-1 < deep){
			deepCnt = unusedCount(friends);
			cnt++;
			System.out.println(friends);
		}else dfs(deep, friends, position);
	}
	
	static int unusedCount(HashMap<String, Integer> friends){
		int count = 0;
		Iterator<String> it = friends.keySet().iterator();
		while(it.hasNext()){
			if(friends.get(it.next()) == -1) count++;
		}
		return count;
	}
	
	static int factual(int number){
		int result = 1;
		for(int i=number; i>1; i--) result *= i;
		return result;
	}
	*/
	
	/*
	public static int solution(int n, String[] data){
		condition = data;
		cnt = 0;
		ha = new HashMap<>(); 
		
		for(String str : data){
			String[] temp = str.split("");
			ha.put(temp[0], -1);
			ha.put(temp[2], -1);
		}
		
		dfs(-1);
		
		return cnt * factual(8-ha.size());
	}
	
	static void dfs(int cur){
		Iterator<String> it = ha.keySet().iterator();
		while(it.hasNext()){
			String str = it.next();
			for(int i=cur+1; i<8; i++){
				if(ha.get(str) == -1){
					ha.replace(str, i);
					switch(chkCondition()){
						case 0 :
							dfs(i);
							break;
						case 1 :
							cnt++;
							break;
					}
					ha.replace(str, -1);
				}
			}
		}
	}
	
	static int chkCondition(){
		for(String str : condition){
			String[] temp = str.split("");
			int x = ha.get(temp[0]);
			int y = ha.get(temp[2]);
			
			if(x==-1 || y==-1) return 0;
			
			int abs = x < y ? y-x : x-y;
			int distance = Integer.valueOf(temp[4])+1;
			
			switch(temp[3]){
				case "<" :
					if(!(abs < distance)) return -1;
					break;
				case ">" :
					if(!(abs > distance)) return -1;
					break;
				default :
					if(!(abs == distance)) return -1;
					break;
			}
		}
		
		return 1;
	}
	
	static int factual(int number){
		if(number <= 1) return 1;
		else return number*factual(number-1);
	}
	*/
	/*
	public static int solution(int n, String[] data){
		condition = data;
		int answer = 0;
		String[] location = new String[8];
		ArrayList<String> useFriends = new ArrayList<String>();
		
		for(String str : data){
			String[] temp = str.split("");
			if(!useFriends.contains(temp[0])) useFriends.add(temp[0]);
			if(!useFriends.contains(temp[2])) useFriends.add(temp[2]);
		}
		for(int i=0; i<useFriends.size(); i++){
			String getStr = useFriends.get(0);
			useFriends.remove(0);
			for(int j=0; j<8; j++){
				if(location[j] == null){
					location[j] = getStr;
					answer = makeCase(j, answer, location, useFriends);
					location[j] = null;
				}
			}
			useFriends.add(getStr);
		}
		
		System.out.println(functionCount);
		
		return answer * factual(8-useFriends.size());
	}
	
	static int makeCase(int cur, int count, String[] location, ArrayList<String> useFriends){
		functionCount++;
		
		for(int i=0; i<useFriends.size(); i++){
			String getStr = useFriends.get(0);
			useFriends.remove(0);
			for(int j=cur; j<8; j++){
				if(location[j] == null){
					location[j] = getStr;
					if(chkCondition(location, useFriends)) count++;
					else count = makeCase(j, count, location, useFriends);
					
					location[j] = null;
				}
			}
			useFriends.add(getStr);
		}
		return count;
	}
	
	static boolean chkCondition(String[] location, ArrayList<String> useFriends){
		for(String str : condition){
			String[] temp = str.split("");
			int x = indexOf(location, temp[0]);
			int y = indexOf(location, temp[2]);
			
			if(x==-1 || y==-1) return false;
			
			switch(temp[3]){
				case "<" :
					if(!(Math.abs(x-y) < Integer.valueOf(temp[4])+1)) return false;
					break;
				case ">" :
					if(!(Math.abs(x-y) > Integer.valueOf(temp[4])+1)) return false;
					break;
				default :
					if(!(Math.abs(x-y) == Integer.valueOf(temp[4])+1)) return false;
					break;
			}
		}
		
		return true;
	}
	
	static int indexOf(String[] arr, String key) {
		return Arrays.asList(arr).indexOf(key);
	}
	
	static int factual(int number){
		if(number <= 1) return 1;
		else return number*factual(number-1);
	}
	*/
	
	/*
	public static int solution(int n, String[] data){
		int answer = 0;
		
		String[] memberStr = {"A", "C", "F", "J", "M", "N", "R", "T"};
		ArrayList<String> member = new ArrayList<>();
		for(String str : memberStr) member.add(str);
		
		ArrayList<String> testCase = new ArrayList<>();
		
		for(int i=0; i<member.size(); i++){
			ArrayList<String> condition = new ArrayList<>();
			for(String str : data) condition.add(str);
			
			String str = member.get(0);
			member.remove(0);
			testCase.add(str);
			
			answer = makeCase(answer, testCase, member, condition);
			
			testCase.remove(str);
			member.add(str);
		}
		System.out.println("cnt = " + a);
		return answer;
	}
	
	public static int makeCase(int answer, ArrayList<String> testCase, ArrayList<String> member, ArrayList<String> con){
		a++;
		if(testCase.size()==8) return ++answer;
		for(int i=0; i<member.size(); i++){
			ArrayList<String> condition = new ArrayList<>();
			for(String str : con) condition.add(str);
			
			String str = member.get(0);
			member.remove(0);
			testCase.add(str);
			if(chk(testCase, condition)){
				answer = makeCase(answer, testCase, member, condition);
			}
			testCase.remove(str);
			member.add(str);
		}
		return answer;
	}
	
	public static boolean chk(ArrayList<String> testCase, ArrayList<String> condition){
		for(int i=0; i<condition.size(); i++){
			String tempStr = condition.get(0);
			condition.remove(0);
			String[] temp = tempStr.split("");
			int x = testCase.indexOf(temp[0]);
			int y = testCase.indexOf(temp[2]);
			
			if(testCase.contains(temp[0]) && testCase.contains(temp[2])){
				switch(temp[3]){
					case "<" :
						if(!(Math.abs(x-y) < Integer.valueOf(temp[4])+1)){
							return false;
						}
						break;
					case ">" :
						if(!(Math.abs(x-y) > Integer.valueOf(temp[4])+1)){
							return false;
						}
						break;
					default :
						if(!(Math.abs(x-y) == Integer.valueOf(temp[4])+1)){
							return false;
						}
				}
			}else{
				condition.add(tempStr);
				return true;
			}
			condition.add(tempStr);
		}
		return true;
	}
	*/
}
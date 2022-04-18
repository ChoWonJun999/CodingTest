package TestKit;

import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;

public class Network {
	public static void main(String[] args) {
		Solution36 sol = new Solution36();
		int n = 3; int[][] computers = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
		int n1 = 3; int[][] computers1 = {{1, 1, 0}, {1, 1, 1}, {0, 1, 1}};
		System.out.println(sol.solution(n, computers));
		System.out.println(sol.solution(n1, computers1));
	}
}
class Solution36{
	HashMap<Integer, Set<Integer>> map;
	public int solution(int n, int[][] computers) {
		map = new HashMap<>();
		
		for(int i=0; i<n; i++) {
			Set<Integer> set = new HashSet<>();
			for(int j=0; j<n; j++) {
				if(computers[i][j]==1) {
					set.add(j);
				}
			}
			map.put(i, set);
		}
		
		Set<Set<Integer>> bigSet = new HashSet<>();
		for(int i=0; i<n; i++) bigSet.add(SubSet(map.get(i), i));
		
		return bigSet.size();
	}
	Set<Integer> SubSet(Set<Integer> set, int x) {
		Set<Integer> tempSet = new HashSet<>();
		tempSet.addAll(set);
		
		Iterator<Integer> it = map.get(x).iterator();
		while(it.hasNext()) {
			int value = it.next();
			if(set.contains(value)) {
				if(!set.containsAll(map.get(value))) {
					tempSet.addAll(map.get(value));
					tempSet = SubSet(tempSet, value);
				}
			}
		}
		return tempSet;
	}
}
/*
	public int solution(int n, int[][] computers) {
		int answer=0;
		boolean[] chk = new boolean[n];
		for(int i=0; i<n; i++){
			if(!chk[i]){
				dfs(computers, chk, i);
				answer++;
			}
		}
		return answer;
	}
	void dfs(int[][] computers, boolean[] chk, int start){
		chk[start] = true;
		for(int i=0; i<computers.length; i++){
			if(computers[start][i]==1 && !chk[i]){
				dfs(computers, chk, i);
			}
		}
	}
*/
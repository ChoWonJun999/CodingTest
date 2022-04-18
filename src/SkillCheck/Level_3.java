package SkillCheck;

import java.util.*;

public class Level_3 {
	public static void main(String[] args) {
		Solution sol = new Solution();
		int n = 7;
		int m = 10;
		int[][] edge_list = {{1, 2}, {1, 3}, {2, 3}, {2, 4}, {3, 4}, {3, 5}, {4, 6}, {5, 6}, {5, 7}, {6, 7}};
		int k = 6;
		int[] gps_log = {1, 2, 3, 3, 6, 7};
		System.out.println(sol.solution(n, m, edge_list, k, gps_log));
		// answer = 1;
		
		n = 7;
		m = 10;
		int[][] edge_list1 = {{1, 2}, {1, 3}, {2, 3}, {2, 4}, {3, 4}, {3, 5}, {4, 6}, {5, 6}, {5, 7}, {6, 7}};
		k = 6;
		int[] gps_log1 = {1, 2, 4, 6, 5, 7};
		System.out.println(sol.solution(n, m, edge_list1, k, gps_log1));
		// answer = 0;
	}
}
class Solution{
	public int solution(int n, int m, int[][] edge_list, int k, int[] gps_log) {
		int answer = gps_log.length-1;
		Deque<Integer> deque = new LinkedList<>();
		
		deque.add(gps_log[0]);
		for(int i=1; i<gps_log.length; i++){
			deque.add(gps_log[i]);
			if(deque.size() > 2){
				deque.pop();
			}
			System.out.println(deque);
			if(deque.getFirst() == deque.getLast()){
				answer--;
			}
			for(int j=0; j<edge_list.length; j++){
				if((edge_list[j][0] == deque.getFirst() && edge_list[j][1] == deque.getLast()) || edge_list[j][0] == deque.getLast() && edge_list[j][1] == deque.getFirst()){
					answer--;
				}
			}
		}
		return answer;
	}
}
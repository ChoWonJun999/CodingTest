package TestKit;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Print {
	public static void main(String[] args) {
		Solution8 sol = new Solution8();
		int[] priorities = {2, 1, 3, 2};
		int location = 2;
		int[] priorities1 = {1,1,9,1,1,1};
		int location1 = 0;
		System.out.println(sol.solution(priorities, location));
		System.out.println(sol.solution(priorities1, location1));
	}
}
class Solution8{
	public int solution(int[] priorities, int location) {
		int answer = 0; 
		int l = location;
		Queue<Integer> que = new LinkedList<Integer>();
		for(int i: priorities) que.add(i);
		
		Arrays.sort(priorities);
		int size = priorities.length-1;
		
		while(!que.isEmpty()) {
			Integer i = que.poll();
			if(i==priorities[size-answer]) {
				answer++;
				l--;
				if(l<0) break;
			}else {
				que.add(i);
				l--;
				if(l<0) l = que.size()-1;
			}
		}
		return answer;
	}
}
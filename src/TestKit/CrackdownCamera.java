package TestKit;

import java.util.PriorityQueue;

public class CrackdownCamera {
	public static void main(String[] args) {
		Solution26 sol = new Solution26();
		int[][] routes = {{-20, 15}, {-14, -5}, {-18, -13}, {-5, -3}};
		System.out.println(sol.solution(routes));
	}
}
class Solution26{
	public int solution(int[][] routes) {
		PriorityQueue<int[]> prque = new PriorityQueue<>((a,b)->a[0]-b[0]);
		for(int[] i : routes) prque.add(i);
		int[] initial = {-30000,30000};
		int count=1;
		while(!prque.isEmpty()) {
			int[] poll = prque.poll();
			if(initial[0]<=poll[0] && initial[1]>=poll[1]) {
				initial = poll;
			}else if(initial[0]<=poll[0] && initial[1]<poll[1] && initial[1]>=poll[0]) {
				initial[0] = poll[0];
			}else if(initial[0]>poll[0] && initial[1]>=poll[1] && initial[0]<=poll[1]) {
				initial[1] = poll[1];
			}else if(initial[0]>poll[0] && initial[1]<poll[1]) {
			}else {
				count++;
				prque.add(poll);
				initial[0] = -30000;
				initial[1] = 30000;
			}
		}
		return count;
		/*
		Arrays.sort(routes, (a,b) -> Integer.compare(a[1], b[1]));
		int ans = 0;
		int last = Integer.MIN_VALUE;
		for(int[] a: routes) {
			if(last<a[0]) {
				++ans;
				last=a[1];
			}
		}
		return ans;
		*/
	}
}
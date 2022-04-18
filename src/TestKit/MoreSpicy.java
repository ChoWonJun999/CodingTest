package TestKit;

import java.util.PriorityQueue;

public class MoreSpicy {
	public static void main(String[] args) {
		Solution13 sol = new Solution13();
		int[] scoville = {1, 2, 3, 9, 10, 12};
		int K = 7;
		System.out.println(sol.solution(scoville, K));
	}
}
class Solution13{
	public int solution(int[] scoville, int K) {
		int answer = 0;
		PriorityQueue<Integer> prque = new PriorityQueue<Integer>();
		for(int i : scoville) prque.add(i);
		int x,y,z;
		while(!prque.isEmpty()) {
			x = prque.peek();
			if(x>=K) break;
			prque.remove(x);
			if(prque.isEmpty()) {answer =-1; break;}
			y = prque.peek();
			prque.remove(y);
			z = x+(y*2);
			prque.add(z);
			answer++;
		}
		return answer;
	}
}
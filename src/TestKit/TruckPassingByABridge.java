package TestKit;

import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;

public class TruckPassingByABridge {
	public static void main(String[] args) {
		Solution9 sol = new Solution9();
		int bridge_length = 2;
		int weight = 10;
		int[] truck_weights = {7, 4, 5, 6};
		int bridge_length1 = 100;
		int weight1 = 100;
		int[] truck_weights1 = {10};
		int bridge_length2 = 100;
		int weight2 = 100;
		int[] truck_weights2 = {10,10,10,10,10,10,10,10,10,10};
		System.out.println(sol.solution(bridge_length, weight, truck_weights));
		System.out.println(sol.solution(bridge_length1, weight1, truck_weights1));
		System.out.println(sol.solution(bridge_length2, weight2, truck_weights2));
	}
}
class Solution9{
	public int solution(int bridge_length, int weight, int[] truck_weights) {
		int answer = 0;
		int k=0, count=0;
		
		Deque<Integer> deque = new LinkedList<Integer>();
		for(int i=0; i<bridge_length; i++) deque.add(0);
		
		while(!deque.isEmpty()) {
			if(k>truck_weights.length-1) {
				answer=count+bridge_length;
				break;
			}
			Iterator<Integer> it = deque.iterator();
			int sum=0;
			while(it.hasNext()) sum+=it.next();
			sum+=truck_weights[k];
			sum-=deque.getFirst();
			
			if(sum>weight) {
				deque.add(0);
				if(deque.size()>bridge_length) deque.removeFirst();
			}else {
				deque.add(truck_weights[k]);
				k++;
				if(deque.size()>bridge_length) deque.removeFirst();
			}
			count++;
		}
		return answer;
	}
}

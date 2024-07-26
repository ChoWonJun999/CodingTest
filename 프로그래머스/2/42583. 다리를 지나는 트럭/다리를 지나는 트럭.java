import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
class Solution {
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
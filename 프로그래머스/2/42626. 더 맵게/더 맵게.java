import java.util.PriorityQueue;
class Solution {
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
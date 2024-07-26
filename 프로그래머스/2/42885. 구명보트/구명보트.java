import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
class Solution {
    public int solution(int[] people, int limit) {
        int count=0;
		Arrays.sort(people);
		Deque<Integer> deque = new LinkedList<>();
		for(int i:people) deque.add(i);
		
		while(!deque.isEmpty()) {
			int pollLast = deque.pollLast();
			if(deque.size()>0 && pollLast+deque.peekFirst()<=limit) {
				deque.pollFirst();
			}
			count++;
		}
		return count;
    }
}
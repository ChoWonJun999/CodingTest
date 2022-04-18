package TestKit;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
public class Lifeboat {
	public static void main(String[] args) {
		Solution24 sol = new Solution24();
		int[] people = {70, 50, 80, 50}; int limit = 100;
		int[] people1 = {70, 80, 50}; int limit1 = 100;
		System.out.println(sol.solution(people, limit));
		System.out.println(sol.solution(people1, limit1));
	}

}
class Solution24{
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
		/*
		Arrays.sort(people);
		for(int i=0,j=people.length-1; i<j; --j){
			if(people[i]+people[j]<=limit){
				++i;
			}
		}
		return people.length-i;
		*/
	}
}
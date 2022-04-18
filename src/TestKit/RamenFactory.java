package TestKit;

import java.util.PriorityQueue;

public class RamenFactory {
	public static void main(String[] args) {
		Solution14 sol = new Solution14();
		int stock = 4;
		int[] dates = {4, 10, 15};
		int[] supplies = {20,5,10};
		int k = 30;
		System.out.println(sol.solution(stock, dates, supplies, k));
	}
}
class Solution14{
	public int solution(int stock, int[] dates, int[] supplies, int k) {
		PriorityQueue<Integer> pr = new PriorityQueue<>((a,b)-> b-a);
		int date=0, count=0;
		for(int day=0; day<k; day++) {
			if(date<dates.length&&day>=dates[date]) {
				pr.add(supplies[date]);
				date++;
			}
			if(stock<= 0) {
				stock+= pr.poll();
				count++;
			}
			stock--;
		}
		return count;
	}
}
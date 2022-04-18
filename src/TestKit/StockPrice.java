package TestKit;

import java.util.LinkedList;
import java.util.Queue;

public class StockPrice {
	public static void main(String[] args) {
		Solution12 sol = new Solution12();
		int[] prices = {1, 2, 3, 2, 3};
		for(int i=0; i<prices.length; i++) System.out.print(sol.solution(prices)[i]+" ");
		System.out.println();
		int[] prices1 = {2, 2, 3, 2, 3, 1};
		for(int i=0; i<prices1.length; i++) System.out.print(sol.solution(prices1)[i]+" ");
	}
}
class Solution12{
	public int[] solution(int[] prices) {
		int[] answer = new int[prices.length];
		
		Queue<Integer> que = new LinkedList<Integer>();
		for(int i: prices) que.add(i);
		int count=0;
		int j=0;
		while(!que.isEmpty()) {
			Integer x = que.poll();
			for(Integer i: que) {
				if(x<=i) count++;
				else {
					count++;
					break;
				}
			}
			answer[j]=count;
			count=0;
			j++;
			if(j>answer.length) break;
		}
		return answer;
		/*
		int[] answer = new int[prices.length];
		for(int i=0; i<prices.length; i++) {
			for(int j=i+1; j<prices.length;j++) {
				if(prices[i]>prices[j]) {
					answer[i] = j-i;
					break;
				}else answer[i] = j-i;
			}
		}
		return answer;
		*/
	}
}
package TestKit;

import java.util.Arrays;

import java.util.PriorityQueue;

public class Budget {
	public static void main(String[] args) {
		Solution39 sol = new Solution39();
		int[] budgets = {120, 110, 140, 150}; int M = 485;
		System.out.println(sol.solution(budgets, M));
	}
}
class Solution39{
	public int solution(int[] budgets, int M) {
		Arrays.sort(budgets);
		int start = 0, end = budgets[budgets.length-1];
		while(start<=end){
			int sum = 0;
			int mid = (start+end)/2;
			System.out.println("start = "+start+", end = "+end+", mid = "+mid);
			for(int element:budgets) sum = element>mid? sum+mid : sum+element;
			System.out.println("sum = "+sum+", M = "+M);
			if(sum>M) end = mid-1;
			else start = mid+1;
		}
		return end;
		/*
		PriorityQueue<Integer> que = new PriorityQueue<>((a,b)->a-b);
		for(Integer i:budgets) que.add(i); 
		double dp = (double)M/budgets.length;
		double sum = M;
		while(!que.isEmpty()) {
			while(!que.isEmpty()) {
				if(que.peek()<dp) {
					if(que.size()==1) return que.poll();
					sum-=que.poll();
				}else break;
			}
			dp = sum/que.size();
			if(que.peek()>dp) break;
		}
		return (int)dp;
		*/
	}
}
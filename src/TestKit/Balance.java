package TestKit;

import java.util.Arrays;

public class Balance {
	public static void main(String[] args) {
		Solution27 sol = new Solution27();
		int[] weight = {3, 1, 6, 2, 7, 30, 1};
		System.out.println(sol.solution(weight));
	}
}
class Solution27{
	public int solution(int[] weight) {
		Arrays.parallelSort(weight);
		int sum=0;
		for(int i=0; i<weight.length; i++) {
			if(sum+1<weight[i]) return sum+1;
			sum+=weight[i];
		}
		return sum+1;
	}
}
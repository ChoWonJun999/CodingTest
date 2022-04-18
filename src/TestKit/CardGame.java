package TestKit;

import java.util.Queue;
import java.util.LinkedList;
public class CardGame {
	public static void main(String[] args) {
		Solution32 sol = new Solution32();
		int[] left = {3, 2, 5}; int[] right = {2, 4, 1};				//7
		int[] left1 = {1,1,9,1,1,1,1}; int[] right1 = {8,9,3,3,3,3,3};	//15
		int[] left2 = {1,1,9,1,1,1,1}; int[] right2 = {8,9,1,1,1,1,1};	//8
		int[] left3 = {1, 1, 1, 1, 3}; int[] right3 = {2, 3, 1, 1, 1};	//3
		System.out.println(sol.solution(left, right));
		System.out.println(sol.solution(left1, right1));
		System.out.println(sol.solution(left2, right2));
		System.out.println(sol.solution(left3, right3));
	}
}
class Solution32{	//�� �̷������� �Ѱ��� �ϳ��� �𸣰���
	public int solution(int[] left, int[] right) {
		int answer = 0;
		int[][] dp = new int[left.length+1][right.length+1];
		
		for(int i=1; i<left.length+1; i++) {
			for(int j=1; j<right.length+1; j++) {
				if(left[left.length-i] > right[right.length-j]) {
					dp[i][j] = Math.max(dp[i][j-1]+right[right.length-j], Math.max(dp[i-1][j], dp[i-1][j-1]));
				}else {
					dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-1]);
				}
			}
		}
		answer = dp[left.length][right.length];
		return answer;
	}
}
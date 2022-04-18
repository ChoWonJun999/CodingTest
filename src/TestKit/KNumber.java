package TestKit;

import java.util.Arrays;
public class KNumber{
	public static void main(String[] args) {
		Solution sol = new Solution();
		int[] array = {1,5,2,6,3,7,4};
		int[][] commands = {{2,5,3},{4,4,1},{1,7,3}};
		int[] a = sol.solution(array, commands).clone();
		for(int i=0; i<a.length; i++) {
			System.out.print(a[i]+"\t");
		}
	}
}
class Solution{
	public int[] solution(int[] array, int[][] commands) {
		int [] answer = new int[commands.length];
		for(int i=0; i<answer.length; i++) {
			int[] arc = Arrays.copyOfRange(array, commands[i][0]-1, commands[i][1]);
			Arrays.sort(arc);
			answer[i] = arc[commands[i][2]-1];
		}
		return answer;
	}
}
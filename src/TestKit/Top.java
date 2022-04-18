package TestKit;

public class Top {
	public static void main(String[] args) {
		Solution7 sol = new Solution7();
		int[] heights = {6, 9, 5, 7, 4};
		int[] heights1 = {3, 9, 9, 3, 5, 7, 2};
		int[] heights2 = {1, 5, 3, 6, 7, 6, 5};
		for(int i=0; i<heights.length; i++) System.out.print(sol.solution(heights)[i]+" ");
		System.out.println();
		for(int i=0; i<heights1.length; i++) System.out.print(sol.solution(heights1)[i]+" ");
		System.out.println();
		for(int i=0; i<heights2.length; i++) System.out.print(sol.solution(heights2)[i]+" ");
	}
}
class Solution7{
	public int[] solution(int[] heights) {
		int[] answer = new int[heights.length];
		for(int i=heights.length-1; i>0; i--) {
			for(int j=i-1; j>=0; j--) {
				if(heights[i]<heights[j]) {
					answer[i]=j+1;
					break;
				}
			}
		}
		return answer;
	}
}
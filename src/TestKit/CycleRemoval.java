package TestKit;

public class CycleRemoval {
	public static void main(String[] args) {
		Solution44 sol = new Solution44();
		int n = 4; int[][] edges = {{1, 2}, {1, 3}, {2, 3}, {2, 4}, {3, 4}};
		int n1 = 8; int[][] edges1 = {{1, 2}, {2, 3}, {3, 4}, {4, 5}, {5, 6}, {6, 7}, {7, 8}, {8, 1}, {2, 7}, {3, 6}};
		System.out.println(sol.solution(n, edges));
		System.out.println(sol.solution(n1, edges1));
	}
}
class Solution44{
	public int solution(int n, int[][] edges) {
		int answer=0;
		
		return answer;
	}
}
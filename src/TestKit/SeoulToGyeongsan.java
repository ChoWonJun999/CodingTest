package TestKit;

public class SeoulToGyeongsan {
	public static void main(String[] args) {
		Solution34 sol = new Solution34();
		int K = 1650; int[][] travel = {{500, 200, 200, 100}, {800, 370, 300, 120}, {700, 250, 300, 90}}; //1, 2 ���� //3 ������ //1600/660
		int K1 = 3000; int[][] travel1 = {{1000, 2000, 300, 700}, {1100, 1900, 400, 900}, {900, 1800, 400, 700}, {1200, 2300, 500, 1200}}; //1, 4 ���� //2, 3 ������ //3000/5900
		System.out.println(sol.solution(K, travel));
		System.out.println(sol.solution(K1, travel1));
	}
}
class Solution34{
	int[][] dp;
	public int solution(int K, int[][] travel) { //�� ���� �����Ұ� ���Ƽ� ���� �Ⱦ�...
		dp = new int[travel.length+1][K+1];
		return solve(travel, 0, 0, K);
	}
	int solve(int[][] travel, int n, int time, int K) {
		if(n==travel.length) return 0;
		if(dp[n][time]!=0) return dp[n][time];
		if(time+travel[n][0]<=K) dp[n][time] = solve(travel, n+1, time+travel[n][0], K)+travel[n][1];
		if(time+travel[n][2]<=K) dp[n][time] = Math.max(dp[n][time], solve(travel, n+1, time+travel[n][2], K)+travel[n][3]);
		return dp[n][time];
	}
}
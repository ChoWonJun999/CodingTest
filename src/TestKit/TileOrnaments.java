package TestKit;

public class TileOrnaments {
	public static void main(String[] args) {
		Solution29 sol = new Solution29();
		int N = 5;
		int N1 = 6;
		System.out.println(sol.solution(N));
		System.out.println(sol.solution(N1));
	}
}
class Solution29{
	public long solution(int N) {
		long[] fibonacci = new long[80];
		fibonacci[0] = 4;
		fibonacci[1] = 6;
		for(int i=2; i<N; i++) fibonacci[i]=fibonacci[i-2]+fibonacci[i-1];
		return fibonacci[N-1];
	}
}
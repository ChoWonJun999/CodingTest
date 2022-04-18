package TestKit;

import java.util.Arrays;
public class SteppingStones {
	public static void main(String[] args) {
		Solution41 sol = new Solution41();
		int distance = 25; int[] rocks = {2, 14, 11, 21, 17}; int n = 2;
		System.out.println(sol.solution(distance, rocks, n));
	}
}
class Solution41{
	public int solution(int distance, int[] rocks, int n) {
		Arrays.sort(rocks);
		int[] dis = new int[rocks.length+1];
		for(int i=0; i<dis.length; i++) {
			if(i==0) dis[i] = rocks[i];
			else if(i==dis.length-1) dis[i] = distance-rocks[i-1];
			else dis[i] = rocks[i]-rocks[i-1];
		}
		int start = 0, end = distance;
		while(start<=end) {
			int mid = (start+end)/2;
			int k=0, sum = 0;
			for(int i=0; i<dis.length; i++) {
				if(sum<=mid) {
					if(sum!=0) k++;
					sum+=dis[i];
				}
				if(sum>=mid){sum=0;}
			}
			if(n<k) end = mid-1;
			else start = mid+1;
		}
		return end;
	}
}
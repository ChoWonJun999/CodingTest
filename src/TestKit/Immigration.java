package TestKit;

//1
import java.util.Arrays;
public class Immigration {
	public static void main(String[] args) {
		Solution40 sol = new Solution40();
		int n = 6; int[] times = {7,10};
		System.out.println(sol.solution(n, times));
	}
}
class Solution40{
	//2
	public long solution(int n, int[] times) {
		long answer = 0;
		int max = 0;
		for(int i=0; i<times.length; i++) if(max<times[i]) max = times[i];
		long start = 1, end = (long)max*n;
		while(start<end) {
			System.out.print("start = "+start+", end = "+end);
			long mid = (start+end)/2;
			System.out.println(" mid = "+mid);
			long t = 0;
			for(int i=0; i<times.length; i++) {
				t+=mid/times[i];
				System.out.println("t = "+t+", mid/times["+i+"] = "+mid/times[i]);
			}
			
			if(t>=n) end = mid;
			else start = mid+1;
		}
		answer = end;
		return answer;
	}
	/*
	// 1
	public long solution(int n, int[] times) {
		Arrays.sort(times);
		return (long)find((long)n, times, (long)times.length, times[0],(long)((long)times[0] * (long)n));
	}
	public long find(long n, int[] times, long nExamination, long from, long to) {
		long minTime;
		long tmp = n;
		if(from==to) return from;
		else {
			minTime=(from+to)/2; // + ((from+to)%2==1?1:0;)
			for(int i=0; i<nExamination; i++) tmp-=minTime/(long)times[i];
			if(tmp>0) return find(n, times, nExamination, minTime+1, to);
			else return find(n, times, nExamination, from, minTime);
		}
	}
	*/
}
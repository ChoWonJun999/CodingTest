import java.util.Arrays;
class Solution {
    public long solution(int n, int[] times) {
		Arrays.sort(times);
		return (long)find((long)n, times, (long)times.length, times[0],(long)((long)times[0] * (long)n));
	}
	public long find(long n, int[] times, long nExamination, long from, long to) {
		long minTime;
		long tmp = n;
		if(from==to) return from;
		else {
			minTime=(from+to)/2;
			for(int i=0; i<nExamination; i++) tmp-=minTime/(long)times[i];
			if(tmp>0) return find(n, times, nExamination, minTime+1, to);
			else return find(n, times, nExamination, from, minTime);
		}
	}
}
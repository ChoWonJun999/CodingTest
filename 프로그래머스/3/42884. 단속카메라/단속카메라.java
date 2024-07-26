import java.util.PriorityQueue;
class Solution {
    public int solution(int[][] routes) {
        PriorityQueue<int[]> prque = new PriorityQueue<>((a,b)->a[0]-b[0]);
		for(int[] i : routes) prque.add(i);
		int[] initial = {-30000,30000};
		int count=1;
		while(!prque.isEmpty()) {
			int[] poll = prque.poll();
			if(initial[0]<=poll[0] && initial[1]>=poll[1]) {
				initial = poll;
			}else if(initial[0]<=poll[0] && initial[1]<poll[1] && initial[1]>=poll[0]) {
				initial[0] = poll[0];
			}else if(initial[0]>poll[0] && initial[1]>=poll[1] && initial[0]<=poll[1]) {
				initial[1] = poll[1];
			}else if(initial[0]>poll[0] && initial[1]<poll[1]) {
			}else {
				count++;
                prque.add(poll);
				initial[0] = -30000;
				initial[1] = 30000;
			}
		}
		return count;
    }
}
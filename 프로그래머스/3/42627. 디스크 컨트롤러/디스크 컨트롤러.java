import java.util.Iterator;
import java.util.PriorityQueue;
class Solution {
    public int solution(int[][] jobs) {
        PriorityQueue<int[]> pr = new PriorityQueue<>((a,b) -> a[0]-b[0]);
		PriorityQueue<int[]> pr2 = new PriorityQueue<>((a,b) -> a[1]-b[1]);
		for(int[] i: jobs)  pr.add(i); 
        
		int le=pr.peek()[0];
		int count=0;
        
		while(!pr.isEmpty()) {
			int k[] = pr.poll();
            
			if(k[0]<=le) {
				pr.add(k);
				Iterator<int[]> it = pr.iterator();
				while(it.hasNext()) {
					int l[] = it.next();
					if(l[0]<=le) pr2.add(l);
				}
				int a[] = pr2.poll();
				pr.remove(a);
				k=a;
				pr2.clear();
			}
            
			if((le-k[0])>0) {
				count+=(le-k[0]+k[1]);
				le+=k[1];
			}else {
				count+=k[1];
				le = (k[1]+k[0]);
			}
		}
		return (count/jobs.length);
    }
}
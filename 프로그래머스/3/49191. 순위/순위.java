import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;
class Solution {
    public int solution(int n, int[][] results) {
        int answer=0;
		Set<Integer>[] vic = new Set[n];
		Set<Integer>[] def = new Set[n];
		Set<Integer>[] Qma = new Set[n];
		int[] VP = new int[n];
		for(int i=0; i<n; i++) {
			vic[i] = new HashSet<>();
			def[i] = new HashSet<>();
			Qma[i] = new HashSet<>();
			for(int j=0; j<results.length; j++) {
				if(i==(results[j][0]-1)) vic[i].add(results[j][1]-1);
				if(i==(results[j][1]-1)) def[i].add(results[j][0]-1);
			}
		}
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				Iterator<Integer> Vit = vic[i].iterator();
				Iterator<Integer> Dit = def[i].iterator();
				Set<Integer> tmpSet1 = new HashSet<>();
				Set<Integer> tmpSet2 = new HashSet<>();
				while(Vit.hasNext()) {
					int tmp = Vit.next();
					tmpSet1.addAll(vic[tmp]);
				}
				vic[i].addAll(tmpSet1);
				while(Dit.hasNext()) {
					int tmp = Dit.next();
					tmpSet2.addAll(def[tmp]);
				}
				def[i].addAll(tmpSet2);
			}
			Qma[i].addAll(vic[i]);
			Qma[i].addAll(def[i]);
			
			VP[i] = vic[i].size()+(n-1-Qma[i].size())*100;
		}
		for(int i=0; i<n; i++) if(VP[i]<100) answer++;
		return answer;
    }
}
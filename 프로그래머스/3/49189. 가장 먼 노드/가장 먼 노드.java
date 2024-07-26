import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;
class Solution {
	public int solution(int n, int[][] edge) {
		HashMap<Integer, Set<Integer>> ha = new HashMap<>();
		Set<Integer> s = new HashSet<>();
		s.add(1);
		ha.put(0, s);
		Set<Integer> numberSet = new HashSet<>();
		for(int i=2; i<n+1; i++) numberSet.add(i);
		
		for(int i=1; i<n; i++) {
			Set<Integer> set = new HashSet<>();
			Iterator<Integer> it = ha.get(i-1).iterator();
			while(it.hasNext()) {
				int tmp = it.next();
				for(int j=0; j<edge.length; j++) {
					if(tmp==edge[j][0]) {
						if(numberSet.contains(edge[j][1])) {
							set.add(edge[j][1]);
							numberSet.remove(edge[j][1]);
						}
					}else if(tmp==edge[j][1]) {
						if(numberSet.contains(edge[j][0])) {
							set.add(edge[j][0]);
							numberSet.remove(edge[j][0]);
						}
					}
				}
			}
			if(set.isEmpty()) break;
			ha.put(i, set);
		}
		return ha.get(ha.size()-1).size();
	}
}
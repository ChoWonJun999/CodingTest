import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;
class Solution {
    HashMap<Integer, Set<Integer>> map;
	public int solution(int n, int[][] computers) {
		map = new HashMap<>();
		
		for(int i=0; i<n; i++) {
			Set<Integer> set = new HashSet<>();
			for(int j=0; j<n; j++) {
				if(computers[i][j]==1) {
					set.add(j);
				}
			}
			map.put(i, set);
		}
		
		Set<Set<Integer>> bigSet = new HashSet<>();
		for(int i=0; i<n; i++) bigSet.add(SubSet(map.get(i), i));
		
		return bigSet.size();
	}
	Set<Integer> SubSet(Set<Integer> set, int x) {
		Set<Integer> tempSet = new HashSet<>();
		tempSet.addAll(set);
		
		Iterator<Integer> it = map.get(x).iterator();
		while(it.hasNext()) {
			int value = it.next();
			if(set.contains(value)) {
				if(!set.containsAll(map.get(value))) {
					tempSet.addAll(map.get(value));
					tempSet = SubSet(tempSet, value);
				}
			}
		}
		return tempSet;
	}
}
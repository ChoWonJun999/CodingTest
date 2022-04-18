package TestKit;

import java.util.*;

public class Ex_Programmers {
	public static void main(String[] args){
		Sol sol = new Sol();
		int n = 6; int[][] vertex = {{3, 6}, {4, 3}, {3,2}, {1, 3}, {1, 2}, {2, 4}, {5,2}};
		//int n = 8; int[][] vertex = {{1, 2}, {2, 3}, {3, 4}, {1, 5}, {5, 6}, {4, 5}};
		System.out.println(sol.solution(n, vertex));
	}
}
class Sol{
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
					System.out.println(edge[j][0]+" "+edge[j][1]);
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
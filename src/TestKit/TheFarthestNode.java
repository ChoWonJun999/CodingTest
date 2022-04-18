package TestKit;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.Iterator;
/*
import java.util.ArrayList;
*/
public class TheFarthestNode {
	public static void main(String[] args) {
		Solution42 sol = new Solution42();
		int n = 6; int[][] vertex = {{3, 6}, {4, 3}, {3,2}, {1, 3}, {1, 2}, {2, 4}, {5,2}};
		System.out.println(sol.solution(n, vertex));
	}
}
class Solution42{
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
		/*
		int answer=0;
		ArrayList<Integer>[] path = new ArrayList[n];
		ArrayList<Integer> bfs = new ArrayList<>();
		int[] dist = new int[n];
		dist[0] = 1;
		int max = 0;
		
		for(int i=0; i<edge.length; i++) {
			int num1 = edge[i][0]-1;
			int num2 = edge[i][1]-1;
			if(path[num1]==null) path[num1] = new ArrayList<>();
			if(path[num2]==null) path[num2] = new ArrayList<>();
			path[num1].add(num2);
			path[num2].add(num1);
		}
		bfs.add(0);
		while(!bfs.isEmpty()) {
			int idx = bfs.get(0);
			bfs.remove(0);
			while(!path[idx].isEmpty()) {
				int num = path[idx].get(0);
				path[idx].remove(0);
				bfs.add(num);
				if(dist[num]==0) {
					dist[num] = dist[idx]+1;
					max = dist[num];
				}
			}
		}
		for(int i=0; i<n; i++) if(dist[i]==max) answer++;
		return answer;
		*/
	}
}
import java.util.*;
class Solution {
    public int solution(int n, int[][] lighthouse) {
        Map<Integer, Set<Integer>> c = new HashMap<>();
		for (int[] l : lighthouse) {
			c.computeIfAbsent(l[0], x -> new HashSet<>()).add(l[1]);
			c.computeIfAbsent(l[1], x -> new HashSet<>()).add(l[0]);
		}
		int[] solve = solve(c, 1, 0);
		int answer = Math.min(solve[0], solve[1]);
		return answer;
    }
    private int[] solve(Map<Integer, Set<Integer>> c, int node, int ignore) {
		int no = 0;
		int yes = 1;
		for (int adj : c.get(node)) {
			if (adj != ignore) {
				int[] s = solve(c, adj, node);
				no += s[1];
				yes += Math.min(s[0], s[1]);
			}
		}
		return new int[] { no, yes };
	}
}
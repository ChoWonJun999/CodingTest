package TestKit;

import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;
public class Ranking {
	public static void main(String[] args) {
		Solution43 sol = new Solution43();
		int n = 5; int[][] results = {{4, 3}, {4, 2}, {3, 2}, {1, 2}, {2, 5}};
		//int n1 = 4; int[][] results1 = {{2, 1}, {3, 1}, {3, 4}};
		System.out.println(sol.solution(n, results));
	}
}
class Solution43{
	public int solution(int n, int[][] results) {
		int answer=0;
		boolean[][] chk = new boolean[n+1][n+1];
		
		for(int i=0; i<results.length; i++) chk[results[i][0]][results[i][1]] = true;
		for(int i=0; i<chk.length; i++) {
			for(int j=0; j<chk.length; j++) {
				System.out.print(chk[i][j]+" ");
			}
			System.out.println();
		}
		
		for(int i=1; i<n+1; i++) {
			for(int j=1; j<n+1; j++) {
				for(int k=1; k<n+1; k++) {
					if(j!=k && chk[j][i] && chk[i][k]) chk[j][k] = true;
				}
			}
		}
		for(int i=1; i<n+1; i++) {
			boolean pass = true;
			for(int j=1; j<n+1; j++) {
				if(i!=j && !(chk[i][j] || chk[j][i])) {
					pass = false;
					break;
				}
			}
			if(pass) answer++;
		}
		return answer;
		
		/*
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
		for(int i=0; i<n; i++) {
			if(VP[i]<100) answer++;
//			System.out.println("vic["+i+"] = "+vic[i]);
//			System.out.println("def["+i+"] = "+def[i]);
//			System.out.println("Qma["+i+"] = "+Qma[i]);
//			System.out.println("VP["+i+"] = "+VP[i]);
//			System.out.println();
		}
		return answer;
		*/
	}
}
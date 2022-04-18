package TestKit;

import java.util.Vector;

public class GymSuit {
	public static void main(String[] args) {
		Solution21 sol = new Solution21();
		int n = 5; int[] lost = {2, 4}, reserve = {1, 3, 5};
		int n1 = 5; int[] lost1 = {2,4,5}, reserve1 = {1,3,4};
		int n2 = 3; int[] lost2 = {1,3}, reserve2 = {1};
		System.out.println(sol.solution(n, lost, reserve));
		System.out.println(sol.solution(n1, lost1, reserve1));
		System.out.println(sol.solution(n2, lost2, reserve2));
	}
}
class Solution21{
	public int solution(int n, int[] lost, int[] reserve) {
		Vector<Integer> v = new Vector<>();
		Vector<Integer> re = new Vector<>();
		for(int i=1; i<=n; i++) v.add(i);
		for(int i: lost) v.removeElement(i);
		System.out.println("���� X => "+v);
		for(int i: reserve) re.add(i);
		for(int i=0; i<lost.length; i++) {
			for(int j=0; j<reserve.length; j++) {
				if(lost[i]==reserve[j]) {
					v.add(lost[i]);
					re.removeElement(lost[i]);
				}
			}
		}
		for(int i: re) {
			if(!v.contains(i)) v.add(i);
			else {
				if(i!=1 && !v.contains(i-1)) v.add(i-1);
				else if(i!=n && !v.contains(i+1)) v.add(i+1);
			}
		}
		
		System.out.println(v);
		return v.size();
	}
}
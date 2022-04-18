package TestKit;

import java.util.Vector;
public class ConnectIsland {
	public static void main(String[] args) {
		Solution25 sol = new Solution25();
		int n = 4;	//���� ����
		int[][] costs = {{0, 1, 1}, {1, 2, 5}, {0, 2, 2}, {1, 3, 1}, {2, 3, 8}};	// {x, y, z} x <=> y �� ��� = z
		System.out.println(sol.solution(n, costs));
	}
}
class Solution25{
	public int solution(int n, int[][] costs) {
		int answer=0;
		Vector<Integer> v = new Vector<>();
		Vector<int[]> vcost = new Vector<>();
		for(int[] i: costs) vcost.add(i);
		v.add(0);
		while(!vcost.isEmpty()) {
			int min = 1000000;
			int k=0;
			for(int i=0; i<vcost.size(); i++) {
				if((v.contains(vcost.get(i)[0]) && !v.contains(vcost.get(i)[1])) || (!v.contains(vcost.get(i)[0]) && v.contains(vcost.get(i)[1]))) {
					if(min>vcost.get(i)[2]) {
						min=vcost.get(i)[2];
						k=i;
					}
				}
			}
			if(v.contains(vcost.get(k)[0]) && !v.contains(vcost.get(k)[1])) {
				v.add(vcost.get(k)[1]);
			}else if(!v.contains(vcost.get(k)[0]) && v.contains(vcost.get(k)[1])){
				v.add(vcost.get(k)[0]);
			}
			answer+=vcost.get(k)[2];
			if(v.size()>=n) break;
			vcost.remove(k);
		}
		
		return answer;
	}
}
import java.util.Vector;
class Solution {
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
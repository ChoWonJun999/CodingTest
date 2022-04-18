package TestKit;

import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;

public class NumbersBaseball {
	public static void main(String[] args) {
		Solution19 sol = new Solution19();
		int[][] baseball = {{123, 1, 1}, {356, 1, 0}, {327, 2, 0}, {489, 0, 1}};
		System.out.println(sol.solution(baseball));
	}
}
class Solution19{
	public int solution(int[][] baseball) {
		Set<Integer> set = new HashSet<>();
		for(int x=1; x<10; x++) {
			for(int y=1; y<10; y++) {
				if(x!=y) {
					for(int z=1; z<10; z++) {
						if(x!=z && y!=z) {
							set.add(x*100+y*10+z);
						}
					}
				}
			}
		}
		for(int baseloop=0; baseloop<baseball.length; baseloop++) {
			Iterator<Integer> it = set.iterator();
			Set<Integer> newSet = new HashSet<>();
			while(it.hasNext()) {
				int sus = it.next(), obj = baseball[baseloop][0];
				int[] arrSus = {sus/100,sus%100/10,sus%10};
				int[] arrObj = {obj/100,obj%100/10,obj%10};
				int strike=0, ball=0;
				for(int i=0; i<3; i++) {
					for(int j=0; j<3; j++) {
						if(arrSus[i]==arrObj[j]) {
							if(i==j) strike++;
							else ball++;
						}
					}
				}
				if(baseball[baseloop][1]==strike && baseball[baseloop][2]==ball) {newSet.add(sus);}
			}
			set=newSet;
		}
		return set.size();
	}
}
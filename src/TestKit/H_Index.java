package TestKit;

public class H_Index {
	public static void main(String[] args) {
		Solution2 sol = new Solution2();
		int[] citations = {3, 0, 6, 1, 5};
		System.out.print(sol.solution(citations));
	}
}
class Solution2{
	public int solution(int[] citations) {
		int answer = 0;
		int count;
		boolean ch = false;
		for(int i=citations.length; i>0; i--) {
			count=0;
			for(int j=0; j<citations.length; j++) {
				if(citations[j]>=i) {
					count++;
					if(count>=i) {
						answer = i;
						ch = true;
					}
				}
			}
			if(ch) break;
		}
		return answer;
	}
}
/*
import java.util.*;

class Solution {
   	public int solution(int[] citations) {
       	Arrays.sort(citations);
       	int max = 0;
       	for(int i = citations.length-1; i > -1; i--){
           	int min = (int)Math.min(citations[i], citations.length - i);
           	if(max < min) max = min;
       	}		
       	return max;
    }
}
*/

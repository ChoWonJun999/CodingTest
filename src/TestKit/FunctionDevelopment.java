package TestKit;

import java.util.Vector;

public class FunctionDevelopment {
	public static void main(String[] args) {
		Solution10 sol = new Solution10();
		int[] progresses= {93, 30, 55,99};
		int[] speeds = {1, 30, 5,1};
		System.out.println(sol.solution(progresses,speeds));
	}
}
class Solution10{
	public int[] solution(int[] progresses, int[] speeds) {
		Vector<Integer> v = new Vector<>();
		Vector<Integer> days = new Vector<>();
		for(int i=0; i<progresses.length; i++) days.add(day(progresses[i], speeds[i]));
		while(!days.isEmpty()) {
			int k = days.get(0);
			days.remove(0);
			int count=1;
			for(int i=0; i<days.size(); i++) {
				if(k>=days.get(i)) {
					days.remove(i);
					i--;
					count++;
				}else break;
			}
			v.add(count);
		}
		int[] answer = new int[v.size()];
		for(int i=0; i<v.size(); i++) {
			answer[i] = v.get(i);
		}
		return answer;
	}
	int day(int progres, int speeds){
		int day=0;
		while(progres<=100) {
			progres+=speeds;
			day++;
		}
		return day-1;
	}
}
package TestKit;

import java.util.PriorityQueue;

public class DoublePriorityQueue {
	public static void main(String[] args) {
		Solution16 sol = new Solution16();
		String[] operations = {"I 16","D 1"};
		String[] operations1 = {"I 7","I 5","I -5","D -1"};
		System.out.println(sol.solution(operations)[0]+","+sol.solution(operations)[1]);
		System.out.println(sol.solution(operations1)[0]+","+sol.solution(operations1)[1]);
	}
}
class Solution16{
	public int[] solution(String[] operations) {
		PriorityQueue<Integer> prMin = new PriorityQueue<>((a,b) -> a-b);
		PriorityQueue<Integer> prMax = new PriorityQueue<>((a,b) -> b-a);
		for(String i: operations) {
			char I_D = i.charAt(0);
			String number = i.substring(2);
			switch(I_D) {
				case 'I':
					prMin.add(Integer.parseInt(number));
					prMax.add(Integer.parseInt(number));
					break;
				case 'D':
					if(!prMin.isEmpty()&&!prMax.isEmpty())
					if(number.charAt(0)=='-') {
						int min = prMin.poll();
						prMax.remove(min);
					}else {
						int Max = prMax.poll();
						prMin.remove(Max);
					}
			}
		}
		int Max=0,Min=0;
		if(!prMin.isEmpty()) Min = prMin.poll();
		if(!prMax.isEmpty()) Max = prMax.poll();
		int[] answer = {Max, Min};
		return answer;
	}
}

package TestKit;

import java.util.*;

public class TravelRoute {
	public static void main(String[] args) {
		Solution38 sol = new Solution38();
		String[][] tickets = {{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}};
		String[][] tickets1 = {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL", "SFO"}};
		String[] answer = sol.solution(tickets);
		for(int i=0; i<answer.length; i++) System.out.print(answer[i]+" ");
		System.out.println();
		String[] answer1 = sol.solution(tickets1);
		for(int i=0; i<answer1.length; i++) System.out.print(answer1[i]+" ");
	}
}
class Solution38{
	List<Stack<String>> result;
	String[][] tickets;
	public String[] solution(String[][] tickets) {
		result = new ArrayList<>();
		this.tickets = tickets;
		
		boolean[] visited = new boolean[tickets.length];	//�湮 üũ
        Stack<String> st = new Stack<>();
        st.push("ICN");
		
		dfs(visited, st, 0);	//�ݺ�
		if(result.size()>1) {		//���ؼ� ���ĺ� ������  ���� ������ ��η� ��ġ
			Collections.sort(result, new Comparator<Stack<String>>() {
				@Override
				public int compare(Stack<String> o1, Stack<String> o2) {
					for(int i=0; i<o1.size(); i++) {
						String s1 = o1.get(i);
						String s2 = o2.get(i);
						
						if(!s1.equals(s2)) {
							return s1.compareTo(s2);
						}
					}
					return 0;
				}
			});
		}
		Stack<String> res = result.remove(0);
		String[] answer = new String[res.size()];
		
		for(int i=0; i<answer.length; i++) {
			answer[i] = res.get(i);
		}
		return answer;
	}
	public void dfs(boolean[] visited, Stack<String> st, int len) {//�湮 ���/���/����
		if(len==tickets.length) {				//�����϶�
			Stack<String> res = new Stack<>();
			for(String s:st) {
				res.push(s);
			}
			result.add(res);
			return;	//�ݺ� ����
		}
		
		String arrive = st.peek();	//stack�� ���� �տ� �ִ� ����
		
		for(int i=0; i<tickets.length; i++) {
			String[] tic = tickets[i];
			if(!visited[i] && arrive.equals(tic[0])) {	//�湮���� �ʰ� ���� �տ� �ִ� ���ڿ� ���� ��
				st.push(tic[1]);	//push
				visited[i] = true;	//�湮
				
				dfs(visited, st, len+1);
				
				visited[i] = false; //�湮 ����
				st.pop();			//pop
			}
		}
	}
}
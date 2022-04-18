package TestKit;

import java.util.HashMap;

public class OpenChat {
	public static void main(String[] args) {
		SolutionKakao sol = new SolutionKakao();
		String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234", "Enter uid1234 Prodo", "Change uid4567 Ryan"};
		for(int i=0; i<sol.solution(record).length; i++) System.out.println("\""+sol.solution(record)[i]+"\"");
	}
}
class SolutionKakao{
	public String[] solution(String[] record) {
		HashMap<String, String> ha = new HashMap<>();
		String[][] str = new String[record.length][3];
		for(int i=0; i<record.length; i++) {
			if(record[i].charAt(0)=='L') record[i]+=" L";
			str[i]=record[i].split(" ");
		}
		int count=0;
		for(int i=0; i<str.length; i++) {
			switch(str[i][0]) {
				case "Enter" : 
					ha.put(str[i][1], str[i][2]);
					count++;
					break;
				case "Leave" : 
					ha.remove(str[i][1]);
					count++;
					break;
				case "Change" : 
					ha.put(str[i][1], str[i][2]);
					break;
			}
		}
		String[] answer = new String[count];
		int j=0;
		for(int i=0; i<str.length; i++) {
			switch(str[i][0]) {
				case "Enter" : 
					answer[j]=ha.get(str[i][1])+"���� ���Խ��ϴ�.";
					j++;
					break;
				case "Leave" : 
					answer[j]=ha.get(str[i][1])+"���� �������ϴ�.";
					j++;
					break;
				case "Change" : 
					break;
			}
		}
		return answer;
	}
}
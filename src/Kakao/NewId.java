package Kakao;

import java.util.Deque;
import java.util.LinkedList;

public class NewId {
	public static void main(String[] args) {
		String new_id = "...!@BaT#*..y.abcdefghijklm";
		System.out.println(solution(new_id));	// "bat.y.abcdefghi"
		new_id = "z-+.^.";
		System.out.println(solution(new_id));	// "z--"
		new_id = "=.=";
		System.out.println(solution(new_id));	// "aaa"
		new_id = "123_.def";
		System.out.println(solution(new_id));	// "123_.def"
		new_id = "abcdefghijklmn.p";
		System.out.println(solution(new_id));	// "abcdefghijklmn"
	}
	public static String solution(String new_id){
		new_id = new_id.toLowerCase();
		// a~z = 97~122
		// 0~9 = 48~57
		// - _ . = 45 95 46
		Deque<Character> deque = new LinkedList<>();
		for(int i=0; i<new_id.length(); i++){
			int chk = new_id.charAt(i);
			if((chk >= 97 && chk <=122) || (chk >= 48 && chk<=57) || chk==45 || chk==95){
				deque.add(new_id.charAt(i));
			}else if(chk == 46){
				if(deque.size()>0){
					if((int)deque.peekLast() != 46){
						deque.add(new_id.charAt(i));
					}
				}
			}
		}
		if(deque.size()==0){
			deque.add('a');
		}
		
		String answer = "";
		while(!deque.isEmpty()){
			answer += deque.poll();
		}
		if((int)answer.charAt(answer.length()-1) == 46){
			answer = answer.substring(0, answer.length()-1);
		}
		if(answer.length() > 15){
			answer = answer.substring(0, 15);
			if((int)answer.charAt(answer.length()-1) == 46){
				answer = answer.substring(0, answer.length()-1);
			}
		}else if(answer.length() < 3){
			Character temp = answer.charAt(answer.length()-1);
			while(answer.length() < 3){
				answer += temp;
			}
		}
		
		return answer;
	}
	public String OtherSol(String new_id) {
		String answer = "";
		String temp = new_id.toLowerCase();
		
		temp = temp.replaceAll("[^-_.a-z0-9]","");
		temp = temp.replaceAll("[.]{2,}",".");
		temp = temp.replaceAll("^[.]|[.]$","");
		if(temp.equals(""))
			temp += "a";
		if(temp.length() >= 16){
			temp = temp.substring(0,15);
			temp = temp.replaceAll("^[.]|[.]$","");
		}
		if(temp.length() <= 2)
			while(temp.length() < 3)
				temp += temp.charAt(temp.length()-1);
		
		answer=temp;
		return answer;
	}
}
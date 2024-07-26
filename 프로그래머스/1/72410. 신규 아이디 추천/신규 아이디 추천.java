import java.util.Deque;
import java.util.LinkedList;
class Solution {
    public String solution(String new_id) {
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
}
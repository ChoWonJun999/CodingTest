package TestKit;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
public class UncompletedPlayer {
	public static void main(String[] args) {
		Solution3 sol = new Solution3();
		String[] participant = {"leo","kiki", "eden"};
		String[] completion = {"eden","kiki"};
		String[] participant1 = {"marina","josipa", "nikola", "vinko","filipa"};
		String[] completion1 = {"josipa", "filipa","marina","nikola"};
		String[] participant2 = {"mislav","stanko", "mislav","ana"};
		String[] completion2 = {"stanko","ana", "mislav"};
		String[] participant3 = {"mislav","stanko", "mislav","ana"};
		String[] completion3 = {"stanko","mislav", "mislav"};
		System.out.println(sol.solution(participant, completion));	 //leo
		System.out.println(sol.solution(participant1, completion1)); //vinko
		System.out.println(sol.solution(participant2, completion2)); //mislav
		System.out.println(sol.solution(participant3, completion3)); //ana
	}
}
class Solution3{
	public String solution(String[] participant, String[] completion) {
		String answer = "";
		HashMap<String, Integer> ha = new HashMap<String,Integer>();
		for(int i=0; i<participant.length; i++) {
			if(ha.containsKey(participant[i])) ha.put(participant[i], ha.get(participant[i])+1);
			else ha.put(participant[i], 1);
		}
		for(int i=0; i<completion.length; i++) ha.put(completion[i], ha.get(completion[i])-1);
		Set<String> keys = ha.keySet();
		Iterator<String> it = keys.iterator();
		while(it.hasNext()) {
			String key = it.next();
			if(ha.get(key)==1) answer = key;
		}
		return answer;
		/*
		HashMap<String, Integer> ha = new HashMap<String,Integer>();
		for(String player : participant) ha.put(player, ha.getOrDefault(player, 0)+1);
		for(String player : completion) ha.put(player, ha.get(player)-1);
		for(String key : ha.keySet()) {
			if(ha.get(key)!=0) {
				answer = key;
			}
		}
		return answer;
		*/
		/*
		import java.util.Arrays;
		Arrays.sort(participant);
		Arrays.sort(completion);
		String[] co1 = new String[completion.length+1];
		for(int i=0; i<completion.length; i++) co1[i] = completion[i];
		co1[completion.length] = null;
		for(int x=0; x<co1.length; x++) {
			if(!participant[x].equals(co1[x])) {
				String c = co1[x];
				co1[x] = co1[co1.length-1];
				co1[co1.length-1] = c;
			}
		}
		for(int i=0; i<co1.length; i++) {
			if(co1[i] == null) answer = participant[i];
		}
		return answer;
		*/
	}
}
import java.util.HashMap;
import java.util.Set;
import java.util.Iterator;
class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, Integer> ha = new HashMap<String,Integer>();
		for(int i=0; i<participant.length; i++) {
			if(ha.containsKey(participant[i])) ha.put(participant[i], ha.get(participant[i])+1);
			else ha.put(participant[i], 1);
		}
		for(int i=0; i<completion.length; i++) {
			if(ha.containsKey(completion[i])) ha.put(completion[i], ha.get(completion[i])-1);
			else ha.put(completion[i], ha.get(completion[i])-1);
		}
		Set<String> keys = ha.keySet();
		Iterator<String> it = keys.iterator();
		while(it.hasNext()) {
			String key = it.next();
			if(ha.get(key)==1) answer = key;
		}
        return answer;
    }
}
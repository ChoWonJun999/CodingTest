import java.util.HashMap;
import java.util.Set;
import java.util.Iterator;
class Solution {
    HashMap<String, Integer> bf;
	public int solution(String begin, String target, String[] words) {
		bf = new HashMap<>();
		for(int i=0; i<words.length; i++) bf.put(words[i], 50);
		bf.put(begin, 0);
		if(!bf.containsKey(target)) return 0;
		LoopFuntion(0);
		return bf.get(target);
	}
	void LoopFuntion(int x) {
		Set<String> set = bf.keySet();
		Iterator<String> it = set.iterator();
		Iterator<String> it2 = set.iterator();
		while(it.hasNext()) {
			String key = it.next();
			if(bf.get(key)==x) {
				while(it2.hasNext()) {
					String key2 = it2.next();
					if(check(key, key2)) {
						bf.replace(key2, Math.min(bf.get(key2), bf.get(key)+1));
					}
				}
			}
		}
		if(bf.values().contains(x++)) {
			LoopFuntion(x);
		}
	}
	boolean check(String str1, String str2) {
		int ok = 0;
		for(int i=0; i<str1.length(); i++) {
			if(str1.charAt(i) != str2.charAt(i)) ok++;
			if(ok>=2) return false;
		}
		if(ok==0) return false;
		return true;
	}
}
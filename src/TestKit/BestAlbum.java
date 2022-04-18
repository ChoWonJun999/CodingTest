package TestKit;

import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.Vector;

public class BestAlbum {
	public static void main(String[] args) {
		Solution6 sol = new Solution6();
		String[] genres = {"classic","pop","classic","classic","pop"};
		int[] plays = {500, 600, 800, 800, 2500};
		int[] solex = sol.solution(genres, plays);
		for(int i=0; i<solex.length; i++)
		System.out.print(solex[i]+"\t");
	}
}
class Solution6{
	public int[] solution(String[] genres, int[] plays) {
		HashMap<String,Integer> hash = new HashMap<>();
		HashMap<Integer,String> reha = new HashMap<>();
		HashMap<Integer,Integer> pr = new HashMap<>();
		Vector<Integer> v = new Vector<>();
		Vector<Integer> vp = new Vector<>();
		
		for(int i=0; i<genres.length; i++) {
			if(hash.containsKey(genres[i])) hash.put(genres[i], hash.get(genres[i])+plays[i]);
			else hash.put(genres[i], plays[i]);
			if(!pr.containsKey(plays[i])) pr.put(plays[i], i);
		}
		Set<String> keys = hash.keySet();
		Iterator<String> it = keys.iterator();
		while(it.hasNext()) {
			String key = it.next();
			int value = hash.get(key);
			reha.put(value, key);
			v.add(value);
		}
		Collections.sort(v, Collections.reverseOrder());
		Vector<Integer> p = new Vector<>(); 
		for(int i : v) {
			int k=0;
			for(int j=0; j<genres.length; j++) {
				if(reha.get(i).equals(genres[j])) {
					vp.add(plays[j]);
					k++;
				}
			}
			Collections.sort(vp, Collections.reverseOrder());
			if(k==1) {
				p.add(vp.get(0));
			}else {
				p.add(vp.get(0));
				p.add(vp.get(1));
			}
			vp.removeAllElements();
		}
		Vector<Integer> ex = new Vector<>();
		int[] answer = new int[p.size()];
		for(int i=0; i<p.size(); i++) {
			for(int j=0; j<plays.length; j++) {
				if(p.get(i)==plays[j]) {
					if(!ex.contains(j)) ex.add(j);
					else ;
				}
			}
		}
		for(int i=0; i<ex.size(); i++) {
			answer[i] = ex.get(i);
		}
		return answer;
	}
}
package TestKit;

import java.util.HashMap;
import java.util.Iterator;
public class Camouflage {
	public static void main(String[] args) {
		Solution5 sol = new Solution5();
		String[][] clothes = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};
		String[][] clothes1 = {{"crow_mask", "face"}, {"blue_sunglasses", "face"}, {"smoky_makeup", "face"}};
		System.out.println(sol.solution(clothes));
		System.out.println(sol.solution(clothes1));
	}
}
class Solution5{
	public int solution(String[][] clothes) {
		int answer = 1;	//���� �ϱ� ����
		HashMap<String, Integer> ha = new HashMap<>();
		for(int i=0; i<clothes.length; i++) {
			String key = clothes[i][1];
			if(!ha.containsKey(key)) {
				ha.put(key,1);
			}else {
				ha.put(key, ha.get(key)+1);
			}
		}
		Iterator<Integer> it = ha.values().iterator();	//���鸸 
		while(it.hasNext()) {
			answer *= it.next().intValue()+1;	//+1�� �ϴ� ������ ������ ���� ��� ����
		}
		return answer-1;	//-1�� ���� ������ ���� ��� ����
	}
}
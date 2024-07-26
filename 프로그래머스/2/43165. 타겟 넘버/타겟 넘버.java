import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
class Solution {
    public int solution(int[] numbers, int target) {
        int answer=0;
		HashMap<Integer, List<Integer>> map = new HashMap<>();
		List<Integer> l = new ArrayList<>();
		
		l.add(numbers[0]);
		l.add(numbers[0]*(-1));
		map.put(1, l);
		for(int i=2; i<numbers.length+1; i++) {
			List<Integer> list = new ArrayList<>();
			Iterator<Integer> it = map.get(i-1).iterator();
			while(it.hasNext()) {
				int itValue = it.next();
				for(Operator o:Operator.values()) {	
					int calculate = o.calculate(itValue, numbers[i-1]);	
					list.add(calculate);
				}
			}
			map.put(i, list);
		}
		List<Integer> li = map.get(numbers.length);
		for(Integer ii :li) {
			if(ii==target)answer++;
		}
		return answer;
    }
    enum Operator{
		PLUS{
			public int calculate(int i, int j) {return i+j;}
		}, MINUS{
			public int calculate(int i, int j) {return i-j;}
		};
		public abstract int calculate(int i, int j);
	}
}
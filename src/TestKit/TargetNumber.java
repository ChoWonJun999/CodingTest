package TestKit;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
public class TargetNumber {
	public static void main(String[] args) {
		Solution35 sol = new Solution35();
		int[] numbers = {1, 1, 1, 1, 1}; int target = 3;
		System.out.println(sol.solution(numbers, target));
	}
}
class Solution35{
	public int solution(int[] numbers, int target) {
		return dfs(numbers, 0, 0, target);
	}
	int dfs(int[] numbers, int n, int sum, int target) {
		if(n==numbers.length) {
			if(sum==target) return 1;
			return 0;
		}
		return dfs(numbers, n+1, sum+numbers[n], target)+dfs(numbers, n+1, sum-numbers[n], target);
	}
}
/*
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
		PLUS{			//i+j
			public int calculate(int i, int j) {return i+j;}
		}, MINUS{		//i-j
			public int calculate(int i, int j) {return i-j;}
		};
		public abstract int calculate(int i, int j);
	}
}
*/
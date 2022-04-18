package TestKit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
		
public class BestBigNumber{
	public static void main(String[] args) {
		Solution1 sol = new Solution1();
		int numbers[] = {6, 10, 2};
		int numbers1[] = {3, 30, 34, 5, 9};
		System.out.println(sol.solution(numbers));
		System.out.println(sol.solution(numbers1));
	}
}
class Solution1{
	public String solution(int[] numbers) {
		String answer = "";

		List<Integer> list = new ArrayList<>();
		for(int i = 0; i < numbers.length; i++) {
			list.add(numbers[i]);	//list�� numbers �Է�
		}
		Collections.sort(list, (a, b) -> {
			String as = String.valueOf(a), bs = String.valueOf(b);
			return -Integer.compare(Integer.parseInt(as + bs), Integer.parseInt(bs + as));
		});
		
		StringBuilder sb = new StringBuilder();
		
		for(Integer i : list) {
			sb.append(i);
		}
		answer = sb.toString();
		if(answer.charAt(0) == '0') {
			return "0";
		}else {
			return answer;
		}
	}
}
/*
class Solution1{
	static String[] ns;	//numbersString
	public String solution(int[] numbers) {
		String answer = "";
		int k;
		ns = new String[numbers.length];
		for(int i=0; i<numbers.length; i++) ns[i] = Integer.toString(numbers[i]);
		
		for(int i=0; i<ns.length; i++) {
			for(int j=0; j<ns.length-1; j++) {
				k=0;
				function(j,k);
			}
		}
		for(int i=0; i<numbers.length; i++) answer=answer.concat(ns[i]);
		return answer;
	}
	void function(int x, int k) {
		String nx = ns[x];
		String nx1 = ns[x+1];
		if(nx.charAt(k)<nx1.charAt(k)) change(x);
		else if(nx.charAt(k)==nx1.charAt(k)) {
			try {
				function(x,k+1);
			}catch(StringIndexOutOfBoundsException e) {
				if(nx.length()>nx1.length()) {
					if(nx.charAt(k)>nx.charAt(k+1)) change(x);
				}else if(nx.length()==nx1.length()) {
					function(x, k+1);
				}else {
					if(nx1.charAt(k)<nx1.charAt(k+1)) change(x);
				}
			}
		}
	}
	void change(int x) {
		String c = ns[x];
		ns[x] = ns[x+1];
		ns[x+1] = c;
	}
}
*/
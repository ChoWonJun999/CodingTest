package TestKit;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Iterator;

public class ExpressedAsN {
	public static void main(String[] args) {
		Solution28 sol = new Solution28();
		int N = 5; int number = 12;
		int N1 = 2; int number1 = 11;
		System.out.println(sol.solution(N, number));
		System.out.println(sol.solution(N1, number1));
	}
}
class Solution28{
	public int solution(int N, int number) {
		int answer = -1;
		
		HashMap<Integer, HashSet<Integer>> map = new HashMap<>(); //<i,set> set = N�� i�� ����Ͽ� ���� �� �ִ� ���ڵ��� ���� * 1<=i<=8
		HashSet<Integer> s = new HashSet<>();	//�ʱⰪ [N]�� �ֱ����� ����
		
		s.add(N);	//�ʱⰪ [N]
		map.put(1, s);	//�ʱⰪ {1=[N]}
		
		loop : for(int i=2; i<9; i++) {	//loop�� ����ϴ� ����? number�� ���ڰ� ������ ��� �ٷ� �����ϱ� ���� //1�� ��찡 �������⶧���� 2���� �����ϴµ�
			HashSet<Integer> set = new LinkedHashSet<>();	//N�� i�� ����ؼ� ���� �� �ִ� ���ڵ鸸 �ֱ����� �Ź� ����
			
			int NNN = Integer.parseInt(Integer.toBinaryString((int)Math.pow(2,i)-1))*N;	//Math.pow(2,i)-1�� Integer.toBinaryString()�� �̿��Ͽ� �������� ǥ��  => 11,111,1111,...,11111111
			if(NNN==number) return i;	//���� ���Ḧ ����
			set.add(NNN);	//i=2 => set=[NN], i=3 => set=[NNN], i=4 => set=[NNNN], ..., i=8 => set=[NNNNNNNN]
			
			for(int j=1; j<=i/2; j++) {
				Iterator<Integer> it1 = map.get(j).iterator();		//j��° ����
				Iterator<Integer> it2 = map.get(i-j).iterator();	//i-j��° ����
				// i=2 => set(1)&set(1); 1��° ���հ� 1��° ���� ��
				// i=3 => set(1)&set(2);
				// i=4 => set(1)&set(3), set(2)&set(2);
				// i=5 => set(1)&set(4), set(2)&set(3);
				// i=6 => set(1)&set(5), set(2)&set(4), set(3)&set(3);
				// i=7 => set(1)&set(6), set(2)&set(5), set(3)&set(4);
				// i=8 => set(1)&set(7), set(2)&set(6), set(3)&set(5), set(4)&set(4);
				
				while(it1.hasNext()) {	//j��° ����
					int itValue1 = it1.next();
					while(it2.hasNext()) {	//i-j��° ����
						int itValue2 = it2.next();
						for(Operator o:Operator.values()) {	//��
							int calculate = o.calculate(itValue1, itValue2);	//+, -, (BACK)-, *, /, (BACK)/ 6���� ��� ��
							if(calculate == number) {
								answer = i;	
								break loop;	//������ ��� loop(�ݺ���) ����
							}
							set.add(calculate);	//����� �� ��� set�� ����
						}
					}
				}
			}
			map.put(i, set);
		}
		return answer;
	}
	enum Operator{
		PLUS{			//i+j
			public int calculate(int i, int j) {return i+j;}
		}, MINUS{		//i-j
			public int calculate(int i, int j) {return i-j;}
		}, BACKMINUS{	//j-i
			public int calculate(int i, int j) {return j-i;}
		}, MUL{			//i*j
			public int calculate(int i, int j) {return i*j;}
		}, DIV{			//i/j
			public int calculate(int i, int j) {
				if(j==0)return 0;
				return i/j;
			}
		}, BACKDIV{		//j/i
			public int calculate(int i, int j) {
				if(i==0) return 0;
				return j/i;
			}
		};
		public abstract int calculate(int i, int j);
	}
}
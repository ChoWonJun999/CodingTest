package TestKit;

import java.util.Stack;
public class CreateALargeNumber {

	public static void main(String[] args) {
		Solution23 sol = new Solution23();
		String number = "1924"; int k =2;
		String number1 = "1231234"; int k1 =3;
		String number2 = "4177252841"; int k2 =4;
		System.out.println(sol.solution(number, k));
		System.out.println(sol.solution(number1, k1));
		System.out.println(sol.solution(number2, k2));
	}
}
class Solution23{
	public String solution(String number, int k) {
		char[] result = new char[number.length()-k]; //��ü����-���ŵǴ±��� => ��������
		Stack<Character> stack = new Stack<>();
		
		for(int i=0; i<number.length(); i++) {
			char c = number.charAt(i);	//i(ù��°���� ����������)��° ����
			while(!stack.isEmpty() && stack.peek()<c && k-->0) {//stack�� ������� ������(ù���� �ֱ� ���� ����), stack�� ù����(i-1��° ����)�� c���� ������(���Ͽ� ���� ���ڸ� ���� �ϱ� ���� ����), k-1�� 0���� ũ�ٸ�(k���� ���� �ϱ� ���� ����)
				stack.pop();	//stack�� ���� ��ġ�Ǿ��ִ� ���� ����
			}
			stack.push(c);
		}
		for(int i=0; i<result.length; i++) {	//result.length���� �� ������ stack���� ������ ���ڰ� �������ν� ���̰� �������̺��� ��������� �������� �̻��� ���ڵ��� ���� �ϱ� ����
			result[i] = stack.get(i);
		}
		return new String(result);
	}
}
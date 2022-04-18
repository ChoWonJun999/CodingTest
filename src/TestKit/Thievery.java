package TestKit;

public class Thievery {
	public static void main(String[] args) {
		Solution33 sol = new Solution33();
		int[] money = {1, 2, 3, 4};
		System.out.println(sol.solution(money));
	}
}
class Solution33{
	public int solution(int[] money) {
		int[][] pick = new int[2][money.length];
		pick[0][0] = money[0]; //ù��° ���� ����
		pick[0][1] = money[0];
		pick[1][0] = 0;		   //�ι�° ���� ����
		pick[1][1] = money[1];
		
		for(int i=2; i<money.length; i++) {	//���ذ� �ɵ� ���� �𸣰���
			pick[0][i] = Math.max(pick[0][i-2]+money[i], pick[0][i-1]);
			pick[1][i] = Math.max(pick[1][i-2]+money[i], pick[1][i-1]);
		}
		for(int j=0; j<money.length; j++) {
			for(int i=0; i<2; i++) {
				System.out.print(pick[i][j]+" ");
			}
			System.out.println();
		}
		return Math.max(pick[0][pick[0].length-2], pick[1][pick[1].length-1]);
	}
}
package TestKit;

public class Carpet {
	public static void main(String[] args) {
		Solution20 sol = new Solution20();
		int brown = 10, red = 2;
		int brown1 = 8, red1 = 1;
		int brown2 = 24, red2 = 24;
		for(int i=0; i<sol.solution(brown, red).length; i++) System.out.print(sol.solution(brown, red)[i]+" ");
		System.out.println();
		for(int i=0; i<sol.solution(brown1, red1).length; i++)System.out.print(sol.solution(brown1, red1)[i]+" ");
		System.out.println();
		for(int i=0; i<sol.solution(brown2, red2).length; i++)System.out.print(sol.solution(brown2, red2)[i]+" ");
	}
}
class Solution20{
	public int[] solution(int brown, int red) {
		int sum = brown+red;
		int width=0; int height=0;
		for(int i=3; i<=(int)Math.sqrt(sum); i++) {
			if(sum%i==0) {
				int j=sum/i;
				if(brown==i*2+(j-2)*2) {
					width=j; height=i;
				}
			}
		}
		int[] answer= {width,height};
		return answer;
	}
}
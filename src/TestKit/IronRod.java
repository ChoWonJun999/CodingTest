package TestKit;

public class IronRod {
	public static void main(String[] args) {
		Solution11 sol = new Solution11();
		String arrangement = "()(((()())(())()))(())";
		System.out.println(sol.solution(arrangement));
	}
}
class Solution11{
	public int solution(String arrangement) {
		int answer = 0;
		String laser = arrangement.replace("()", "*");
		char[] arr = new char[laser.length()];
		for(int i=0; i<arr.length; i++) {
			arr[i] = laser.charAt(i);
		}
		for(int i=0; i<arr.length; i++) {
			int c = 0;
			int s = 0;
			if(arr[i]=='(') {
				for(int j=i; j<arr.length; j++) {
					if(arr[j]=='(') c++;
					else if(arr[j]==')') {
						c--;
						if(c==0) break;
					}if(arr[j]=='*') s++;
				}
				answer+=(s+1);
			}
		}
		return answer;
	}
}
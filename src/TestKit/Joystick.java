package TestKit;

public class Joystick {
	public static void main(String[] args) {
		Solution22 sol = new Solution22();
		String name = "JEROEN";
		String name1 = "AAZAA";
		System.out.println(sol.solution(name));
		System.out.println(sol.solution(name1));
	}
}
class Solution22{
	public int solution(String name) {
		int move=0;
		int[] diff = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,12,11,10,9,8,7,6,5,4,3,2,1};
		for(char c : name.toCharArray()) move+=diff[c-'A']; 
		
		int length = name.length();
		int min = length-1;
		
		for(int i=0; i<length; i++) {
			int next=i+1;
			while(next<length && name.charAt(next)=='A') {
				next++;
			}
			min = Math.min(min, i+length-next+Math.min(i, length-next));
		}
		return move+min;
	}
}
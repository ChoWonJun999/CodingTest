package Kakao;

public class NumberStringsAndEnglishWords {
	public static void main(String[] args) {
		String s = "";
		
		s = "one4seveneight";
		System.out.println(solution(s));	// 1478
		
		s = "23four5six7";
		System.out.println(solution(s));	// 234567
		
		s = "2three45sixseven";
		System.out.println(solution(s));	// 234567
		
		s = "123";
		System.out.println(solution(s));	// 123
	}
	
	public static int solution(String s) {
		s = s.replace("zero", "0");
		s = s.replace("one", "1");
		s = s.replace("two", "2");
		s = s.replace("three", "3");
		s = s.replace("four", "4");
		s = s.replace("five", "5");
		s = s.replace("six", "6");
		s = s.replace("seven", "7");
		s = s.replace("eight", "8");
		s = s.replace("nine", "9");
		
		return Integer.valueOf(s);
	}
}
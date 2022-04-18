package TestKit;

public class PhoneBook {
	public static void main(String[] args) {
		Solution4 sol = new Solution4();
		String[] phone_book = {"119", "97674223", "1195524421"};
		String[] phone_book1 = {"123", "456", "789"};
		String[] phone_book2 = {"12", "123", "1235", "567", "88"};
		System.out.println(sol.solution(phone_book));
		System.out.println(sol.solution(phone_book1));
		System.out.println(sol.solution(phone_book2));
	}
}
class Solution4{
	public boolean solution(String[] phone_book) {
		boolean answer = true;
		int k=20;
		String[] ex = new String[phone_book.length];
		for(int i=0; i<phone_book.length; i++) {
			k = k<phone_book[i].length()? k : phone_book[i].length();
		}
		for(int i=0; i<ex.length; i++) {
			ex[i] = phone_book[i].substring(0, k);
			if(i>0&&ex[i].equals(ex[0])) answer = false;
		}
		return answer;
		/*
		for(int i=0; i<phone_book.length-1; i++) {
            for(int j=i+1; j<phone_book.length; j++) {
                if(phone_book[i].startsWith(phone_book[j])) {return false;}
                if(phone_book[j].startsWith(phone_book[i])) {return false;}
            }
        }
        return true;
        */
	}
}
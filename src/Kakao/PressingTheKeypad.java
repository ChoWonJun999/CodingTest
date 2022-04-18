package Kakao;

import java.util.ArrayList;
import java.util.List;

public class PressingTheKeypad {
	public static void main(String[] args) {
		int[] numbers = {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};
		String hand = "right";
		System.out.println(solution(numbers, hand));	// LRLLLRLLRRL
		
		int[] numbers1 = {7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2};
		String hand1 = "left";
		System.out.println(solution(numbers1, hand1));	// LRLLRRLLLRR
		
		int[] numbers2 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
		String hand2 = "right";
		System.out.println(solution(numbers2, hand2));	// LLRLLRLLRL
		
	}
	public static String solution(int[] numbers, String hand){
		String answer = "";
		List<int[]> priority = new ArrayList<>();
		for(int i=0; i<4; i++){
			for(int j=0; j<3; j++){
				int[] e = {i, j};
				priority.add(e);
			}
		}
		int left = 10;
		int right = 12;
		for(int i=0; i<numbers.length; i++){
			if(left == 0) left = 11;
			if(right == 0) right = 11;
			switch (numbers[i]) {
				case 1 :
				case 4 :
				case 7 :
					left = numbers[i];
					answer+="L";
					break;
				case 3 :
				case 6 :
				case 9 :
					right = numbers[i];
					answer+="R";
					break;
				case 2 :
				case 5 :
				case 8 :
				case 0 :
					if(numbers[i]==0){
						numbers[i] = 11;
					}
					if(getPriority(priority.get(numbers[i]-1), priority.get(left-1)) < getPriority(priority.get(numbers[i]-1), priority.get(right-1))){
						left = numbers[i];
						answer+="L";
					}else if(getPriority(priority.get(numbers[i]-1), priority.get(left-1)) > getPriority(priority.get(numbers[i]-1), priority.get(right-1))){
						right = numbers[i];
						answer+="R";
					}else{
						if(hand.equals("left")){
							left = numbers[i];
							answer+="L";
						}else{
							right = numbers[i];
							answer+="R";
						}
					}
					break;
			}
		}
		return answer;
	}
	public static int getPriority(int[] number, int[] hand){
		return Math.abs(number[0]-hand[0]) + Math.abs(number[1]-hand[1]);
	}
}
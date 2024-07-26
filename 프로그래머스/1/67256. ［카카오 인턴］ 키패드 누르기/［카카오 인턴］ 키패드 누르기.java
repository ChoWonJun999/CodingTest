import java.util.ArrayList;
import java.util.List;
class Solution {
    public String solution(int[] numbers, String hand) {
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
    public int getPriority(int[] number, int[] hand){
		return Math.abs(number[0]-hand[0]) + Math.abs(number[1]-hand[1]);
	}
}
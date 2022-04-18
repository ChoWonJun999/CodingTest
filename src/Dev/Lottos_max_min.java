package Dev;

public class Lottos_max_min {
	public static void main(String[] args) {
		int[] lottos = {44, 1, 0, 0, 31, 25};
		int[] win_nums = {31, 10, 45, 1, 6, 19};
		System.out.println("["+solution(lottos, win_nums)[0]+", "+ solution(lottos, win_nums)[1]+"]");		// [3, 5]
		
		int[] lottos1 = {0, 0, 0, 0, 0, 0};
		int[] win_nums1 = {38, 19, 20, 40, 15, 25};
		System.out.println("["+solution(lottos1, win_nums1)[0]+", "+ solution(lottos1, win_nums1)[1]+"]");		// [1, 6]
		
		int[] lottos2 = {45, 4, 35, 20, 3, 9};
		int[] win_nums2 = {20, 9, 3, 45, 4, 35};
		System.out.println("["+solution(lottos2, win_nums2)[0]+", "+ solution(lottos2, win_nums2)[1]+"]");		// [1, 1]
	}
	public static int[] solution(int[] lottos, int[] win_nums) {
		int[] answer = new int[2];
		int max = 7;
		int min = 7;
		for(int i=0; i<lottos.length; i++){
			if(lottos[i] == 0) max--;
			for(int j=0; j<win_nums.length; j++){
				if(lottos[i] == win_nums[j]){
					max--;
					min--;
				}
			}
		}
		answer[0] = max==7? max-1 : max;
		answer[1] = min==7? min-1 : min;
		return answer;
	}
}
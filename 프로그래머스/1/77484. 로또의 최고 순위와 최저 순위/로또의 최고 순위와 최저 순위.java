class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
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
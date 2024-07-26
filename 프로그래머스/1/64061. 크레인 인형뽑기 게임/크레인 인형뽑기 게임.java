import java.util.HashMap;
import java.util.Stack;
class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
		HashMap<Integer, Stack<Integer>> ha = new HashMap<>();
		
		Stack<Integer> moving = new Stack<>();
		for(int i=moves.length-1; i>=0; i--){
			moving.push(moves[i]);
		}
		Stack<Integer> basket = new Stack<>();
		
		for(int i=0; i<board.length; i++){
			Stack<Integer> stack = new Stack<>();
			for(int j=board.length-1; j>=0; j--){
				if(board[j][i]!=0){
					stack.push(board[j][i]);
				}
			}
			ha.put(i+1, stack);
		}
		while(!moving.isEmpty()) {
			int a = moving.pop();
			if(!ha.get(a).isEmpty()){
				int temp = ha.get(a).pop();
				if(!basket.isEmpty()){
					if(basket.peek() == temp){
						basket.pop();
						answer++;
					}else{
						basket.push(temp);
					}
				}else{
					basket.push(temp);
				}
			}
		}
		return answer*2;
    }
}
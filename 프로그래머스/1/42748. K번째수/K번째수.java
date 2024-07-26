import java.util.Arrays;
class Solution {
    public int[] solution(int[] array, int[][] commands) {
      int [] answer = new int[commands.length];
		for(int i=0; i<answer.length; i++) {
			int[] arc = Arrays.copyOfRange(array, commands[i][0]-1, commands[i][1]);
			Arrays.sort(arc);
			answer[i] = arc[commands[i][2]-1];
		}
        return answer;
    }
}
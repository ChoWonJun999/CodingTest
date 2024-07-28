class Solution {
    public int solution(int[][] board) {
        int answer = 0;
        int len = board.length;
        for(int i=0; i<len; i++){
            for(int j=0; j<len; j++){
                int cur = 1;
                if(
                    (board[i][j] == 1)
                    || (j<len-1 && board[i][j+1] == 1)
                    || (i<len-1 && j<len-1 && board[i+1][j+1] == 1)
                    || (i<len-1 && board[i+1][j] == 1)
                    || (i<len-1 && j>0 && board[i+1][j-1] == 1)
                    || (j>0 && board[i][j-1] == 1)
                    || (i>0 && j>0 && board[i-1][j-1] == 1)
                    || (i>0 && board[i-1][j] == 1)
                    || (i>0 && j<len-1 && board[i-1][j+1] == 1)
                ){
                    cur = 0;
                }
                answer += cur;
            }
        }
        return answer;
    }
}
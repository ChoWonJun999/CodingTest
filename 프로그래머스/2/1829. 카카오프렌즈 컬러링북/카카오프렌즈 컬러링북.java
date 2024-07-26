class Solution {
    boolean[][] chk;
    public int[] solution(int m, int n, int[][] picture) {
        chk = new boolean[m][n];
        int num = 0;
        int max = 0;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(picture[i][j] != 0 && chk[i][j] == false){
                    num++;
                    int cnt = 1;
                    chk[i][j] = true;
                    cnt = checkArea(picture, i, j, cnt);
                    max = max < cnt ? cnt : max;
                }
            }
        }
        int[] answer = new int[2];
        answer[0] = num;
        answer[1] = max;
        return answer;
    }
    public int checkArea(int[][] picture, int i, int j, int cnt){
        if(i-1 > -1)
			if(picture[i-1][j] != 0 && chk[i-1][j] == false)
				if(picture[i][j] == picture[i-1][j]){
					chk[i-1][j] = true;
					cnt = checkArea(picture, i-1, j, cnt+1);
				}
		if(i+1 < picture.length)
			if(picture[i+1][j] != 0 && chk[i+1][j] == false)
				if(picture[i][j] == picture[i+1][j]){
					chk[i+1][j] = true;
					cnt = checkArea(picture, i+1, j, cnt+1);
				}
		if(j-1 > -1)
			if(picture[i][j-1] !=0  && chk[i][j-1] == false)
				if(picture[i][j] == picture[i][j-1]){
					chk[i][j-1] = true;
					cnt = checkArea(picture, i, j-1, cnt+1);
				}
		if(j+1 < picture[0].length)
			if(picture[i][j+1] !=0  && chk[i][j+1] == false)
				if(picture[i][j] == picture[i][j+1]){
					chk[i][j+1] = true;
					cnt = checkArea(picture, i, j+1, cnt+1);
				}
		return cnt;
    }
}
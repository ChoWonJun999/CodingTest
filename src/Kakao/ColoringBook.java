package Kakao;

public class ColoringBook {
	public static void main(String[] args) {
//		int m = 6;
//		int n = 4;
//		int[][] picture = {{1, 1, 1, 0}, {1, 2, 2, 0}, {1, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 3}, {0, 0, 0, 3}};
		int m = 3;
		int n = 3;
		int[][] picture = {{0, 1, 0}, {1, 1, 0}, {0, 0, 0}};
		int[] sol = solution(m, n, picture);
		System.out.println("["+sol[0] + ", " + sol[1]+"]");
	}
	static boolean[][] chk;
	public static int[] solution(int m, int n, int[][] picture) {
		chk = new boolean[m][n];
		int[] answer = new int[2];
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
		answer[0] = num;
		answer[1] = max;
		for(int i=0; i<m; i++){
			for(int j=0; j<n; j++){
				System.out.print(chk[i][j]+"\t");
			}
			System.out.println();
		}
		return answer;
	}
	public static int checkArea(int[][] picture, int i, int j, int cnt){
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
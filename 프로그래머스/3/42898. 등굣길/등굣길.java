class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
		int mod = 1000000007;
		int[][] arr = new int[n][m];
		
		for(int i=0; i<puddles.length; i++) {
			arr[puddles[i][1]-1][puddles[i][0]-1] = -1;
		}
		for(int i=0; i<m; i++) {
			if(arr[0][i]==-1) {
				break;
			}
			arr[0][i] = 1;
		}
		for(int i=0; i<n; i++) {
			if(arr[i][0]==-1) {
				break;
			}
			arr[i][0] = 1;
		}
		for(int i=1; i<n; i++) {
			for(int j=1; j<m; j++) {
				if(arr[i][j]==-1) {
					continue;
				}
				if(arr[i-1][j]!=-1 && arr[i][j-1]!=-1) {
					arr[i][j] = (arr[i-1][j] + arr[i][j-1])%mod;
				}else if(arr[i-1][j]!=-1) {
					arr[i][j] = arr[i-1][j];
				}else if(arr[i][j-1]!=-1) {
					arr[i][j] = arr[i][j-1];
				}
			}
		}
		answer = arr[n-1][m-1];
		return answer;
    }
}
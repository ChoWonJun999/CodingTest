package TestKit;

public class SchoolRoad {
	public static void main(String[] args) {
		Solution31 sol = new Solution31();
		int m = 3; int n = 4; int[][] puddles = {{1, 1}};
		System.out.println(sol.solution(m, n, puddles));
	}
}
class Solution31{
	public int solution(int m, int n, int[][] puddles) {
		// ���� ����� ȿ���� �κп��� �ڲ� ������
		int answer=0;
		int[][] mAn = new int[m][n];
		for(int i=0; i<puddles.length; i++) {
			mAn[puddles[i][0]-1][puddles[i][1]-1]=-1;
		}
		mAn[0][0] = 1;
		for(int i=0; i<m; i++) {
			for(int j=0; j<n; j++) {
				if((i==0 && j==0)) continue;
				if(mAn[i][j]==-1) {
					mAn[i][j]=0;
					continue;
				}
				if(i==0) mAn[i][j] = mAn[i][j-1];
				else if(j==0) mAn[i][j] = mAn[i-1][j];
				else mAn[i][j] = mAn[i-1][j] +mAn[i][j-1];
			}
		}
		return answer%1000000007;
		/*
		// �ٸ���� �� �� ���� ����Ʈó�� ����
		int[][] mAn = new int[m+1][n+1];
		for(int i=0; i<puddles.length; i++) {
			mAn[puddles[i][0]][puddles[i][1]]=-1;
		}
		mAn[1][1]=1;
		for(int i=1; i<=m; i++) {
			for(int j=1; j<=n; j++) {
				if(mAn[i][j]==-1) {
					mAn[i][j] = 0;
					continue;
				}
				if(i!=1) mAn[i][j]+=mAn[i-1][j]%1000000007;
				if(j!=1) mAn[i][j]+=mAn[i][j-1]%1000000007;
			}
		}
		
		for(int i=0; i<=m; i++) {
			for(int j=0; j<=n; j++) {
				System.out.print(mAn[i][j]+" ");
			}
			System.out.println();
		}
		return mAn[m][n]%1000000007;
		// �ڵ���̰� �������� ��� �ݺ����� ���� ���̴µ��� ȿ���� ����....
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
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
		return answer;
		*/
	}
}
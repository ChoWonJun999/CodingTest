class Solution {
    public int[] solution(int n) {
        int len = n * (n + 1) / 2;
        int[] answer = new int[len];
        int[][] triangle = new int[n][n];

        int num = 1;
        int row = -1, col = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - (i * 3); j++) {
                triangle[++row][col] = num++;
            }
            for (int j = 0; j < n - (i * 3 + 1); j++) {
                triangle[row][++col] = num++;
            }
            for (int j = 0; j < n - (i * 3 + 2); j++) {
                triangle[--row][--col] = num++;
            }
        }

        int index = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                answer[index++] = triangle[i][j];
            }
        }

        return answer;
    }
}
class Solution {
    static int[] result = new int[2];
    static int[][] _arr;
    public int[] solution(int[][] arr) {
        _arr = arr;
        int len = arr.length;
        loop(len / 2, 0, len, 0, len);
        
        return result;
    }
    
    public static void loop(int depth, int si, int ei, int sj, int ej) {
        int chkSum = 0;
        int sum = 0;
        for (int i = si; i < ei; i++) {
            for (int j = sj; j < ej; j++) {
                sum += _arr[i][j];
                chkSum++;
            }
        }

        if (sum == 0) {
            result[0] += 1;
        } else if (sum == chkSum) {
            result[1] += 1;
        } else {
            if (ei - depth > 0 && ej - depth > 0) {
                int x = ei - depth;
                int y = ej - depth;

                depth /= 2;
                loop(depth, si, x, sj, y);
                loop(depth, x, ei, sj, y);
                loop(depth, si, x, y, ej);
                loop(depth, x, ei, y, ej);
            }
        }
    }
}
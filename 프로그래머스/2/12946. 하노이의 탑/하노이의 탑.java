import java.util.*;
class Solution {
    public static int[][] solution(int n) {
        List<int[]> result = new ArrayList<>();
        hanoi(n, 1, 3, 2, result);
        return result.toArray(new int[result.size()][2]);
    }

    private static void hanoi(int n, int from, int to, int sub, List<int[]> result) {
        if (n == 1) {
            result.add(new int[] { from, to });
            return;
        }
        hanoi(n - 1, from, sub, to, result);
        result.add(new int[] { from, to });
        hanoi(n - 1, sub, to, from, result);
    }
}
import java.util.HashMap;
class Solution {
    int[] primeNumber = new int[] { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97 };
    public int solution(int[] arr) {
        HashMap<Integer, Integer> totMap = new HashMap<>();
        int answer = 1;

        for (int a : arr) {
            HashMap<Integer, Integer> map = new HashMap<>();
            while (a > 1) {
                for (int p : primeNumber) {
                    if (a % p == 0) {
                        a /= p;
                        map.put(p, map.getOrDefault(p, 0) + 1);
                        break;
                    }
                }
            }
            map.forEach((k, v) -> {
                totMap.put(k, Math.max(totMap.getOrDefault(k, 0), v));
            });
        }

        for (int k : totMap.keySet()) {
            for (int i = 0; i < totMap.get(k); i++) {
                answer *= k;
            }
        }

        return answer;
    }
}
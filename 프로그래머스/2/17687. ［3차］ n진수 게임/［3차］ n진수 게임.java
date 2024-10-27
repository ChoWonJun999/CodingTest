class Solution {
    public String solution(int n, int t, int m, int p) {
        String fullAnswer = "";
        int num = 0;
        while (fullAnswer.length() < t * m) {
            fullAnswer += decimalSystem(num, n);
            num++;
        }
        String answer = "";
        for (int i = p - 1; i < t * m; i += m) {
            answer += fullAnswer.charAt(i);
        }

        return answer;
    }
    public String decimalSystem(int num, int n) {
        if (num == 0)
            return "0";
        String result = "";
        while (num > 0) {
            String text;
            switch (num % n) {
                case 10:
                    text = "A";
                    break;
                case 11:
                    text = "B";
                    break;
                case 12:
                    text = "C";
                    break;
                case 13:
                    text = "D";
                    break;
                case 14:
                    text = "E";
                    break;
                case 15:
                    text = "F";
                    break;
                default:
                    text = num % n + "";
            }

            result = text + result;
            num /= n;
        }
        return result;
    }
}
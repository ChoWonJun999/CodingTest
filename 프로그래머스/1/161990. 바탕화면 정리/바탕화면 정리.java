class Solution {
    public int[] solution(String[] wallpaper) {
        int[] answer = {51, 51, -1, -1};
        for(int i=0; i<wallpaper.length; i++){
            String[] data = wallpaper[i].split("");
            for(int j=0; j<data.length; j++){
                if("#".equals(data[j])){
                    answer[0] = answer[0] < i ? answer[0] : i;
                    answer[1] = answer[1] < j ? answer[1] : j;
                    answer[2] = answer[2] > i ? answer[2] : i+1;
                    answer[3] = answer[3] > j ? answer[3] : j+1;
                }
            }
        }
        return answer;
    }
}
class Solution {
    public String solution(String s) {
        String answer = "";
        int min = 0;
        int max = 0;
        String[] split_str = s.split(" ");
        for(String num: split_str){
            if(answer == ""){
                min = Integer.parseInt(num);
                max = Integer.parseInt(num);
            }else{
                min = min < Integer.parseInt(num) ? min : Integer.parseInt(num);
                max = max > Integer.parseInt(num) ? max : Integer.parseInt(num);
            }
            answer = min + " " + max;
        }
        return answer;
    }
}
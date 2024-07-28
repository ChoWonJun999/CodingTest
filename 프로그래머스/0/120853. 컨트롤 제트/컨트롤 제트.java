class Solution {
    public int solution(String s) {
        int answer = 0;
        String[] strSplit = s.split(" ");
        int last = 0;
        for(int i=0; i<strSplit.length; i++){
            if("Z".equals(strSplit[i])){
                answer -= last;
            }else{
                last = Integer.parseInt(strSplit[i]);
                answer += last;
            }
        }
        return answer;
    }
}
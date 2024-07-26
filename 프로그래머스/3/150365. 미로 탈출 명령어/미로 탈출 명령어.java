class Solution {
    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        String answer = "";
		while(k>0){
			k--;
			if(x < n){
				x++;
				answer += "d";
			}else if(y > 1){
				y--;
				answer += "l";
			}else if(y < m){
				y++;
				answer += "r";
			}else if(x > 1){
				x--;
				answer += "u";
			}
			if((Math.abs(x-r)+(Math.abs(c-y))) == k){
				if(x-r < 0) for(int i=0; i<Math.abs(x-r); i++) answer += "d";
				if(c-y < 0) for(int i=0; i<Math.abs(c-y); i++) answer += "l";
				if(c-y > 0) for(int i=0; i<Math.abs(c-y); i++) answer += "r";
				if(x-r > 0) for(int i=0; i<Math.abs(x-r); i++) answer += "u";
				return answer;
			}
		}
		return "impossible";
    }
}
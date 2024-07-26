import java.util.Vector;
class Solution {
    public int[] solution(int[] answers) {
        int[] des1 = {1,2,3,4,5};
		int[] des2 = {2,1,2,3,2,4,2,5};
		int[] des3 = {3,3,1,1,2,2,4,4,5,5};
		int[] answer = {0,0,0};
		for(int i=0; i<answers.length; i++) {
			if(answers[i%answers.length]==des1[i%des1.length]) answer[0]++;
			if(answers[i%answers.length]==des2[i%des2.length]) answer[1]++;
			if(answers[i%answers.length]==des3[i%des3.length]) answer[2]++;
		}
		Vector<Integer> v = new Vector<>();
		if(answer[0]>answer[1]) {
			if(answer[0]>answer[2]) v.add(1);
			else if(answer[0]<answer[2]) v.add(3);
			else {v.add(1); v.add(3);}
		}else if(answer[0]<answer[1]) {
			if(answer[1]>answer[2])	v.add(2);
			else if(answer[1]<answer[2]) v.add(3);
			else {v.add(2); v.add(3);}
		}else {
			if(answer[0]>answer[2]) {v.add(1); v.add(2);}
			else if(answer[0]<answer[2]) v.add(3);
			else {v.add(1);v.add(2);v.add(3);}
		}
		int[] ans = new int[v.size()];
		for(int i=0; i<ans.length; i++) ans[i]=v.get(i);
		return ans;
    }
}
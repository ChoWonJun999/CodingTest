import java.util.PriorityQueue;
class Solution {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> prS = new PriorityQueue<>((a,b) -> a-b);
		PriorityQueue<Integer> prB = new PriorityQueue<>((a,b) -> b-a);
		for(String i: operations) {
			char I_D = i.charAt(0);
			String number = i.substring(2);
			switch(I_D) {
				case 'I':
					prS.add(Integer.parseInt(number));
					prB.add(Integer.parseInt(number));
					break;
				case 'D':
					if(!prS.isEmpty()&&!prB.isEmpty())
					if(number.charAt(0)=='-') {
						int k = prS.poll();
						prB.remove(k);
					}else {
						int k = prB.poll();
						prS.remove(k);
					}
					break;
			}
		}
		int biNum=0,smNum=0;
		if(!prS.isEmpty()) smNum = prS.poll();
		if(!prB.isEmpty()) biNum = prB.poll();
		int[] answer = {biNum,smNum};
		return answer;
    }
}
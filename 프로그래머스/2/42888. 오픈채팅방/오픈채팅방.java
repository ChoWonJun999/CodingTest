import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
class Solution {
    public String[] solution(String[] record) {
        HashMap<String, String> ha = new HashMap<>();
		for(int i=0; i<record.length; i++){
			String[] temp = record[i].split(" ");
			if(!temp[0].equals("Leave")){
				if(!ha.containsKey(temp[1])){
					ha.put(temp[1], temp[2]);
				}else{
					ha.replace(temp[1], temp[2]);
				}
			}
		}
		List<String> list = new LinkedList<>();
		for(int i=0; i<record.length; i++){
			String[] temp = record[i].split(" ");
			switch (temp[0]) {
			case "Enter":
					list.add(ha.get(temp[1])+"님이 들어왔습니다.");
				break;
			case "Leave":
					list.add(ha.get(temp[1])+"님이 나갔습니다.");
				break;
			}
		}
		return list.toArray(new String[list.size()]);
    }
}
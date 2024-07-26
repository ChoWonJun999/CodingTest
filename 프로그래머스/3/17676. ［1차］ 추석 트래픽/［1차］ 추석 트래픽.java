import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.text.ParseException;
class Solution {
    public static int solution(String[] lines) throws ParseException{
		int answer = 0;
		SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
		List<Date[]> list = new ArrayList<>();
		
		for(String str : lines){
			Date[] inOut = new Date[2];
			String[] source = str.split(" ");
			Date out = f.parse(source[0] + " " + source[1]);
			
			long in = out.getTime() - (long)((Double.valueOf(source[2].replaceAll("[^0-9.]","")) - 0.001)*1000);
			
			inOut[0] = f.parse(f.format(in));
			inOut[1] = f.parse(source[0] + " " + source[1]);
			list.add(inOut);
		}
		
		for(int i=0; i<list.size(); i++){
			if(i<list.size()-1){
				if(list.get(i)[1].getTime() - list.get(i+1)[0].getTime() > 1000){
					i++;
				}
			}
			
			int cnt = countTraffic(list.get(i)[0].getTime(), list);
			
			answer = answer < cnt ? cnt : answer;
			
			cnt = countTraffic(list.get(i)[1].getTime(), list);
			answer = answer < cnt ? cnt : answer;
		}
		
		return answer;
	}
	
	public static int countTraffic(Long longTime, List<Date[]> list) throws ParseException{
		int cnt = 0;
		for(Date[] str : list){
			Date start = str[0];
			Date end = str[1];
			if((start.getTime() >= longTime && start.getTime() <= longTime+999) || (end.getTime() >= longTime && end.getTime() <= longTime+999) || (start.getTime() <= longTime && longTime+999 <= end.getTime())){
				cnt++;
			}
		}
		return cnt;
	}
}
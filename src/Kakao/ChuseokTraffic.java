package Kakao;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.text.ParseException;

public class ChuseokTraffic {
	public static void main(String[] args) throws ParseException {
		
		String[] lines = {"2016-09-15 01:00:04.001 2.0s", "2016-09-15 01:00:07.000 2s"};
		System.out.println(solution(lines));	// 1
		
		String[] lines1 = {"2016-09-15 01:00:04.002 2.0s", "2016-09-15 01:00:07.000 2s"};
		System.out.println(solution(lines1));	// 2
		
		String[] lines2 = {"2016-09-15 20:59:57.421 0.351s", "2016-09-15 20:59:58.233 1.181s",
							"2016-09-15 20:59:58.299 0.8s", "2016-09-15 20:59:58.688 1.041s",
							"2016-09-15 20:59:59.591 1.412s", "2016-09-15 21:00:00.464 1.466s",
							"2016-09-15 21:00:00.741 1.581s", "2016-09-15 21:00:00.748 2.31s",
							"2016-09-15 21:00:00.966 0.381s", "2016-09-15 21:00:02.066 2.62s"};
		System.out.println(solution(lines2));	// 7
	}
	
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
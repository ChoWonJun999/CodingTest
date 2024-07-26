import java.util.HashSet;
import java.util.Set;
import java.util.Vector;
class Solution {
    public Set<Integer> set = new HashSet<>();
	public int solution(String numbers) {
		set.clear();
		String[] number = numbers.split("");
		Vector<String> v = new Vector<>();
		for(String i:number) v.add(i);
		
		for(int i=0; i<v.size(); i++) {
			String out = v.remove(0);
			if(Integer.parseInt(out)!=0) {
				if(check(out)) set.add(Integer.parseInt(out));
				if(v.size()!=0) {
					LoopFunction(v, out);
				}
			}
			v.add(out);
		}
		return set.size();
	}
	public void LoopFunction(Vector<String> v, String out) {
		for(int i=0; i<v.size(); i++) {
			String out1 = v.remove(0);
			if(Integer.parseInt(out+out1)!=0) {
				if(check(out+out1)) set.add(Integer.parseInt(out+out1));
				if(v.size()!=0) {
					LoopFunction(v,out+out1);
				}
			}
			v.add(out1);
		}
	}
	public boolean check(String number) {
		int intNum = Integer.parseInt(number);
		if(intNum==0 || intNum==1) return false;
		for(int i=2; i<intNum; i++) {
			if(intNum%i==0) return false;
		}
		return true;
	}
}
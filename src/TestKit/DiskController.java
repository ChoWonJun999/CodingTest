package TestKit;

import java.util.Iterator;
import java.util.PriorityQueue;

public class DiskController {
	public static void main(String[] args) {
		Solution15 sol = new Solution15();
		int[][] jobs = {{0,3},{1,9},{2,6}};
		System.out.println(sol.solution(jobs));
	}
}
class Solution15{
	public int solution(int[][] jobs) {
		PriorityQueue<int[]> pr = new PriorityQueue<>((a,b) -> a[0]-b[0]);	//��û�Ǵ� ������ ���� ���� ����
		PriorityQueue<int[]> pr2 = new PriorityQueue<>((a,b) -> a[1]-b[1]);	//�۾��� �ҿ�ð��� ���� ���� ����
		for(int[] i: jobs) pr.add(i);
		
		int le=pr.peek()[0];	//���� ����
		//*jobs = {{1,9},{1,3}} �̷��� ���ø� �־��� �� ��� ��û�ð��� 1�̱⶧���� ��������� 1���� �����ؾ��Ѵ�. (�� �ڵ忡�� �ϱ� ������ �׷���)
		//���� le=0; ���� ����� ������ ��� ���� 8,18������ ���� ����
		int count=0;	//��û���� ��������� �ð����� ��
		
		while(!pr.isEmpty()) {
			int k[] = pr.poll();	//��û�Ǵ� ������ ���� ���� �۾�	*k�� ���� ������ �۾��� ����
		//���� ���� Ȥ�� �� ���� ��û�� ���� �͵�
			if(k[0]<=le) {	//k�� ��û�� ������ ���� �������� �۰ų� ���ٸ� ����
				pr.add(k);	//pr2�� ���� �۾������� k�� �ҿ�ð��� ���� ���� ���� �ƴϱ� ������ pr�� �ٽ� �־ �񱳸� �ؾ� �Ѵ�.
				Iterator<int[]> it = pr.iterator();
				while(it.hasNext()) {
					int l[] = it.next();
					if(l[0]<=le) pr2.add(l);	//���� �������� ���� ��û�� �۾����� ����
				}
				int a[] = pr2.poll();	//���� �� �ҿ�ð��� ���� ���� �۾�
				pr.remove(a);	//�̰��� pr���� ����
				k=a;	//�̰��� ���� ����
				pr2.clear();	//���� ������ ���� pr2 ����
			}
		//�� �۾��� ��û���� ��������� �ð��� ���� ������ ���ϴ� ����
			if(le-k[0]>0) {	
				count+=(le-k[0]+k[1]); //��û���� ��������� �ð� = ������� - ��û�� ���� + �ҿ�ð� *����* count �� ��û���� ��������� �ð�, count = (��û���� ��������� �ð�)���� ��
				le+=k[1];	//������� = �۾� �ҿ�ð� ����
			}else {	//�۾��� ��ġ�� �ʰ� ���� ���
				count+=k[1];	//��û���� ��������� �ð� = �ҿ�ð�
				le = k[1]+k[0];	//������� = �ҿ�ð�+��û�� ����
			}
		}
		return count/jobs.length;
	}
}
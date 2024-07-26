// 문제가 개편되었습니다. 이로 인해 함수 구성이나 테스트케이스가 변경되어, 과거의 코드는 동작하지 않을 수 있습니다.
// 새로운 함수 구성을 적용하려면 [코드 초기화] 버튼을 누르세요. 단, [코드 초기화] 버튼을 누르면 작성 중인 코드는 사라집니다.
class Solution {
    public int[] solution(int brown, int red) {
        int sum = brown+red;
		int width=0; int height=0;
		for(int i=3; i<=(int)Math.sqrt(sum); i++) {
			if(sum%i==0) {
				int j=sum/i;
				if(brown==i*2+(j-2)*2) {
					width=j; height=i;
				}
			}
		}
		int[] answer= {width,height};
		return answer;
    }
}
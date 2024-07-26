import java.util.*;

class Solution {
    public int solution(int coin, int[] cards) {
        int answer = 1;
        int n = cards.length;
        Stack<Integer> cardStack = new Stack<>();
        Set<Integer> myCards = new HashSet<>();
        Set<Integer> garbageCards = new HashSet<>();
        for(int i=n-1; i>=0; i--) cardStack.add(cards[i]);
        for(int i=0; i<n/3; i++) myCards.add(cardStack.pop());
        
        while(!cardStack.isEmpty()){
            boolean chk = true;
            int popCard1 = cardStack.pop();
            int popCard2 = cardStack.pop();
            
            for(int data : myCards){
                if(myCards.contains(n+1-data)){
                    chk = false;
                    myCards.remove(n+1-data);
                    myCards.remove(data);
                    
                    garbageCards.add(popCard1);
                    garbageCards.add(popCard2);
                    break;
                }
            }
            
            if(chk){
                if(myCards.contains(n+1-popCard1) && coin > 0){
                    coin--;
                    myCards.remove(n+1-popCard1);
                    garbageCards.add(popCard2);
                    chk = false;
                }else{
                    garbageCards.add(popCard1);
                }
            }
            
            if(chk){
                if(myCards.contains(n+1-popCard2) && coin > 0){
                    coin--;
                    myCards.remove(n+1-popCard2);
                    chk = false;
                }else{
                    garbageCards.add(popCard2);
                }
            }
            
            if(chk){
                for(int data : myCards){
                    if(garbageCards.contains(n+1-data) && coin > 0){
                        coin--;
                        chk = false;
                        garbageCards.remove(n+1-data);
                        myCards.remove(data);
                        break;
                    }
                }
            }
            
            if(chk){
                for(int data : garbageCards){
                    if(garbageCards.contains(n+1-data) && coin > 1){
                        coin-=2;
                        chk = false;
                        garbageCards.remove(n+1-data);
                        garbageCards.remove(data);
                        break;
                    }
                }
            }
            
            if(chk) break;
            answer++;
        }
        return answer;
    }
}
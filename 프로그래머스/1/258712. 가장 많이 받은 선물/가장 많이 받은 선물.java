import java.util.*;
class Solution {
    public int solution(String[] friends, String[] gifts) {
        int[] friendsTakeGifts = new int[friends.length];
        HashMap<String, Integer> relationship = new HashMap<>();
        HashMap<String, Integer> score = new HashMap<>();
        for(int i=0; i<friends.length-1; i++){
            score.put(friends[i], 0);
            for(int j=i+1; j<friends.length; j++){
                relationship.put(friends[i] + " " + friends[j], 0);
                relationship.put(friends[j] + " " + friends[i], 0);
            }
        }
        score.put(friends[friends.length-1], 0);
        
        for(int i=0; i<gifts.length; i++){
            String give = gifts[i].split(" ")[0];
            String take = gifts[i].split(" ")[1];
            score.put(give, score.get(give) + 1);
            
            score.put(take, score.get(take) - 1);
            
            relationship.put(gifts[i], relationship.get(gifts[i]) + 1);
        }
        
        for(int i=0; i<friends.length-1; i++){
            for(int j=i+1; j<friends.length; j++){
                String key1 = friends[i] + " " + friends[j];
                String key2 = friends[j] + " " + friends[i];
                if(relationship.get(key1) > relationship.get(key2)) friendsTakeGifts[i]++;
                else if(relationship.get(key1) < relationship.get(key2)) friendsTakeGifts[j]++;
                else{
                    if(score.get(friends[i]) > score.get(friends[j])) friendsTakeGifts[i]++;
                    else if(score.get(friends[i]) < score.get(friends[j])) friendsTakeGifts[j]++;
                }
            }
        }
        int answer = -1;
        for(int giftCnt:friendsTakeGifts){
            answer = answer < giftCnt ? giftCnt : answer;
        }
        return answer;
    }
}
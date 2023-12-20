import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        Map<String, Integer>map=new HashMap<>();
        Map<Integer, String>map2=new HashMap<>();
        for(int i=0;i<players.length;i++){
            map.put(players[i],i);
            map2.put(i,players[i]);
        }
        
        for(String player:callings){
            int rank=map.get(player);
            
            String changePlayer=map2.get(rank-1);
            int changeRank=map.get(changePlayer);
            
            map.put(player,rank-1);
            map.put(changePlayer,rank);
            
            map2.put(rank-1,player);
            map2.put(rank,changePlayer);
        }
        
        String[] answer=new String[players.length];
        for(int i=0;i<players.length;i++){
            answer[i]=map2.get(i);
        }
        return answer;
    }
}
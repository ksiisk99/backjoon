import java.util.*;

class Solution {
    boolean[] visit;
    List<String>answer;
    
    public String[] solution(String[][] tickets) {
        visit=new boolean[tickets.length];
        answer=new ArrayList<>();
        
        dfs("ICN","ICN", tickets, 0);
        
        Collections.sort(answer);
        return answer.get(0).split(" ");
    }
    
    public void dfs(String airport, String route, String[][] tickets, int cnt){
        if(cnt==tickets.length){
            answer.add(route);
            return;
        }
        
        for(int i=0;i<tickets.length;i++){
            if(airport.equals(tickets[i][0]) && !visit[i]){
                visit[i]=true;
                dfs(tickets[i][1], route+" "+tickets[i][1], tickets, cnt+1);
                visit[i]=false;
            }
        }
    }
}
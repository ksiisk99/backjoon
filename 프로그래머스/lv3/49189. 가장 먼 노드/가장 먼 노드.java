import java.util.*;

class Solution {
    List<Integer>[] adjust;
    int[] visit;
    int max=Integer.MIN_VALUE;
    
    void search(int node){
        for(int next:adjust[node]){
            if(visit[next]>visit[node]+1){
                visit[next]=visit[node]+1;
                search(next);
            }
        }
    }
    
    public int solution(int n, int[][] edge) {
        int answer=0;
        adjust=new ArrayList[n+1];
        visit=new int[n+1];
        for(int i=1;i<=n;i++){
            visit[i]=Integer.MAX_VALUE;
            adjust[i]=new ArrayList<>();
        }
        visit[1]=0;
        
        for(int i=0;i<edge.length;i++){
            adjust[edge[i][0]].add(edge[i][1]);
            adjust[edge[i][1]].add(edge[i][0]);
        }
        search(1);
        
        max=Arrays.stream(visit)
            .max()
            .getAsInt();
        
        for(int i=1;i<=n;i++){
            if(visit[i]==max)answer++;
        }
        return answer;
    }
}
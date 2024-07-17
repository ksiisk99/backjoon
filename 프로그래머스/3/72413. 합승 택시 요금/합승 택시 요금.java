import java.util.*;

class Solution {
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int[][] graph = new int[n+1][n+1];
        for(int i=1;i<=n;i++) {
            Arrays.fill(graph[i], 10000001);
            graph[i][i]=0;
        }
        
        for(int[] fare:fares){
            graph[fare[0]][fare[1]]=fare[2];
            graph[fare[1]][fare[0]]=fare[2];
        }
        
        for(int k=1;k<=n;k++){
            for(int i=1;i<=n;i++){
                for(int j=1;j<=n;j++){
                    if(graph[i][j]>graph[i][k]+graph[k][j]){
                        graph[i][j]=graph[i][k]+graph[k][j];
                    }
                }
            }
        }
        
        int answer=graph[s][a]+graph[s][b];
        for(int i=1;i<=n;i++){
            if(graph[s][i]+graph[i][a]+graph[i][b]<answer){
                answer=graph[s][i]+graph[i][a]+graph[i][b];
            }        
        }
        return answer;
    }
}
import java.util.*;
import java.util.stream.*;

class Solution {
    List<Integer>[] edge;
    
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        init(n, roads);
        List<Integer>answer = new ArrayList<>();
        
        for(int start:sources) {
            answer.add(dijkstra(n, start, destination));
        }
        
        return answer.stream()
            .mapToInt(i->i)
            .toArray();
    }
    
    int dijkstra(int n ,int start, int destination) {
        int[] dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        
        Queue<Integer>queue = new LinkedList<>();
        queue.add(start);
        dist[start]=0;
        
        while(!queue.isEmpty()){
            int node = queue.poll();
            
            for(int next:edge[node]){
                if(dist[next]>dist[node] + 1) {
                    dist[next] = dist[node]+1;
                    if(next==destination){
                        return dist[next];
                    }
                    queue.add(next);
                }
            }
        }
        if(dist[destination]==Integer.MAX_VALUE)return -1;
        return dist[destination];
    }
    
    void init(int n, int[][] roads){
        edge=new ArrayList[n+1];
        for(int i=1;i<=n;i++){
            edge[i]=new ArrayList<>();
        }
        
        for(int[] p:roads){
            edge[p[0]].add(p[1]);
            edge[p[1]].add(p[0]);
        }
    }
}
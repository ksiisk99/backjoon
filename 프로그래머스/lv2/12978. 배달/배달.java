import java.util.*;
class Solution {
    static int[] dist;
    static ArrayList<Edge>[] edges;
    static class Edge implements Comparable<Edge>{
        int v,cost;
        public Edge(int v,int cost){
            this.v=v;
            this.cost=cost;
        }
        
        @Override
        public int compareTo(Edge o){
            return this.cost-o.cost;
        }
    }
    
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        dist=new int[N+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        edges=new ArrayList[N+1];
        for(int i=1;i<=N;i++)edges[i]=new ArrayList<>();
        for(int i=0;i<road.length;i++){
            int n1=road[i][0];
            int n2=road[i][1];
            int cost=road[i][2];
            edges[n1].add(new Edge(n2,cost));
            edges[n2].add(new Edge(n1,cost));
        }
        
        dist[1]=0;
        PriorityQueue<Edge>pq=new PriorityQueue<>();
        pq.add(new Edge(1,0));
        while(!pq.isEmpty()){
            Edge cur=pq.poll();
            if(dist[cur.v]<cur.cost)continue;
            for(Edge next:edges[cur.v]){
                if(dist[next.v]>dist[cur.v]+next.cost){
                    dist[next.v]=dist[cur.v]+next.cost;
                    pq.add(new Edge(next.v, dist[next.v]));
                }
            }
        }
        for(int i=1;i<=N;i++){
            if(dist[i]<=K)answer++;
        }
        return answer;
    }
    
}
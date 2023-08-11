import java.util.*;

class Solution {
    private List<int[]>[] graph;
    private int[] intensity;
    
    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        createGraph(n,paths,gates,summits);
        return dijkstra(n, gates, summits);
    }
    
    private int[] dijkstra(int n, int[] gates, int[] summits) {
        Queue<int[]> queue =new LinkedList<>();
        for(int gate:gates) {
            intensity[gate]=0;
            queue.add(new int[]{gate,0});
        }
        
        while(!queue.isEmpty()){
            int[] info = queue.poll();
            int num = info[0];
            int weight = info[1];
            
            if(intensity[num] < weight) continue;
            
            for(int[] edge: graph[num]) {
                int nextNum = edge[0];
                int nextWeight = Math.max(edge[1], weight);
                
                if(intensity[nextNum] > nextWeight) {
                    intensity[nextNum] = nextWeight;
                    queue.add(new int[]{nextNum, nextWeight});
                }
            }
        }
        
        List<int[]> answer = new ArrayList<>();
        for(int summit:summits){
            answer.add(new int[]{summit, intensity[summit]});
        }
        
        Collections.sort(answer, (a,b) -> {
            if(a[1]==b[1]) {
                return a[0]-b[0];
            }
            return a[1]-b[1];
        });
        
        return answer.get(0);
    }
    
    private void createGraph(int n, int[][] paths, int[] gates, int[] summits) {
        graph=new ArrayList[n+1];
        intensity=new int[n+1];
        Arrays.fill(intensity, Integer.MAX_VALUE);
        
        for(int i=1;i<=n;i++){
            graph[i]=new ArrayList<>();
        }
        
        boolean[] gateNum = new boolean[n+1];
        boolean[] summitNum = new boolean[n+1];
        
        for(int gate:gates){
            gateNum[gate]=true;
        }
        
        for(int summit:summits){
            summitNum[summit]=true;
        }
        
        for(int[] path: paths) {
            int i = path[0];
            int j = path[1];
            int w = path[2];
            
            if(gateNum[i] && !gateNum[j]){
                graph[i].add(new int[]{j,w});
            } else if(!gateNum[i] && gateNum[j]) {
                graph[j].add(new int[]{i,w});
            } else if(!gateNum[i] && !gateNum[j]){
                if(summitNum[i] && !summitNum[j]){
                    graph[j].add(new int[]{i,w});
                } else if(!summitNum[i] && summitNum[j]) {
                    graph[i].add(new int[]{j,w});
                } else if(!summitNum[i] && !summitNum[j]) {
                    graph[j].add(new int[]{i,w});
                    graph[i].add(new int[]{j,w});
                }
            }
        }
    }
}
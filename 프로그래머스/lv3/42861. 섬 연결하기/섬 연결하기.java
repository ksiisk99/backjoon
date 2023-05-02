import java.util.*;

class Solution {
    int[] parent;
    
    int find(int n){
        if(n==parent[n])return n;
        return parent[n]=find(parent[n]);
    }
    
    void union(int a,int b){
        if(a<b){
            parent[b]=a;
            return;
        }
        parent[a]=b;
    }
    
    public int solution(int n, int[][] costs) {
        parent=new int[n+1]; 
        for(int i=1;i<=n;i++){
            parent[i]=i;
        }
        
        Arrays.sort(costs, new Comparator<>(){
            @Override
            public int compare(int[] a,int[] b){
                return a[2]-b[2];
            }
        });
         
        int answer = 0;
        for(int[] cost:costs){
            int a=find(cost[0]);
            int b=find(cost[1]);
            if(a != b){
                union(a, b);
                answer+=cost[2];
            }
        }
        
        return answer;
    }
}
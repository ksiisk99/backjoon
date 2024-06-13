import java.util.*;
class Solution {
    static int[] parent;
    static int find(int x){
        if(x==parent[x])return x;
        return parent[x]=find(parent[x]);
    }
    
    static void union(int n1,int n2){
        if(n1<n2)
            parent[n2]=n1;
        else
            parent[n1]=n2;
    }
    
    public int solution(int n, int[][] wires) {
        int answer = 101;
        parent=new int[n+1];
        
        for(int t=0;t<n-1;t++){
            for(int k=1;k<=n;k++)parent[k]=k;
            for(int i=0;i<n-1;i++){
                if(i==t)continue;
                
                int n1=find(wires[i][0]);
                int n2=find(wires[i][1]);
                if(n1!=n2){
                    union(n1,n2);
                }
            }
            int cnt=0,cnt2=0;
            for(int k=1;k<=n;k++){
                if(find(parent[k])==1)cnt++;
                else cnt2++;
            }
            
            answer=Math.min(answer,Math.abs(cnt-cnt2));
        }
        return answer;
    }
}
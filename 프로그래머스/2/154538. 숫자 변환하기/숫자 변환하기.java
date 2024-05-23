import java.util.*;

class Solution {
    public int solution(int x, int y, int n) {
        if(x==y)return 0;
        
        int answer = 0;
        Queue<int[]>queue=new LinkedList<>();
        queue.add(new int[]{0,x});
        boolean[] visit=new boolean[1000001];
        visit[x]=true;
        
        while(!queue.isEmpty()){
            int[] info =queue.poll();
            int cnt=info[0];
            int num=info[1];
            
            int next=num+n;
            if(next==y){
                return cnt+1;
            }
            if(next<1000001 && !visit[next]){
                visit[next]=true;
                queue.add(new int[]{cnt+1,next});
            }
            
            next=num*2;
            if(next==y){
                return cnt+1;
            }
            if(next<1000001 && !visit[next]){
                visit[next]=true;
                queue.add(new int[]{cnt+1,next});
            }
            
            next=num*3;
            if(next==y){
                return cnt+1;
            }
            if(next<1000001 && !visit[next]){
                visit[next]=true;
                queue.add(new int[]{cnt+1,next});
            }
        }
        return -1;
    }
}
import java.util.*;
class Solution {
    static int[] dx={0,0,-1,1};
    static int[] dy={1,-1,0,0};
    static int[][] visit;
   
    public int solution(int[][] maps) {
        int N=maps.length;
        int M=maps[0].length;
        visit=new int[N+1][M+1];
        for(int i=1;i<=N;i++)Arrays.fill(visit[i],Integer.MAX_VALUE);
        visit[1][1]=1;
        
        Queue<int[]>queue=new LinkedList<>();
        queue.add(new int[]{1,1,1});
        while(!queue.isEmpty()){
            int[] cur=queue.poll();
            for(int i=0;i<4;i++){
                int nx=cur[0]+dx[i];
                int ny=cur[1]+dy[i];
                if(nx<=0 || ny<=0 || nx>N || ny>M || maps[nx-1][ny-1]==0)continue;
                int cnt=cur[2]+1;
                if(visit[nx][ny]>visit[cur[0]][cur[1]]+1){
                    visit[nx][ny]=visit[cur[0]][cur[1]]+1;
                    queue.add(new int[]{nx,ny,visit[nx][ny]});
                }
            }
        }
        return visit[N][M]==Integer.MAX_VALUE?-1:visit[N][M];
    }
}
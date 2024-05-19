import java.util.*;

class Solution {
    static int[] dx={0,0,1,-1};
    static int[] dy={1,-1,0,0};
    
    public int solution(String[] maps) {
        int sx=0,sy=0,ex=0,ey=0,lx=0,ly=0;
        for(int i=0;i<maps.length;i++){
            for(int j=0;j<maps[i].length();j++){
                if(maps[i].charAt(j)=='S'){
                    sx=i;sy=j;
                }else if(maps[i].charAt(j)=='E'){
                    ex=i;ey=j;
                }else if(maps[i].charAt(j)=='L'){
                    lx=i;ly=j;
                }
            }
        }

        int t1=findMinDistance(maps,sx,sy,lx,ly);
        if(t1==0)return -1;
        int t2=findMinDistance(maps,lx,ly,ex,ey);
        if(t2==0)return -1;
        
        return t1+t2;
    }
    
    static int findMinDistance(String[] maps,int sx,int sy, int ex,int ey){
        int N=maps.length;
        int M=maps[0].length();
        
        boolean[][] visit=new boolean[N][M];
        Queue<int[]>queue=new LinkedList<>();
        queue.add(new int[]{sx,sy,0});
        visit[sx][sy]=true;
        
        while(!queue.isEmpty()){
            int[] info=queue.poll();
            int x=info[0];
            int y=info[1];
            int cnt=info[2];
            
            for(int i=0;i<4;i++){
                int nx=x+dx[i];
                int ny=y+dy[i];
                if(nx<0||ny<0||nx>=N||ny>=M||visit[nx][ny]||maps[nx].charAt(ny)=='X')continue;
                if(nx==ex && ny==ey){
                    System.out.println(cnt+1);
                    return cnt+1;
                }
                visit[nx][ny]=true;
                queue.add(new int[]{nx,ny,cnt+1});
            }
        }
        return 0;
    }
}
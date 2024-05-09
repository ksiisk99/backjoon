import java.util.*;

class Solution {
    boolean[][][] visit;
    int N,M,gx,gy,result;
    int[] dx={0,0,-1,1};
    int[] dy={1,-1,0,0};
    
    int bfs(String[] board, int tx,int ty){
        Queue<int[]>queue=new LinkedList<>();
        queue.add(new int[]{tx,ty,0});
        
        while(!queue.isEmpty()){
            int[] info=queue.poll();
            int x=info[0];
            int y=info[1];
            int cnt=info[2];
            
            if(x==gx && y==gy){
                return cnt;
            }
            
            for(int i=0;i<4;i++){
                int nx=x+dx[i];
                int ny=y+dy[i];
                
                if(nx<0||ny<0||nx>=N||ny>=M || visit[i][nx][ny] || board[nx].charAt(ny)=='D'){
                    continue;
                }
                visit[i][x][y]=true;
                
                while(true){
                    if(nx<0||ny<0||nx>=N||ny>=M){
                        nx-=dx[i];
                        ny-=dy[i];
                        //System.out.println(nx+" E "+ny+" "+i);
                        queue.add(new int[]{nx,ny,cnt+1});
                        break;
                    }
                    if(visit[i][nx][ny]){
                        break;
                    }
                    visit[i][nx][ny]=true;

                    if(board[nx].charAt(ny)=='.' || board[nx].charAt(ny)=='R' || board[nx].charAt(ny)=='G'){
                        nx+=dx[i];
                        ny+=dy[i];
                    }else if(board[nx].charAt(ny)=='D'){
                        nx-=dx[i];
                        ny-=dy[i];
                        //System.out.println(nx+" D "+ny+" "+i);
                        queue.add(new int[]{nx,ny,cnt+1});
                        break;
                    }
                }                
            }
        }
        
        return -1;
    }
    
    public int solution(String[] board) {
        N=board.length;
        M=board[0].length();
        result=Integer.MAX_VALUE;
        visit=new boolean[4][N][M];
        
        int sx=0,sy=0;
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(board[i].charAt(j)=='G'){
                    gx=i; gy=j;
                }else if(board[i].charAt(j)=='R'){
                    sx=i; sy=j;
                }
            }
        }
        
        return bfs(board, sx,sy);
    }
}
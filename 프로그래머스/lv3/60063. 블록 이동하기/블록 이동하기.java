import java.util.*;

class Solution {
    private final int WIDTH = 0;
    private final int HEIGHT = 1;
    private int[] dx={-1,1,0,0};
    private int[] dy={0,0,-1,1};
    
    public int solution(int[][] board) {
        int answer = 0;
        int N = board.length-1;
        boolean[][][] visit = new boolean[N+1][N+1][2];
        
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0,0,0,1, WIDTH, 0});
        
        while(!queue.isEmpty()){
            int[] info = queue.poll();
            int tx=info[0];
            int ty=info[1];
            int hx=info[2];
            int hy=info[3];
            int type=info[4];
            int cnt = info[5];
            
            //System.out.println(tx+" "+ty+" "+hx+ " "+hy+ " "+type+" "+cnt);
            if( (hx==N && hy==N) || (tx==N && ty==N)) {
                return cnt;
            }
            
            if(visit[hx][hy][type] && visit[tx][ty][type]) continue;
            
            visit[hx][hy][type]=true;
            visit[tx][ty][type]=true; 
            
            for(int d=0;d<4;d++){
                int ntx = tx+dx[d];
                int nty = ty+dy[d];
                int nhx = hx+dx[d];
                int nhy = hy+dy[d];
                
                if(checkMove(ntx,nty,nhx,nhy, board)) {
                    queue.add(new int[]{ntx,nty,nhx,nhy,type,cnt+1});
                }
            }
            
            
            if(type == WIDTH) { //가로
                if(checkMove(tx-1,ty,hx-1,hy,board)) { //위로
                    queue.add(new int[]{tx,ty,hx-1,ty,HEIGHT, cnt+1});
                    queue.add(new int[]{hx,hy,hx-1,hy,HEIGHT, cnt+1});
                }
                
                if(checkMove(tx+1, ty, hx+1, hy,board)) { //아래
                    queue.add(new int[]{tx,ty,hx+1,ty,HEIGHT, cnt+1});
                    queue.add(new int[]{hx,hy,hx+1,hy,HEIGHT, cnt+1});
                }
            } else { //세로
                if(checkMove(tx,ty-1,hx,hy-1,board)){ //왼쪽
                    queue.add(new int[]{tx,ty,tx,hy-1,WIDTH,cnt+1});
                    queue.add(new int[]{hx,hy,hx,hy-1,WIDTH,cnt+1});
                } 
                
                if(checkMove(tx,ty+1,hx,hy+1,board)) { //오른쪽
                    queue.add(new int[]{tx,ty,tx,hy+1,WIDTH,cnt+1});
                    queue.add(new int[]{hx,hy,hx,hy+1,WIDTH,cnt+1});
                }
            }
        }
        
        return -1;
    }
    
    boolean checkMove(int x1,int y1,int x2,int y2, int[][] board) {
        int N = board.length;
        if(x1<0 || y1<0 || x1>=N || y1>=N
          || x2<0 || y2<0 || x2>=N || y2>=N
          || board[x1][y1]==1 || board[x2][y2]==1) return false;
        return true;
    }
}
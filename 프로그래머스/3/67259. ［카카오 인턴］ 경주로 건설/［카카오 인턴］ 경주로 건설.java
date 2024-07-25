import java.util.*;

class Solution {
    private static int[] dx={0,0,1,-1};
    private static int[] dy={1,-1,0,0};
    private static int[][][] costBoard;
    private static int N,M;
    
    static void dfs(int[][] board, int x,int y, int dir){
        
        for(int i=0;i<4;i++){
            int nx=x+dx[i];
            int ny=y+dy[i];
            
            if(nx<0||ny<0||nx>=N||ny>=M || board[nx][ny]==1){
                continue;
            }
            
            if(x==0 && y==0){
                costBoard[nx][ny][i]=100;
                dfs(board,nx,ny,i);
            }else{
                if(isSameDir(dir, i)){
                    if(costBoard[nx][ny][i]>costBoard[x][y][dir]+100){
                        costBoard[nx][ny][i]=costBoard[x][y][dir]+100;
                        dfs(board, nx, ny, i);
                    }
                }else {
                    if(costBoard[nx][ny][i]>costBoard[x][y][dir]+600){
                        costBoard[nx][ny][i]=costBoard[x][y][dir]+600;
                        dfs(board, nx, ny, i);
                    }
                }
            }
        }
    }
    
    static boolean isCornerDir(int cur, int next){
        if((cur==0 || cur==1) && (next==2 || next==3)){
            return true;
        }else if((cur==2 || cur==3) && (next==0 || next==1)){
            return true;
        }
        return false;
    }
    
    static boolean isSameDir(int cur, int next){
        if(cur==next)return true;
        return false;
    }
    
    static int convertDir(int dir){
        if(dir==0){
            return 1;
        }else if(dir==1){
            return 0;
        }else if(dir==2){
            return 3;
        }
        return 2;
    }
    
    public int solution(int[][] board) {
        int answer = 0;
        N=board.length;
        M=board[0].length;
        costBoard = new int[N][M][4];
        
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                for(int d=0;d<4;d++){
                    costBoard[i][j][d]=Integer.MAX_VALUE;
                    costBoard[0][0][d]=0;
                }
            }
        }
        
        dfs(board, 0,0,0);
        
        return Arrays.stream(costBoard[N-1][M-1])
            .filter(i->i!=Integer.MAX_VALUE)
            .min()
            .getAsInt();
    }
}
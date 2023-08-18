import java.util.*;

class Solution {
    private int[][] board=new int[102][102];
    private int[] dx={0,0,-1,1};
    private int[] dy={1,-1,0,0};
    private int[] bx={-1,-1,-1,0,0,1,1,1};
    private int[] by={-1,0,1,-1,1,-1,0,1};
    
    public void fill(int x,int y) {
        board[x][y]=2;
        for(int i=0;i<4;i++){
            int nx=x+dx[i];
            int ny=y+dy[i];
            
            if(nx<0 || ny<0||nx>101||ny>101 ||board[nx][ny]!=0) {
                continue;
            }
            fill(nx,ny);
        }
    }
    
    public void boundary(int x,int y){
        for(int i=0;i<8;i++){
            int nx=x+bx[i];
            int ny=y+by[i];
            
            if(nx<0 || ny<0||nx>101||ny>101 ||board[nx][ny]!=1) {
                continue;
            }
            board[nx][ny]=3;
        }
    }
    
    public int find(int characterX, int characterY, int itemX, int itemY) {
        Queue<int[]> queue = new LinkedList<>();
        
        queue.add(new int[]{characterY, characterX, 0});
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            int x=cur[0];
            int y=cur[1];
            int cnt=cur[2];
            
            if(x==itemY && y==itemX) {
                return cnt/2;
            }
            
            board[x][y]=2;
            
            for(int i=0;i<4;i++){
                int nx=x+dx[i];
                int ny=y+dy[i];

                if(nx<0 || ny<0||nx>101||ny>101 ||board[nx][ny]!=3) {
                    continue;
                }
                queue.add(new int[]{nx,ny,cnt+1});
            }
        }
        
        return 0;
    }
    
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int answer = 0;
        for(int[] rect: rectangle) {
            int x1=rect[0];
            int y1=rect[1];
            int x2=rect[2];
            int y2=rect[3];
            
            for(int i=y1*2;i<=y2*2;i++) {
                for(int j=x1*2;j<=x2*2;j++) {
                    board[i][j]=1;
                }
            }
        }
        
        for(int i=0;i<51;i++) {
            for(int j=0;j<51;j++){
                if(board[i][j]==0){
                    fill(i,j);
                }
            }
        }
        
        for(int i=0;i<102;i++){
            for(int j=0;j<102;j++){
                if(board[i][j]==2) {   
                    boundary(i,j); 
                }
            }
        }
        
        return find(characterX*2, characterY*2, itemX*2, itemY*2);
    }
}
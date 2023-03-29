import java.util.*;

class Solution {    
    public int[] solution(String[] park, String[] routes) {
        int N=park.length;
        int M=park[0].length();
        int[][] board=new int[N][M];
        int[] dx={-1,0,1,0}; //북동남서
        int[] dy={0,1,0,-1};
        int sx=0,sy=0;
        
        for(int i=0;i<park.length;i++){
            for(int j=0;j<park[0].length();j++){
                if(park[i].charAt(j)=='S'){
                    sx=i;
                    sy=j;
                }else if(park[i].charAt(j)=='X'){
                    board[i][j]=1;
                    continue;
                }
                board[i][j]=0;
            }
        }
    
        for(int i=0;i<routes.length;i++){
            StringTokenizer st=new StringTokenizer(routes[i]);
            
            String dir = st.nextToken();
            int cnt=Integer.parseInt(st.nextToken());
            int d = calcDirect(dir);
            
            int tx=sx;
            int ty=sy;
            for(int j=0;j<cnt;j++){
                int nx=tx+dx[d];
                int ny=ty+dy[d];
                if(nx<0||ny<0||nx>=N||ny>=M||board[nx][ny]==1){
                    tx=sx;
                    ty=sy;
                    break;
                }
                tx=nx;
                ty=ny;
            }
            sx=tx;
            sy=ty;
        }
        
        return new int[]{sx,sy};
    }
    
    public int calcDirect(String dir){
        switch(dir){
            case "N":
                return 0;
            case "E":
                return 1;
            case "S":
                return 2;
            default:
                return 3;
        }
    }
}
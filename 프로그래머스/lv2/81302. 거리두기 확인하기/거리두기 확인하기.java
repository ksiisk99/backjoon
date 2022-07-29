import java.util.*;
class Solution {
    static int[] dx={0,0,1,-1};
    static int[] dy={1,-1,0,0};
    static boolean[][] visit=new boolean[5][5];
    static boolean check;
    static void dfs(String[] places,int x,int y, int sx,int sy,int cnt){
        visit[x][y]=true;
        for(int i=0;i<4;i++){
            int nx=x+dx[i];
            int ny=y+dy[i];
            if(nx<0 || ny<0 || nx>=5 || ny>=5 || visit[nx][ny])continue;
            if(places[nx].charAt(ny)=='O'){
                dfs(places,nx,ny,sx,sy,cnt+1);
            }
            if(places[nx].charAt(ny)=='P'){
                if(cnt<=2){
                    check=false;
                    return;
                }
            }
        }
        visit[x][y]=false;
    }
    
    public int[] solution(String[][] places) {
        int[] answer = new int[5];
        for(int t=0;t<5;t++){
            check=true;
            for(int i=0;i<5 && check;i++){
                for(int j=0;j<5;j++){
                    if(places[t][i].charAt(j)=='P'){
                        initVisit();
                        visit[i][j]=true;
                        dfs(places[t], i, j,i ,j,1);
                        if(!check){
                            answer[t]=0;
                            break;
                        }
                    }
                }
            }
            if(check)answer[t]=1;
        }
        return answer;
    }
    
    static void initVisit(){
        for(int i=0;i<5;i++){
            for(int j=0;j<5;j++){
                visit[i][j]=false;
            }
        }
    }
}
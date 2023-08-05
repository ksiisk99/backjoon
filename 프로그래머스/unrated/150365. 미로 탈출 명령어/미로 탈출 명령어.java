import java.util.*;

class Solution {
    private int[] dx={1,0,0,-1};
    private int[] dy={0,-1,1,0};
    private String answer = "impossible";
    private boolean flag = false;
    private int n,m,r,c,k;
    
    void dfs(int x,int y,int cnt, StringBuilder sb) {
        if(flag)return;
        
        int dist = (k-cnt-calcDist(x,y,r,c));
        if(dist<0){
            return;
        }
        
        if(dist%2==1){
            return;
        }
        
        if(cnt==k){
            if(x==r && y==c){
                answer=sb.toString();
                flag=true;  
            }
            return;
        }
        
        for(int i=0;i<4;i++){
            int nx=x+dx[i];
            int ny=y+dy[i];
            if(nx<=0 || ny<=0 || nx>n || ny>m || flag) {
                continue;
            }
            sb.append(calcDir(i));
            dfs(nx,ny, cnt+1, sb);
            sb.deleteCharAt(cnt);
        }
        
    }
    
    
    public String solution(int _n, int _m, int x, int y, int _r, int _c, int _k) {
        n=_n;
        m=_m;
        r=_r;
        c=_c;
        k=_k;
        dfs(x,y,0, new StringBuilder());
        return answer;
    }
    
    private int calcDist(int x, int y,int r,int c){
        return Math.abs(x-r) + Math.abs(y-c);
    }
    
    private String calcDir(int dir){
        switch(dir){
            case 0:
                return "d";
            case 1:
                return "l";
            case 2:
                return "r";
            default:
                return "u";
        }
    }
}
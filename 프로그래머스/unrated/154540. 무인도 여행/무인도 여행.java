import java.util.*;

class Solution {
    static int[] dx={0,0,-1,1};
    static int[] dy={1,-1,0,0};
    static boolean[][] visit;
    static int N,M;
    
    public int[] solution(String[] maps) {
        init(maps);
        
        List<Integer>answer=new ArrayList<>();
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(maps[i].charAt(j)!='X' && !visit[i][j]){
                    answer.add(dfs(maps,i,j));
                }
            }
        }
        
        if(answer.size()==0){
            return new int[]{-1};
        }
        
        Collections.sort(answer);
        return answer.stream()
            .mapToInt(i->i)
            .toArray();
    }
    
    int dfs(String[] maps, int x,int y){
        int result=maps[x].charAt(y)-'0';
        visit[x][y]=true;
        
        for(int i=0;i<4;i++){
            int nx=x+dx[i];
            int ny=y+dy[i];
            
            if(nx<0||ny<0||nx>=N ||ny>=M || visit[nx][ny] || maps[nx].charAt(ny)=='X'){
                continue;
            }
            result+=dfs(maps, nx,ny);
        }
        return result;
    }
    
    void init(String[] maps){
        N=maps.length;
        M=maps[0].length();
        visit=new boolean[N][M];
    }
}
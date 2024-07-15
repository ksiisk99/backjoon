import java.util.*;

class Solution {
    static boolean[] isNum, vistedPermutation;
    static int[] dx={1,-1,0,0};
    static int[] dy={0,0,1,-1};
    static int size;
    static int answer;
    
    static class Point{
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    
    public int solution(int[][] board, int r, int c) {
        answer = Integer.MAX_VALUE;
        isNum = new boolean[7];
        vistedPermutation = new boolean[7];
        
               for(int i=0; i<4; i++) {
            for(int j=0; j<4; j++) {
                if(board[i][j] == 0 || isNum[board[i][j]]) continue;
                isNum[board[i][j]] = true;
                size++;
            }
        }
        
        permutation(0,new int[size], board, r, c);
        
        return answer;
    }
    
    static void bfs(int[][] board, int[] arr, int r, int c){
        Queue<Point> q = new LinkedList<>();
        boolean[][] visited = new boolean[4][4];
        boolean[][] enter = new boolean[4][4];
        
        int cnt=0;
        int answerCnt = 0;
        int idx=0;
        boolean isSecond = false;
        
        q.add(new Point(r,c));
        visited[r][c]=true;
        
        while(!q.isEmpty()) {
            int len = q.size();
            
            for(int l=0;l<len;l++){
                Point now = q.poll();
                if(board[now.x][now.y] == arr[idx] && !enter[now.x][now.y]) {
                    answerCnt++;
                    answerCnt+=cnt;
                    cnt = -1;
                    enter[now.x][now.y]=true;
                    
                    q.clear();
                    visited=new boolean[4][4];
                    
                    q.add(new Point(now.x,now.y));
                    visited[now.x][now.y]=true;
                    
                    if(!isSecond) {
                        isSecond = true;
                    } else{
                        isSecond = false;
                        idx++;
                        
                        if(idx>=arr.length) {
                            answer = Math.min(answer, answerCnt);
                            return;
                        }
                    }
                    break;
                }
                
                for(int i=0;i<4;i++){
                    int nx=now.x+dx[i];
                    int ny=now.y+dy[i];

                    if(0>nx || nx>=4 || 0>ny || ny>=4) continue;
                    visited[nx][ny]=true;
                    q.add(new Point(nx,ny));
                }

                for(int i=0;i<4;i++){
                    int nx=now.x;
                    int ny=now.y;

                    while(0<=(nx+dx[i]) && (nx+dx[i])<4 && 0<=(ny+dy[i]) && (ny+dy[i])<4) {
                        nx+=dx[i];
                        ny+=dy[i];

                        if(!enter[nx][ny] && board[nx][ny] !=0) break;
                    }

                    if(!(0<=nx && nx<4 && 0<=ny && ny<4) || visited[nx][ny]) continue;
                    visited[nx][ny]=true;
                    q.add(new Point(nx,ny));
                }
            }
            cnt++;
        }
    }
    
    static void permutation(int cnt, int[] arr, int[][] board, int r, int c) {
        if(size == cnt) {
            bfs(board, arr, r, c);
            return;
        }
        
        for(int i=1;i<=6;i++){
            if(!isNum[i] || vistedPermutation[i]) continue;
            vistedPermutation[i]=true;
            arr[cnt]=i;
            permutation(cnt+1, arr, board, r, c);
            vistedPermutation[i] = false;
        }
    }
}
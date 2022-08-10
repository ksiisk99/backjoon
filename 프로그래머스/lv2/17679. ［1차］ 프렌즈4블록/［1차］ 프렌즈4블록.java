class Solution {
    public int solution(int m, int n, String[] board) {
        int answer = 0;
        int N=board.length;
        int M=board[0].length();
        int[][] intBoard=new int[N][M];
        
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                intBoard[i][j]=board[i].charAt(j)-'0';
            }
        }
               
        int cnt;
        do{
            cnt=0;
            boolean[][] visit=new boolean[N][M];
            for(int i=0;i<N-1;i++){
                for(int j=0;j<M-1;j++){
                    int c=intBoard[i][j];
                    if(c==0)continue;
                    if(c==intBoard[i][j+1] && c==intBoard[i+1][j] && c==intBoard[i+1][j+1]){
                        visit[i][j]=true;
                        visit[i][j+1]=true;
                        visit[i+1][j]=true;
                        visit[i+1][j+1]=true;
                    }
                }
            }
            
            int x=N-1;
            int y=0;
            while(true){
                if(visit[x][y]){
                    cnt++;
                    intBoard[x][y]=0;
                }
                else{
                    int tmp=x;
                    while(tmp!=(N-1)){
                        if(visit[tmp+1][y] || intBoard[tmp+1][y]==0){
                            intBoard[tmp+1][y]=intBoard[tmp][y];
                            intBoard[tmp][y]=0;
                            visit[tmp+1][y]=false;
                        }else break;
                        tmp++;
                    }
                }
                y++;
                if(x==0 && y==M)break;
                if(y==M){
                    y=0;
                    x--;
                }
            }
            
            answer+=cnt;
        }while(cnt!=0);
                    
                       
        return answer;
    }
}
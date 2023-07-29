class Solution {
    public int solution(int[][] board, int[][] skill) {
        int answer = 0;
        int N = board.length;
        int M = board[0].length;
        int[][] sum = new int[N+1][M+1];
        
        for(int[] s: skill) {
            int type = s[0];
            int r1=s[1];
            int c1=s[2];
            int r2=s[3];
            int c2=s[4];
            int degree= (type==1?-s[5]:s[5]);
            
            sum[r1][c1]+=degree;
            sum[r1][c2+1]+=-degree;
            sum[r2+1][c1]+=-degree;
            sum[r2+1][c2+1]+=degree;
        }
        
        for(int i=0;i<=M;i++){
            for(int j=1;j<=N;j++){
                sum[j][i]+=sum[j-1][i];
            }
        }
        
        for(int i=0;i<=N;i++){
            for(int j=1;j<=M;j++){
                sum[i][j]+=sum[i][j-1];
            }
        }
        
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                board[i][j]+=sum[i][j];
                if(board[i][j]>0)answer++;
            }
        }
        
        return answer;
    }
}
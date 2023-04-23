class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int[][] dp=new int[n+1][m+1];
        int MOD = 1_000_000_007;
        boolean[][] visit=new boolean[n+1][m+1];
        
        for(int[] puddle: puddles){
            visit[puddle[1]][puddle[0]]=true;
        }
        
        dp[1][1]=1;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(visit[i][j]){
                    continue;
                }
                dp[i][j]+=(dp[i][j-1]+dp[i-1][j]%MOD)%MOD;
                
            }
        }
        
        return dp[n][m];
    }
}
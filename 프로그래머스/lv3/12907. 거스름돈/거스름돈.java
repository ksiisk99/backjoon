class Solution {
    public int solution(int n, int[] money) {
        int[][] dp=new int[money.length+1][n+1];
        int MOD = 1_000_000_007;
        
        for(int i=1;i<=money.length;i++){
            for(int j=0;j<=n;j++){
                if(j==0){
                    dp[i][j]=1;
                    continue;
                }
                
                int m = money[i-1];
                if(j>=m) {
                    dp[i][j]= (dp[i-1][j] + dp[i][j-m]) % MOD;
                } else{
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        
        return dp[money.length][n];
    }
}
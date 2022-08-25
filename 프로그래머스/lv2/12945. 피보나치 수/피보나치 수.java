class Solution {
    public int solution(int n) {
        long[] dp=new long[n+1];
        dp[1]=1;
        for(int i=2;i<=n;i++){
            dp[i]=(dp[i-1]+dp[i-2])%1234567;
            //dp[i]%=1234567;
        }
        return (int)dp[n];
    }
}
class Solution {
    public int solution(int n) {
        long[] dp=new long[n+1];
        dp[1]=1;
        dp[2]=2;
        dp[3]=3;
        for(int i=4;i<=n;i++){
            dp[i]=(dp[i-1]+dp[i-2])%1000000007L;
        }
        return (int)dp[n]%1000000007;
    }
}
class Solution {
    public int solution(int sticker[]) {
        if(sticker.length<=2){
            return Math.max(sticker[0],sticker[sticker.length-1]);
        }
        
        int[] dp=new int[sticker.length-1];
        int[] dp2=new int[sticker.length];
        
        dp[0]=sticker[0];
        dp[1]=sticker[0];
        for(int i=2;i<sticker.length-1;i++){
            dp[i]=Math.max(dp[i-1],dp[i-2]+sticker[i]);
        }

        dp2[1]=dp2[0]+sticker[1];
        for(int i=2;i<sticker.length;i++){
            dp2[i]=Math.max(dp2[i-1],dp2[i-2]+sticker[i]);
        }
        
        return Math.max(dp[sticker.length-2],dp2[sticker.length-1]);
    }
}
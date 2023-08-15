class Solution {
    public int solution(int alp, int cop, int[][] problems) {
        int goalAlp = 0;
        int goalCop = 0;
        for(int[] problem: problems) {
            goalAlp = Math.max(goalAlp, problem[0]);
            goalCop = Math.max(goalCop, problem[1]);
        }
        if(goalAlp <= alp && goalCop <= cop) return 0;
        
        alp=Math.min(alp, goalAlp);
        cop=Math.min(cop,goalCop);
        
        int[][] dp = new int[goalAlp+1][goalCop+1];
        for(int i=0;i<=goalAlp;i++) {
            for(int j=0;j<=goalCop;j++){
                dp[i][j]= 10_000_000;
            }
        }
        
        dp[alp][cop] = 0;
        
        for(int i=alp; i<=goalAlp; i++){
            for(int j=cop; j<=goalCop; j++) {
                if(i+1 <= goalAlp) {
                    dp[i+1][j] = Math.min(dp[i+1][j], dp[i][j]+1);
                }
                
                if(j+1<=goalCop) {
                    dp[i][j+1] = Math.min(dp[i][j+1], dp[i][j]+1);
                }
                
                for(int[] problem: problems) {
                    if(problem[0] <= i && problem[1] <= j){
                        int nextAlp = Math.min(goalAlp, i+problem[2]);
                        int nextCop = Math.min(goalCop, j+problem[3]);
                        dp[nextAlp][nextCop] = Math.min(dp[nextAlp][nextCop], dp[i][j]+problem[4]);
                    }
                }
            }
        }
        return dp[goalAlp][goalCop];
    }
}
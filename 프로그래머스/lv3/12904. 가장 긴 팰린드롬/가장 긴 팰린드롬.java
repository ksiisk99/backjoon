class Solution
{
    public int solution(String s)
    {
        int answer=1;
        boolean[][] dp=new boolean[s.length()][s.length()];
        for(int i=0;i<s.length();i++){
            dp[i][i]=true;
            if(i==(s.length()-1)){
                break;
            }
            if(s.charAt(i)==s.charAt(i+1)){
                dp[i][i+1]=true;
                answer=2;
            }
        }
        
        for(int len=3; len<=s.length(); len++){
            for(int start=0; start<=s.length()-len; start++){
                int end=start+len-1;
                
                if(s.charAt(start)==s.charAt(end)
                  && dp[start+1][end-1]){
                    dp[start][end]=true;
                    answer=len;
                }
            }
        }
        return answer;
    }
}
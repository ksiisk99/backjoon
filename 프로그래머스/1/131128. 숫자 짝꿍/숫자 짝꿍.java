import java.util.stream.*;

class Solution {
    public String solution(String X, String Y) {
        int[] xCnt=new int[10];
        int[] yCnt=new int[10];
        
        X.chars()
            .forEach(i->xCnt[i-'0']++);
        Y.chars()
            .forEach(i->yCnt[i-'0']++);
        
        StringBuilder sb=new StringBuilder();
        for(int i=9;i>=0;i--){
            int cnt=Math.min(xCnt[i],yCnt[i]);
            if(i==0 && cnt>0 && sb.length()==0){
                sb.append("0");
                break;
            }
            
            for(int j=0;j<cnt;j++)sb.append(String.valueOf(i));
        }
        
        
        return sb.length()==0?"-1":sb.toString();
    }
}
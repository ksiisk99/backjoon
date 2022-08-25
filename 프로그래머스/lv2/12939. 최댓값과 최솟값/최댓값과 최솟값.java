import java.util.*;
class Solution {
    public String solution(String s) {
        Long MAX=Long.MIN_VALUE;
        Long MIN=Long.MAX_VALUE;
        StringTokenizer st=new StringTokenizer(s);
        while(st.hasMoreTokens()){
            String t=st.nextToken();
            MAX=Math.max(MAX,Long.parseLong(t));
            MIN=Math.min(MIN,Long.parseLong(t));
        }
        
        return String.valueOf(MIN)+" "+String.valueOf(MAX);
    }
}
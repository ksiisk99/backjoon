import java.util.*;

class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        int pSize = p.length();
        int tSize = t.length();
        Long pNum = Long.parseLong(p);
       
        for(int i=0;i<=tSize-pSize;i++){
            if(Long.parseLong(t.substring(i,i+pSize))<=pNum){
                answer++;
            }
        }
        return answer;
    }
}
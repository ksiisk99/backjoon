import java.util.*;

class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        int[] check = new int[26];
        Arrays.fill(check,-1);
        
        for(int i=0;i<s.length();i++){
            int idx=s.charAt(i)-'a';
            int result = -1;
            if(check[idx]!=-1){
                result=i-check[idx];
            }
            check[idx]=i;
            answer[i]=result;
        }
        return answer;
    }
}
import java.util.*;
class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        Arrays.sort(citations);
        int MAX=citations[citations.length-1];
        for(int i=(citations.length-1)/2;i>=0;i--){
            for(int j=MAX;j>=0;j--){
                if(j<=citations[i] && j<=(citations.length-i) && j>=(i+1))
                    answer=Math.max(answer,j);
            }
        }
        return answer;
    }
}
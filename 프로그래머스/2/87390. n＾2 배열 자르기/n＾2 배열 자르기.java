import java.util.*;

class Solution {
    public int[] solution(int n, long left, long right) {
        int[] answer=new int[(int)(right-left)+1];
        int idx=0;
        long N=(int)n;
        while(left<=right){
            answer[idx++]=(int)(Math.max((left/N),(left++%N)))+1;
        }
        return answer;
    }
}
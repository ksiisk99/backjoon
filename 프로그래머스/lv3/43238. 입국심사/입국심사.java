import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        Arrays.sort(times);
        
        long left = times[0];
        long right = times[times.length-1]*(long)n;
        long answer = 0;
        while(left<=right){
            long mid = (left+right)/2;
            
            long sum = 0;
            for(int i=0;i<times.length;i++){
                sum+=mid/(long)times[i];
            }
            
            if(sum>=n){
                answer = mid;
                right = mid - 1L;
            }else{
                left = mid + 1L;
            }
        }
        
        return answer;
    }
}
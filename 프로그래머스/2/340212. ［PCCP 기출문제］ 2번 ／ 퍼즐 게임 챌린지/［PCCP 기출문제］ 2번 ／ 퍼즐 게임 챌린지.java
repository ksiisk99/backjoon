class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int answer = 100000;
        int left=1, right=100000;
        
        while(left<=right) {
            int skill=(left+right)/2;
            
            long finishTime = calculateTime(diffs, times, limit, skill);
            
            if(finishTime<=limit) {
                right = skill - 1;
                answer = Math.min(answer, skill);
            } else {
                left = skill+1;
            }
        }
        
        return answer;
    }
    
    private long calculateTime(int[] diffs, int[] times, long limit, int skill) {
        long result = 0L;
        
        for(int i=0;i<diffs.length && result<=limit;i++){
            int diff=diffs[i];
            int time=times[i];
            
            if(skill<diff && i>0) {
                result += (((long)times[i-1] + time) * (diff-skill));
            }
            
            result += (long)time;
        }
        
        return result;
    }
}

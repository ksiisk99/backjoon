
class Solution {
    public int solution(int n, int[] cores) {
        int answer = 0;
        int left = 0;
        int right = cores[cores.length-1] * n;
        int time = 0;
        int job = 0;
        
        while(left<=right) {
            int mid = (left+right) / 2;
            
            int cnt = process(mid, cores);
            
            if(cnt>=n) {
                right = mid - 1;
                time = mid;
                job = cnt;
            } else {
                left = mid+1;
            }
        }
        
        job-=n;
        for(int i=cores.length-1;i>=0;i--){
            if(time % cores[i] == 0) {
                if(job == 0){
                    answer = i+1;
                    break;
                }
                job--;
            }
        }
        
        return answer;
    }
    
    public int process(int time, int[] cores) {
        if(time == 0){
            return cores.length;
        }
        int count = cores.length;
        
        for(int i=0;i<cores.length;i++){
            count+=(time/cores[i]);
        }
        return count;
    }
}
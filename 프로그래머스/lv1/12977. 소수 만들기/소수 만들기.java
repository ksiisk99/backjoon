class Solution {
    
    
    public int combination(int[] nums,int n,int cnt,int sum){
        int answer=0;
        if(cnt==3){
            if(isPrime(sum))answer++;
            return answer;
        }
        
        for(int i=n;i<nums.length;i++){
            answer+=combination(nums,i+1,cnt+1,sum+nums[i]);
        }
        return answer;
    }
    
    public int solution(int[] nums) {
        return combination(nums,0,0,0);
    }
    
    public boolean isPrime(int num){
        for(int i=2;i<=Math.sqrt(num);i++){
            if(num%i==0)return false;
        }
        return true;
    }
}
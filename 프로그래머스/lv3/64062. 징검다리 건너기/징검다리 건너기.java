class Solution {
    
    public int solution(int[] stones, int k) {
        int answer = 0;        
        int end=Integer.MAX_VALUE;
        int start=0;
        
        while(start<=end){
            int mid=(start+end)/2;
            System.out.println(mid);
            if(check(mid, k, stones)){
                answer=mid;
                start=mid+1;
                
            }else{
                end=mid-1;
            }
        }
        return answer;
    }
    
    boolean check(int mid, int k ,int[] stones){
        int cnt=0;
        for(int i=0;i<stones.length;i++){
            if(stones[i]<mid){
                cnt++;
                if(cnt==k)return false;
            }else{
                cnt=0;
            }
        }
        return true;
    }
}
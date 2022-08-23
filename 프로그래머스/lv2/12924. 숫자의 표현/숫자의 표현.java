class Solution {
    public int solution(int n) {
        int answer = 1;
        int sum=0;
        for(int s=1,e=1;e<=n;){
            if(sum==n){
                answer++;
                sum-=s;
                s++;
            }else if(sum>n){
                sum-=s;
                s++;
            }else{
                sum+=e;
                e++;
            }            
        }
        return answer;
    }
}
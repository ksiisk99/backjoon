class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = {Integer.MAX_VALUE,Integer.MAX_VALUE};
        
        int MIN=Integer.MAX_VALUE;
        int head=0,tail=0;
        int sum=0;
        int size=sequence.length;
        while(head<size){
            if(sum==k){
                if(MIN>(tail-head) || ((MIN==(tail-head) && answer[0]>head))){
                    answer[0]=head;
                    answer[1]=tail-1;
                    MIN=tail-head;
                }
            }
            
            if(sum>k || size==tail){
                sum-=sequence[head++];
            }else{
                sum+=sequence[tail++];
            }
        }
        return answer;
    }
}
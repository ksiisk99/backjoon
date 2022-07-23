import java.util.*;
class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Long> pq=new PriorityQueue<Long>();
        for(int i=0;i<scoville.length;i++){
            pq.add((long)scoville[i]);
        }
        boolean check=false;
        while(pq.size()>1){
            long num=pq.poll();
            long num2=pq.poll();
            long sum=num+(num2*2);
            answer++;
            if(sum<K){ 
                pq.add(sum);
            }else if(!pq.isEmpty()){
                if(pq.peek()<K){
                    pq.add(sum);
                    continue;
                }
                check=true;
                break;
            }else{
                check=true;
                break;
            }
        }
        if(check)return answer;
        return -1;
    }
}
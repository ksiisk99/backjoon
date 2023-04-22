import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        PriorityQueue<Integer>pq = new PriorityQueue<>(new Comparator<>(){

            @Override
            public int compare(Integer a, Integer b){
                return b-a;
            }
        });
        Arrays.stream(works)
            .forEach(i->pq.add(i));
        
        while(n>0 && !pq.isEmpty()){
            int num=pq.poll()-1;
            n--;
            if(num!=0) {
                pq.add(num);
            }
        }
        
        while(!pq.isEmpty()){
            answer+=(pq.peek()*pq.poll());
        }
        
        return answer;
    }
}
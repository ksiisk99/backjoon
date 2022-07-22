import java.util.*;
class Solution {
    
    
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer>queue=new LinkedList<>();
        for(int i=0;i<progresses.length;i++){
            queue.add((int)Math.ceil(((double)(100-progresses[i])/speeds[i])));
        }
        List<Integer>answer=new ArrayList<>();
        while(!queue.isEmpty()){
            int day=queue.poll();
            int cnt=1;
            while(!queue.isEmpty()){
                if(queue.peek()<=day){
                    cnt++;
                }else break;
                queue.poll();
            }
            answer.add(cnt);
        }
        
        return answer.stream().mapToInt(x->x).toArray();
    }
}
import java.util.*;
class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int total=0;
        Queue<Integer>queue=new LinkedList<>();
        for(int i=0;i<truck_weights.length;i++){
            while(true){
                if(queue.isEmpty()){
                    queue.add(truck_weights[i]);
                    total+=truck_weights[i];
                    answer++;
                    break;
                }else if(queue.size()==bridge_length){
                    total-=queue.poll();
                }else{
                    if(total+truck_weights[i]<=weight){
                        queue.add(truck_weights[i]);
                        total+=truck_weights[i];
                        answer++;
                        break;
                    }else{
                        queue.add(0);
                        answer++;
                    }
                }
                
            }
        }
        return answer+bridge_length;
    }
}
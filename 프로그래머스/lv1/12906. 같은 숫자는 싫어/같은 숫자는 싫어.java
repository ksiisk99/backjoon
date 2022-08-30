import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        List<Integer>answer=new ArrayList<>();
        Deque<Integer>deque=new LinkedList<>();
        
        for(int num:arr){
            if(deque.isEmpty() || deque.peekLast()!=num){
                deque.addLast(num);
            }
        }
        
        while(!deque.isEmpty()){
            answer.add(deque.pollFirst());
        }
        
        return answer.stream()
            .mapToInt(i->i)
            .toArray();
    }
}
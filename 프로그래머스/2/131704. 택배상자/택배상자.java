import java.util.*;

class Solution {
    public int solution(int[] order) {
        int answer = 0;

        Stack<Integer>stack=new Stack<>();
        int box=1;
        int idx=0;
        for(;box<=order.length && idx<order.length; box++){
            if(order[idx]==box){
                answer++;
                idx++;
            }else{
                if(!stack.isEmpty() && stack.peek()==order[idx]){
                    stack.pop();
                    idx++;
                    answer++;
                    box--;
                }else
                    stack.push(box);
            }
        }
        
        
        while(!stack.isEmpty()){
            if(order[idx++]==stack.pop()){
                answer++;
            }else break;
        }
        
        return answer;
    }
}
import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        int[] answer=new int[numbers.length];
        Stack<int[]>stack=new Stack<>();
        
        for(int i=0;i<numbers.length;i++){
            if(stack.isEmpty() || stack.peek()[1]>=numbers[i]){
                stack.push(new int[]{i,numbers[i]});
                continue;
            }
            
            while(!stack.isEmpty()){
                int[] info=stack.pop();
                int idx=info[0];
                int num=info[1];
                
                if(num<numbers[i]){
                    answer[idx]=numbers[i];
                }else{
                    stack.push(new int[]{idx,num});
                    break;
                }
            }
            stack.push(new int[]{i,numbers[i]});
        }
        
        while(!stack.isEmpty()){
            answer[stack.pop()[0]]=-1;
        }
        return answer;
    }
}
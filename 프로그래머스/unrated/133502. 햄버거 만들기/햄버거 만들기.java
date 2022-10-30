import java.util.*;

class Solution {
    public int solution(int[] ingredient) {
        int answer = 0;
        Stack<Integer>stack=new Stack<>();
        
        for(int i=0;i<ingredient.length;i++){
            int n=ingredient[i];
            
            if(n==1){
                if(!stack.isEmpty() && stack.peek()==3){
                    answer++;
                    for(int j=0;j<3;j++)stack.pop();
                }else{
                    stack.push(n);
                }
            }else{
                if(!stack.isEmpty()){
                    if(n-stack.peek()==1)stack.push(n);
                    else{
                        while(!stack.isEmpty()){
                            stack.pop();
                        }
                    }
                }
            }
        }//3~12 실패
        return answer;
    }
}
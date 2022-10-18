import java.util.*;

class Solution {
    static Stack<Integer>stack=new Stack<>();
    
    public int solution(String dartResult) {
        int answer=0;
        String num="";
        
        for(int i=0;i<dartResult.length();i++){
            char c=dartResult.charAt(i);
            if(c>='0' && c<='9'){
                num+=String.valueOf(c);
            }else if(c=='*' || c=='#'){
                answer+=bonus(c);
            }else{
                stack.push(calc(num,c));
                num="";
            }
        }
        
        while(!stack.isEmpty()){
            answer+=stack.pop();
        }
        return answer;
    }
    
    static int bonus(char c){
        int result=0;
        Stack<Integer>tmp=new Stack<>();
        
        int cnt=0;
        if(c=='*'){
            while(!stack.isEmpty()){
                cnt++;
                tmp.push(stack.pop()*2);
                if(cnt==2)break;
            }
        }else{
            stack.push(stack.pop()*(-1));
        }
        
        while(!tmp.isEmpty()){
            stack.push(tmp.pop());
        }
        
        return result;
    }
    
    static int calc(String num,char c){
        if(c=='S'){
            return Integer.parseInt(num);
        }else if(c=='D'){
            return (int)Math.pow(Integer.parseInt(num),2);
        }else{
            return (int)Math.pow(Integer.parseInt(num),3);
        }
    }
}
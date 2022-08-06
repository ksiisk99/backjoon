import java.util.*;
class Solution {
    public int solution(String s) {
        int answer = 0;
        if(isBracket(s))answer++;
        
        for(int i=0;i<s.length()-1;i++){
            String tmp=s.substring(i+1,s.length())+s.substring(0,i+1);
            if(isBracket(tmp))answer++;
        }
        return answer;
    }
    
    boolean isBracket(String s){
        Stack<Character>stack=new Stack<>();
        for(int i=0;i<s.length();i++){
            if(!stack.isEmpty()){
                if(s.charAt(i)=='[' || s.charAt(i)=='{' || s.charAt(i)=='('){
                    stack.push(s.charAt(i));
                }else{
                    if(isEqual(stack.peek(),s.charAt(i))){
                        stack.pop();
                    }else{
                        stack.push(s.charAt(i));
                    }
                }
            }else{
                stack.push(s.charAt(i));
            }
        }
        if(stack.isEmpty())return true;
        return false;
    }
    
    boolean isEqual(char s1, char s2){
        if(s1=='('){
            return s2==')';
        }else if(s1=='['){
            return s2==']';
        }else if(s1=='{'){
            return s2=='}';
        }
        return false;
    }
}
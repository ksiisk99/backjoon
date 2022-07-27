import java.util.*;

class Solution {
    public String solution(String p) {
        return recursive(p);
    }
    
    static String recursive(String p) {
		String answer = "";
        int[] bracket = new int[2];
     
        String u="";
        String v="";
        for(int i=0;i<p.length();i++){
            if(p.charAt(i)=='('){
                bracket[0]++;
            }else{
                bracket[1]++;
            }
            if(bracket[0]==bracket[1]){
                u=p.substring(0,i+1);
                v=p.substring(i+1);
                break;
            }
        }
        
        Stack<Character>stack = new Stack<>();
        stack.push(u.charAt(0));
        for(int i=1;i<u.length();i++){
            if(stack.peek()==u.charAt(i)){
                stack.push(u.charAt(i));
            }else{
                if(stack.peek()=='('){
                    stack.pop();
                }else{
                    stack.push(u.charAt(i));
                }                   
            }
        }
        
        if(stack.isEmpty()){
            answer=u;
            if(v.isEmpty())return answer;
            answer+=recursive(v);
        }else{
            String tmp="(";
            bracket[0]=0;
            bracket[1]=0;
            if(!v.isEmpty())
            	tmp+=recursive(v);
            tmp+=")";
            for(int i=1;i<u.length()-1;i++){
                if(u.charAt(i)=='('){
                    tmp+=")";
                }else{
                    tmp+="(";
                }
            }
            answer+=tmp;
        }
        return answer;
	}
}
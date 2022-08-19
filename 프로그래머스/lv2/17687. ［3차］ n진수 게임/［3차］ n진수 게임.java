import java.util.*;

class Solution {
    public String solution(int n, int t, int m, int p) {
        String answer = "";
        StringBuilder sb=new StringBuilder();
        
        sb.append("0");
        for(int i=0;i<t*m;i++){
            int num=i+1;
            Stack<String>stack=new Stack<>();
            while(num!=0){
                stack.push(alpha(num%n));
                num/=n;
            }
            while(!stack.isEmpty()){
                sb.append(stack.pop());
            }            
        }   
        p--;
        for(int i=0;i<t;i++){
            answer+=String.valueOf(sb.charAt(p));
            p+=m;
        }
        
        return answer;
    }
    
    String alpha(int n){
        switch(n){
            case 10: return"A";
            case 11: return"B"; 
            case 12: return"C"; 
            case 13: return"D"; 
            case 14: return"E"; 
            case 15: return"F";
            default:
                return String.valueOf(n);
        }
    }
}
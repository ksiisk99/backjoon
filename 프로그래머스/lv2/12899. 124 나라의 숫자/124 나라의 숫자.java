import java.util.*;
import java.io.*;

class Solution {
    public String solution(int n) {
        String answer = "";
        Stack<String> stack=new Stack<String>();
        while(n!=0){
            int num=n%3;
            if(num==2){
                stack.push("2");
                n/=3;
            }else if(num==1){
                stack.push("1");
                n/=3;
            }else{
                stack.push("4");
                n=(n-1)/3;
            }
            
        }
        while(!stack.isEmpty()){
            answer+=stack.pop();
        }
        return answer;
    }
}
import java.util.*;

class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        Stack<String>stack=new Stack<>();
        StringBuilder sb=new StringBuilder();
        while(n!=0){
            stack.push(String.valueOf(n%k));
            n/=k;
        }
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }

        String tmp="0";
        for(int i=0;i<sb.length();i++){
            if(sb.charAt(i)!='0'){
                tmp+=String.valueOf(sb.charAt(i));
            }else{
                if(isPrime(Long.parseLong(tmp)))answer++;
                tmp="0";
            }
        }
        if(isPrime(Long.parseLong(tmp)))answer++;

        return answer;
    }

    boolean isPrime(long n){
        if(n==1 || n==0)return false;

        for(long i=2;i<=(long)Math.sqrt(n);i++){
            if(n%i==0)return false;
        }
        return true;
    }
}
import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        Map<Integer,Integer>right= new HashMap<>();
        Map<Integer,Integer>left= new HashMap<>();
        for(int n:topping){
            right.put(n,right.getOrDefault(n,0)+1);
        }
        for(int i=0;i<topping.length;i++){
            int n=right.getOrDefault(topping[i],0);
            if(n!=0){
                if(n-1==0){
                    right.remove(topping[i]);
                }else{
                    right.put(topping[i],n-1);
                }
            }
            left.put(topping[i],left.getOrDefault(topping[i],0)+1);
            
            if(left.size()==right.size()){
                answer++;
            }
        }
        return answer;
    }
}
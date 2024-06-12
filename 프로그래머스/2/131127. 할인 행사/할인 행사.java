import java.util.*;

class Solution {
    static Map<String,Integer>map =new HashMap<>();
    
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        int left=0, right=10;
        init(discount);
        for(;right<discount.length; right++, left++){
            if(checkStock(want,number)){
                answer++;
            }
            map.put(discount[right],map.getOrDefault(discount[right],0)+1);
            map.put(discount[left],map.getOrDefault(discount[left],1)-1);
        }
        if(checkStock(want,number)){
                answer++;
        }
        return answer;
    }
    
    void init(String[] discount){
        for(int i=0;i<10;i++){
            map.put(discount[i],map.getOrDefault(discount[i],0)+1);
        }
    }
    
    boolean checkStock(String[] want, int[] number){
        
        for(int i=0;i<want.length;i++){
            if(map.getOrDefault(want[i],0)!=number[i]){
                return false;
            }
        }
        return true;
    }
}
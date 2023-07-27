import java.util.*;

class Solution {
    Map<String,Integer> enrollIndex = new HashMap<>();
    Map<String, String> enrollReferral = new HashMap<>();
    int[] answer;
    final int PRICE = 100;
    
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        init(enroll, referral);
        
        for(int i=0;i<seller.length;i++){
            String name = seller[i];
            int money = PRICE * amount[i];
            dfs(name, money);
        }
        
        return answer;
    }
    
    void dfs(String name, int money){
        
        int tax = distribute(money);
        money-=tax;
        answer[enrollIndex.get(name)]+=money;
        
        if(tax==0)return;
        
        String parentName = enrollReferral.get(name);
        if(!parentName.equals("-")){
            dfs(parentName, tax);
        }
            
    }
    
    int distribute(int money) {
        return (int)(money * 0.1);
    }
    
    void init(String[] enroll, String[] referral) {
        answer = new int[enroll.length];
        for(int i=0;i<enroll.length;i++){
            enrollIndex.put(enroll[i], i);
            enrollReferral.put(enroll[i], referral[i]);
        }
    }
}
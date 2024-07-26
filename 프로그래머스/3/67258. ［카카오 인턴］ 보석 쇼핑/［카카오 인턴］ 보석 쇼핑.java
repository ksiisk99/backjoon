import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        int[] answer = new int[2];
        Map<String,Integer>map=new HashMap<>();
        for(String gem:gems){
            if(!map.containsKey(gem)){
                map.put(gem,0);
            }
        }
        
        int cnt=0;
        int MIN=Integer.MAX_VALUE;
        int head=0,tail=0;
        
        while(tail<gems.length){
            if(map.size()==cnt){
                if(MIN>(head-tail)){
                    MIN=head-tail;
                    answer[0]=tail+1;
                    answer[1]=head;
                }
                
                int tmp=map.get(gems[tail])-1;
                if(tmp==0){
                    cnt--;
                }
                map.put(gems[tail++], tmp);

            }else{
                if(head<=(gems.length-1)){
                    int tmp=map.get(gems[head]);
                    if(tmp==0){
                        cnt++;
                    }

                    map.put(gems[head++], tmp+1);
                }else{
                    int tmp=map.get(gems[tail]);
                    if(tmp==0){
                        cnt--;
                    }

                    map.put(gems[tail++], tmp+1);
                }
            }
            
        }
        
        return answer;
    }
}
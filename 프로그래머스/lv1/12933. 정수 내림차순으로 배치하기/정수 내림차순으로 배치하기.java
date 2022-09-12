import java.util.*;

class Solution {
    public long solution(long n) {
        long answer = 0;
        List<Long> list=new ArrayList<>();
        while(n!=0){
            list.add(n%10);
            n/=10;
        }
        Collections.sort(list,Collections.reverseOrder());
        
        int size=list.size();
        for(int i=0;i<size;i++){
            answer*=10;
            answer+=list.get(i);
        }
        return answer;
    }
}
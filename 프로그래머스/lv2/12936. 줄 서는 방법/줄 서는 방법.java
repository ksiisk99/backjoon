import java.util.*;

class Solution {
  
    public int[] solution(int n, long k) {
        List<Integer>list=new ArrayList<>();
        long fn=1;
        int[] ans=new int[n];
        for(int i=1;i<=n;i++){
            list.add(i);
            fn*=i;
        }
        k--;
        
        int idx=0;
        while(n>0){
            fn/=n;
            ans[idx++]=list.get((int)(k/fn));
            list.remove((int)(k/fn));
            k%=fn;
            n--;
        }
        return ans;
    }
}
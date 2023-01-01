import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        Arrays.sort(tangerine);
        Map<Integer,Integer>map = new HashMap<>();
        
        for(int n:tangerine){
            map.put(n,map.getOrDefault(n,0)+1);
        }
        
        List<Integer>list = new ArrayList<>(map.keySet());
        
        list.sort((o1,o2)->{return map.get(o2).compareTo(map.get(o1));});
        
        for(int n:list){
            k-=map.get(n);
            answer++;
            if(k<=0)break;
        }
        return answer;
    }
}
//  3  5 4 5
// 1 2 2 3 3 4 5 5
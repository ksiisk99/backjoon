import java.util.*;
class Solution {
    
    public int solution(String[][] clothes) {
        Map<String,Integer>map=new HashMap<>();
        for(int i=0;i<clothes.length;i++){
            if(map.containsKey(clothes[i][1])){
                map.put(clothes[i][1],map.get(clothes[i][1])+1);                
            }else{
                map.put(clothes[i][1],1);
            }
        }
        int answer=1;
        int comb=0;
        Set<String>select=new HashSet<>();
        for(int i=0;i<clothes.length;i++){
            if(!select.contains(clothes[i][1])){
                comb=combination(map.get(clothes[i][1]),1);
                comb+=combination(map.get(clothes[i][1]),0);
                select.add(clothes[i][1]);
            }else continue;
            answer*=comb;
        }
        return answer-1;
    }
    
    int combination(int n,int r){
        if(n==r || r==0)return 1;
        return combination(n-1,r-1)+combination(n-1,r);
    }
}
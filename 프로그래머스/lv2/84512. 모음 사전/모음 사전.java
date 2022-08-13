import java.util.*;
class Solution {
    static List<String>list=new ArrayList<>();
    static String[] alphabet={"A","E","I","O","U"};
    
    static void dfs(String word,int cnt){
        if(cnt==5){
            list.add(word);
            return;
        }
        if(cnt!=0)list.add(word);
        
        for(int i=0;i<5;i++){
            dfs(word+alphabet[i],cnt+1);
        }
    }
    public int solution(String word) {
        dfs("",0);
        return list.indexOf(word)+1;
    }
}
import java.util.*;

class Solution {
    int N;
    Set<Set<String>>result;
    
    void dfs(String[] user_id, String[] banned_id, Set<String>set){
        if(set.size()==N && isBanned(banned_id, set)){
            result.add(new HashSet<>(set));
            return;
        }
        
        for(String userId:user_id){
            if(!set.contains(userId)){
                set.add(userId);
                dfs(user_id,banned_id,set);
                set.remove(userId);
            }
        }
    }
    
    boolean isBanned(String[] banned_id, Set<String> set){
        int idx=0;
        for(String id:set){
            if(!isSame(id, banned_id[idx++])){
                return false;
            }
        }
        return true;
    }
    
    boolean isSame(String user, String banId){
        if(user.length()!=banId.length()){
            return false;
        }
        
        for(int i=0;i<user.length();i++){
            if(user.charAt(i)!=banId.charAt(i) && banId.charAt(i)!='*'){
                return false;
            }
        }
        return true;
    }
    
    public int solution(String[] user_id, String[] banned_id) {
        N=banned_id.length;
        result=new HashSet<>();
        
        dfs(user_id,banned_id,new LinkedHashSet<>());
        return result.size();
    }
}
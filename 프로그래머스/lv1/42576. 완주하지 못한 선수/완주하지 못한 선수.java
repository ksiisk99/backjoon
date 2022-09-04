import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        Map<String,Integer>map=new HashMap<>();
        Map<String,Integer>map2=new HashMap<>();
        
        for(String name:participant){
            if(map.containsKey(name)){
                map.put(name,map.get(name)+1);
            }else{
                map.put(name,1);
            }
        }
        
        for(String name:completion){
            if(map2.containsKey(name)){
                map2.put(name,map2.get(name)+1);
            }else{
                map2.put(name,1);
            }
        }
             
        for(String name:map.keySet()){
            if(!map2.containsKey(name))return name;
            int cnt=map.get(name);
            if(cnt!=1 &&cnt>map2.get(name))return name;
        }
        return "";
    }
}
import java.util.*;

class Solution {
    public int[] solution(String msg) {
        int[] answer = {};
        List<Integer>list=new ArrayList<>();
        int length=27;
        Map<String,Integer>map=new HashMap<>();
        for(int i=0;i<26;i++){
            map.put(String.valueOf((char)('A'+i)),i+1);
        }
        
        int i;
        for(i=0;i<msg.length();){
            String tmp="";
            for(int j=i;j<msg.length();j++){
                if(map.containsKey(tmp+String.valueOf(msg.charAt(j)))){
                    tmp+=String.valueOf(msg.charAt(j));
                    if(j==msg.length()-1){
                        list.add(map.get(tmp));
                        i=j+1;
                    }
                }else{
                    list.add(map.get(tmp));
                    map.put(tmp+String.valueOf(msg.charAt(j)),length++);
                    i=j;
                    break;
                }
            }
        }
        
        return list.stream()
            .mapToInt(n->n)
            .toArray();
    }
}
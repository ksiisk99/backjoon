import java.util.*;

class Solution {
    static final Map<String,Integer> PRONUNCIATION=new HashMap<>();
    
    public int solution(String[] babbling) {
        int answer=0;
        PRONUNCIATION.put("aya",0);
        PRONUNCIATION.put("ye",1);
        PRONUNCIATION.put("woo",2);
        PRONUNCIATION.put("ma",3);
        
        for(String s:babbling){
            String tmp="";
            int before=-1;
            int i=0;
            for(;i<s.length();i++){
                tmp+=String.valueOf(s.charAt(i));
                
                if(!PRONUNCIATION.containsKey(tmp) && tmp.length()>2)break;
                else if(PRONUNCIATION.containsKey(tmp)){
                    int current = PRONUNCIATION.get(tmp);
                    if(before != current){
                        before=current;
                        tmp="";
                    }else{
                        break;
                    }
                }
                
            }
            
            if(i==s.length() && tmp.equals(""))answer++;
        }
        return answer;
    }
}
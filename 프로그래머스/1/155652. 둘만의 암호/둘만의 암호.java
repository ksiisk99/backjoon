import java.util.*;

class Solution {
    public String solution(String s, String skip, int index) {
        boolean[] alphabet=new boolean[26];
        skip.chars()
            .forEach(i->alphabet[i-'a']=true);
        
        String result="";
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            int idx=0;
            int tmp=1;
            while(idx<index){
                c++;
                
                if(c<='z' && !alphabet[c-'a']){
                    idx++;
                }else if(c>'z'){
                    if(!alphabet[0]){
                        idx++;
                    }
                    c='a';
                }
            }
        
            result+=String.valueOf(c);
        }
        return result;
    }
}
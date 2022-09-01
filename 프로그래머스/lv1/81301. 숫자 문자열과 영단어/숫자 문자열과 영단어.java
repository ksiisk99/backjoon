import java.util.*;
class Solution {
    public int solution(String s) {
        StringBuilder sb=new StringBuilder();
        Map<String,String>words=new HashMap<>();
        words.put("zero","0");
        words.put("one","1");
        words.put("two","2");
        words.put("three","3");
        words.put("four","4");
        words.put("five","5");
        words.put("six","6");
        words.put("seven","7");
        words.put("eight","8");
        words.put("nine","9");
        String tmp="";
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)>='0' && s.charAt(i)<='9'){
                if(!tmp.isEmpty())sb.append(words.get(tmp));
                tmp="";
                sb.append(String.valueOf(s.charAt(i)));        
            }
            else{
                if(words.containsKey(tmp)){
                    sb.append(words.get(tmp));
                    tmp="";
                }
                tmp+=String.valueOf(s.charAt(i));
            }
        }
        if(!tmp.isEmpty())sb.append(words.get(tmp));
        return Integer.parseInt(sb.toString());
    }
}
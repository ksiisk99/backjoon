import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        Map<String,Boolean>map=new HashMap<>();
        for(int i=0;i<phone_book.length;i++){
            String tmp="";
            for(int j=0;j<phone_book[i].length();j++){
                tmp+=phone_book[i].substring(j,j+1);
                if(map.containsKey(tmp)){
                    return false;
                }
            }
            map.put(phone_book[i],true);
        }
        map.clear();
        for(int i=phone_book.length-1;i>=0;i--){
            String tmp="";
            for(int j=0;j<phone_book[i].length();j++){
                tmp+=phone_book[i].substring(j,j+1);
                if(map.containsKey(tmp)){
                    return false;
                }
            }
            map.put(phone_book[i],true);
        }
        return true;
    }
}
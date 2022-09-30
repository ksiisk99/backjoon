import java.util.stream.*;
import java.util.*;

class Solution {
    static int length;
    public int solution(int n) {
        List<Integer>list=new ArrayList<>();
     
        while(n>0){
            list.add(n%3);
            n/=3;
        }
        
        length=(int)Math.pow(3,list.size()-1);
        int answer=0;
        for(int num:list){
            answer+=num*length;
                length/=3;
        }
        return answer;
    }
}
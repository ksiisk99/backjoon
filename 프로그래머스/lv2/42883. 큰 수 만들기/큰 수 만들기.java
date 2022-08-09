import java.util.*;
class Solution {
    public String solution(String number, int k) {
        String answer = "";
        int idx=0;
        int tmp=-1;
        int MAX=-1;
        while(k>0){
            idx=tmp+1;
            for(int i=idx;i<=idx+k && i<number.length();i++){
                if(MAX<(number.charAt(i)-'0')){
                    MAX=number.charAt(i)-'0';
                    tmp=i;
                }
            }
            if(idx+1==number.length() && idx==tmp){
                break;
            }
            answer+=String.valueOf(number.charAt(tmp));
            k-=(tmp-idx);            
            MAX=-1;
            
        }
        answer+=number.substring(tmp+1,number.length());
        return answer;
    }
}
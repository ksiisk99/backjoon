import java.util.*;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        int[] cnt=new int[26];
        Arrays.fill(cnt,10000);
        
        for(int i=0;i<keymap.length;i++){
            for(int j=0;j<keymap[i].length();j++){
                char c=keymap[i].charAt(j);
                cnt[c-'A']=Math.min(cnt[c-'A'],j+1);
            }
        }
        
        for(int i=0;i<targets.length;i++){
            int result=0;
            for(int j=0;j<targets[i].length();j++){
                char c =targets[i].charAt(j);
                result+=cnt[c-'A'];
            }
            answer[i]=result>=10000?-1:result;
        }
        return answer;
    }
}
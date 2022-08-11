import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];

        Set<String>set=new HashSet<>();
        char tmp=words[0].charAt(words[0].length()-1);
        set.add(words[0]);
        for(int i=1;i<words.length;i++){
            if(tmp==words[i].charAt(0) && !set.contains(words[i]) && words[i].length()!=1){
                tmp=words[i].charAt(words[i].length()-1);
                set.add(words[i]);
            }else{
                answer[0]=i%n+1;
                answer[1]=i/n+1;
                break;
            }
        }
        return answer;
    }
}
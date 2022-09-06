import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        for(int i=0;i<commands.length;i++){
            int start=commands[i][0];
            int end=commands[i][1];
            int select=commands[i][2];
            
            List<Integer>list=new ArrayList<>();
            for(int s=start-1;s<end;s++){
                list.add(array[s]);
            }
            Collections.sort(list);
            answer[i]=list.get(select-1);
        }
        return answer;
    }
}
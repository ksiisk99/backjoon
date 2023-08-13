import java.util.*;

class Solution {
    public int solution(String[] lines) {
        List<Integer> start = new ArrayList<>();
        List<Integer> end = new ArrayList<>();
        
        for(String line: lines) {
            int hour = Integer.parseInt(line.substring(11,13))*3600*1000;
            int min = Integer.parseInt(line.substring(14,16))*60*1000;
            int sec = Integer.parseInt(line.substring(17,19))*1000;
            int ms = Integer.parseInt(line.substring(20,23));
            
             int process = (int)(Double.parseDouble(line.substring(24,line.length()-1))*1000);
            
            int time = hour+min+sec+ms;
            start.add(time-process+1);
            end.add(time);
        }
        
        int answer = 0;
        for(int i =0;i<start.size();i++){
            int endTime = end.get(i)+1000;
            int cnt = 0;
            
            for(int j=i;j<start.size();j++){
                if(start.get(j) < endTime) {
                    cnt++;
                }
            }
            
            if(answer<cnt){
                answer=cnt;
            }
        }
        return answer;
    }
}
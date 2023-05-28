import java.util.*;

class Solution {
    public String solution(int n, int t, int m, String[] timetable) {
                PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(String table : timetable) {
            int time = Integer.parseInt(table.substring(0, 2)) * 60 + Integer.parseInt(table.substring(3));
            pq.add(time);
        }
     
        int startTime = 9 * 60;
        int lastTime = 0;
        int total = 0;
        
        for(int i=0;i<n;i++){
            total = 0;
            while(!pq.isEmpty()){
                int currentTime = pq.peek();
                if(currentTime<=startTime && total<m){
                    pq.poll();
                    total++;
                }else{
                    break;
                }
                lastTime = currentTime - 1;
            }
            startTime+=t;
        }
        if(total<m)lastTime=startTime-t;
        return String.format("%02d", lastTime/60)+":"+String.format("%02d", lastTime%60);
    }
}
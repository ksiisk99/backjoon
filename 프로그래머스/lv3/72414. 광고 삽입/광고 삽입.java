import java.util.*;

class Solution {
    public String solution(String play_time, String adv_time, String[] logs) {
        int[] cnt = new int[360000];
        
        int play = convertSec(play_time);
        int adv = convertSec(adv_time);
        for(String log: logs){
            StringTokenizer st = new StringTokenizer(log, "-");
            int startSec = convertSec(st.nextToken());
            int endSec = convertSec(st.nextToken());
            for(int i=startSec;i<endSec;i++){
                cnt[i]++;
            }
        }
        
        
        long sum = 0L;
        for(int i=0;i<adv;i++){
            sum+=cnt[i];
        }
        
        int left = 0, right=adv;
        long max = sum;
        int answer = 0;
        while(right<play) {
            sum += (cnt[right]-cnt[left]);
            if(max < sum){
                max = sum;
                answer = left +1 ;
            }
            left++;
            right++;
        }
        
        return String.format("%02d:%02d:%02d", answer/3600, (answer%3600/60), (answer%60));
    }
    
    int convertSec(String time){
        StringTokenizer st = new StringTokenizer(time, ":");
        int hour = Integer.parseInt(st.nextToken()) * 3600;
        int min = Integer.parseInt(st.nextToken()) * 60;
        int sec = Integer.parseInt(st.nextToken());
        
        return hour+min+sec;
    }
}
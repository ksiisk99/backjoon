import java.util.*;
import java.text.*;

class Solution {
    
    static class Assignment implements Comparable<Assignment> {
        String name;
        String date;
        int time;

        Assignment(String name, String date, int time) {
            this.name = name;
            this.date = date;
            this.time = time;
        }

        @Override
        public int compareTo(Assignment other) {
            DateFormat df = new SimpleDateFormat("HH:mm");
            try {
                Date thisDate = df.parse(this.date);
                Date otherDate = df.parse(other.date);
                return thisDate.compareTo(otherDate);
            } catch (ParseException e) {
                throw new IllegalArgumentException("Invalid date format", e);
            }
        }
    }
    public String[] solution(String[][] plans) {
        String[] answer = new String[plans.length];
        List<Assignment>assignments=new ArrayList<>();
        
        for(int i=0;i<plans.length;i++){
            assignments.add(new Assignment(plans[i][0],plans[i][1],Integer.parseInt(plans[i][2])));
        }
        Collections.sort(assignments);
        
        int cnt=0;
        Stack<int[]>stack=new Stack<>();
        for(int i=0;i<assignments.size();i++){
            if(!stack.isEmpty()){
                int[] info=stack.pop();
                int idx=info[0];
                int remainingTime=info[1];
                int diffInTime = calcDiffInTime(assignments.get(idx).date, assignments.get(i).date);
                
                if(remainingTime<=diffInTime){
                    answer[cnt++]=assignments.get(idx).name;
                    remainingTime=diffInTime-remainingTime;
                    while(!stack.isEmpty()){
                        int[] info2=stack.pop();
                        int idx2=info2[0];
                        int currentTime=info2[1];
                        
                        if(currentTime>remainingTime){
                            stack.add(new int[]{idx2,currentTime-remainingTime});
                            break;
                        }else{
                            answer[cnt++]=assignments.get(idx2).name;
                            remainingTime-=currentTime;
                        }
                    }
                }else{
                    stack.add(new int[]{idx,remainingTime-diffInTime});
                }
            }
            stack.add(new int[]{i, assignments.get(i).time});
        }
        
        while(!stack.isEmpty()){
            int[] info=stack.pop();
            answer[cnt++]=assignments.get(info[0]).name;
        }
        
        return answer;
    }
    
    int calcDiffInTime(String date, String date2){
        int hour1 = Integer.parseInt(date.substring(0,2));
        int minute1 = Integer.parseInt(date.substring(3));
        int hour2 = Integer.parseInt(date2.substring(0,2));
        int minute2 = Integer.parseInt(date2.substring(3));
        return (hour2 - hour1) * 60 + (minute2 - minute1);
    }
}
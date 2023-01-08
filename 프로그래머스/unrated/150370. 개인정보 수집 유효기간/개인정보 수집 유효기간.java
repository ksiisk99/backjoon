import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        Map<String,Integer>map=new HashMap<>();
        List<Integer>answer =new ArrayList<>();
        int intToday=Integer.parseInt(today.replace(".",""));
        for(String term:terms){
            String[] tmp=term.split(" ");
            map.put(tmp[0],Integer.parseInt(tmp[1]));
        }
        
        int idx=1;
        for(String s:privacies){
            String[] tmp=s.split(" ");
            int date=Integer.parseInt(tmp[0].replace(".",""));
            date=calc(date,map.get(tmp[1]));
            
            if(isDestory(intToday,date)){
                answer.add(idx);
            }
            idx++;
        }
        
        return answer.stream()
            .mapToInt(i->i)
            .toArray();
    }
    
    boolean isDestory(int today, int date){
        if(today>=date)return true;
        return false;
    }
    
    int calc(int date,int month){
        date+=month/12*10000;
        month%=12;
        date+=month*100;
        
        int tmp=date%10000;
        if(tmp>=1300){
            date-=1200;
            date+=10000;
        }
        return date;
    }
}
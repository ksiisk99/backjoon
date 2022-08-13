import java.util.*;
class Solution {
    public int solution(int cacheSize, String[] cities) {
        Queue<String>queue=new LinkedList<>();
        Set<String>set=new HashSet<>();
        int answer=0;
        for(int i=0;i<cities.length;i++){
            cities[i]=cities[i].toLowerCase();
            if(set.contains(cities[i])){
                answer++;
                queue.remove(cities[i]);
                queue.add(cities[i]);
            }else{
                answer+=5;
                if(cacheSize!=0){
                    if(queue.size()==cacheSize){
                        set.remove(queue.poll());         
                    }
                    queue.add(cities[i]);
                    set.add(cities[i]);
                }
            }
        }
        return answer;
    }
}
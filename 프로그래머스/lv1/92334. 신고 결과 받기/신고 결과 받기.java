import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        Map<String,Integer>cumulativeTotal=new HashMap<>();
        Map<String,List<String>>reportUsers=new HashMap<>();
        Set<String>overlap=new HashSet<>();
        
        for(String repo:report){
            String[] users=repo.split(" ");
            if(overlap.contains(repo))continue;
            if(cumulativeTotal.containsKey(users[1])){
                cumulativeTotal.put(users[1],cumulativeTotal.get(users[1])+1);
            }else{
                cumulativeTotal.put(users[1],1);
            }
            if(reportUsers.containsKey(users[0])){
                List<String>tmp=reportUsers.get(users[0]);
                tmp.add(users[1]);
                reportUsers.put(users[0],tmp);
            }else{
                List<String>tmp=new ArrayList<>();
                tmp.add(users[1]);
                reportUsers.put(users[0],tmp);
            }
            overlap.add(repo);
        }
        
        for(int i=0;i<id_list.length;i++){
            if(reportUsers.containsKey(id_list[i])){
                for(String who:reportUsers.get(id_list[i])){
                    if(cumulativeTotal.get(who)>=k){
                        answer[i]++;
                    }
                }
            }
                
        }
        return answer;
    }
}
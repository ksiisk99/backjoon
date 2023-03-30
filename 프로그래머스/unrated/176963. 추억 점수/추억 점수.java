import java.util.*;

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        List<Integer>answer=new ArrayList<>();
        Map<String,Integer>map=new HashMap<>();
        for(int i=0;i<name.length;i++){
            String n=name[i];
            int year=yearning[i];
            
            map.put(n,year);
        }
        
        for(int i=0;i<photo.length;i++){
            int sum=0;
            for(int j=0;j<photo[i].length;j++){
                sum+=map.getOrDefault(photo[i][j],0);
            }
            answer.add(sum);
        }
        
        return answer.stream()
            .mapToInt(i->i)
            .toArray();
    }
}
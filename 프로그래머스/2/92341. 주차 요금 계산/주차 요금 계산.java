import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        List<Integer>answer=new ArrayList<>();
        Map<String,Integer>time=new HashMap<>();
        Map<String,String>inOut=new HashMap<>();
        List<int[]>list=new ArrayList<>();

        for(int i=0;i<records.length;i++){
            String[] tmp=records[i].split(" ");
            if(tmp[2].equals("IN")){
                inOut.put(tmp[1],tmp[0]);
                if(!time.containsKey(tmp[1]))time.put(tmp[1], 0);
            }else{
                String[] IN=inOut.get(tmp[1]).split(":");
                String[] OUT=tmp[0].split(":");
                int hour=Integer.parseInt(OUT[0])-Integer.parseInt(IN[0]);
                int minute=Integer.parseInt(OUT[1])-Integer.parseInt(IN[1]);

                int total=time.get(tmp[1])+hour*60+minute;
                time.put(tmp[1],total);
                inOut.remove(tmp[1]);
            }
        }
        for(String key:inOut.keySet()){
            String[] IN=inOut.get(key).split(":");
            int hour=23-Integer.parseInt(IN[0]);
            int minute=59-Integer.parseInt(IN[1]);

            int total=time.get(key)+hour*60+minute;
            time.put(key,total);
        }
        for(String key:time.keySet()){
            int result=fees[1];
            int total=time.get(key);
            if(total>=fees[0]){
                total-=fees[0];
                result+=Math.ceil((double)total/fees[2])*fees[3];
            }
            list.add(new int[]{Integer.parseInt(key),result});
        }
        Collections.sort(list, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }           
        });
        for(int[] next:list)answer.add(next[1]);
        return answer.stream()
            .mapToInt(i->i)
            .toArray();
    }
}
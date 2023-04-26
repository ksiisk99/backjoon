import java.util.*;

class Solution {    
    class Info implements Comparable<Info>{
        int idx;
        int count;
        String music;
        
        Info(int idx,int count, String music){
            this.idx=idx;
            this.count=count;
            this.music=music;
        }
        
        @Override
        public int compareTo(Info o){
            int result=o.count-count;
            if(result==0){
                return idx-o.idx;
            }
            return result; 
        }
    }
    
    public int[] solution(String[] genres, int[] plays) {
        List<Integer>answer=new ArrayList<>();
        List<Info>infos=new ArrayList<>();
        for(int i=0;i<genres.length;i++){
            infos.add(new Info(i,plays[i],genres[i]));
        }
        Collections.sort(infos);
        
        Map<String, Integer> map = new HashMap<>();
        Map<String, List<Integer>> map2 = new HashMap<>();
        for(Info info:infos){
            int sum = map.getOrDefault(info.music, 0)+info.count;
            List<Integer> music = map2.getOrDefault(info.music, new ArrayList<>());
            music.add(info.idx);
            map2.put(info.music, music);
            map.put(info.music, sum);
        }
        
        List<Info>tmp=new ArrayList<>();
        for(String musicName:map.keySet()){
            tmp.add(new Info(-1, map.get(musicName), musicName));
        }
        Collections.sort(tmp);
        
        for(Info info:tmp){
            if(map.containsKey(info.music)){
                int registCnt=0;
                for(int idx:map2.get(info.music)){
                    registCnt++;
                    answer.add(idx);
                    if(registCnt==2){
                        break;
                    }
                    
                }
            }
        }
        
        return answer.stream()
            .mapToInt(i->i)
            .toArray();
    }
}
import java.util.*;

class Solution {
    static Condition[] conditions;
    static class Condition implements Comparable<Condition> {
        int diamond,iron,stone;
        
        Condition(int diamond, int iron, int stone){
            this.diamond=diamond;
            this.iron=iron;
            this.stone=stone;
        }
        
        @Override
        public int compareTo(Condition o){
            if(o.stone==stone){
                if(o.iron==iron){
                    return o.diamond-diamond;
                }
                return o.iron-iron;
            }
            return o.stone-stone;
        }
    }
    
    public int solution(int[] picks, String[] minerals) {
        conditions=new Condition[minerals.length/5+1];
        for(int i=0;i<minerals.length/5+1;i++){
            conditions[i]=new Condition(0,0,0);
        }
        
        int pickSize=Arrays.stream(picks)
            .sum();
        for(int i=0;i<minerals.length && i<(pickSize*5);i++){
            int idx=i/5;
            switch(minerals[i]){
                case "diamond":
                    conditions[idx].diamond++;
                    conditions[idx].iron+=5;
                    conditions[idx].stone+=25;
                    break;
                case "iron":
                    conditions[idx].diamond++;
                    conditions[idx].iron++;
                    conditions[idx].stone+=5;
                    break;
                case "stone":
                    conditions[idx].diamond++;
                    conditions[idx].iron++;
                    conditions[idx].stone++;
            }
        }
        
        Arrays.sort(conditions);
        int answer=0;
        int idx=0;
        for(int i=0;i<3;i++){
            for(int j=0;j<picks[i];j++){
                switch(i){
                    case 0:
                        answer+=conditions[idx++].diamond;
                        break;
                    case 1:
                        answer+=conditions[idx++].iron;
                        break;
                    case 2:
                        answer+=conditions[idx++].stone;
                }
                
                if(idx>=(minerals.length/5+1)){
                    return answer;
                }
            }
        }
        return answer;
    }
}
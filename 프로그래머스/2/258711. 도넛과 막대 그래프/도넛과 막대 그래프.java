import java.util.*;

class Solution {
    public int[] solution(int[][] edges) {
        int[] answer = {0,0,0,0};
        Map<Integer, int[]> nodeCount = new HashMap<>();
        
        for(int[] edge: edges) {
            if(!nodeCount.containsKey(edge[0])) {
                nodeCount.put(edge[0], new int[]{0,0});
            }
            
            if(!nodeCount.containsKey(edge[1])) {
                nodeCount.put(edge[1], new int[]{0,0});
            }
            
            nodeCount.get(edge[0])[0]++;
            nodeCount.get(edge[1])[1]++;
        }
        
        int[] cnts;
        for(int key:nodeCount.keySet()) {
            cnts = nodeCount.get(key);
            
            if(cnts[0]>=2 && cnts[1] ==0) {
                answer[0]=key;
            } else if(cnts[0]==0 && cnts[1]>0) {
                answer[2]++;
            } else if(cnts[0]>=2 && cnts[1]>=2) {
                answer[3]++;
            }
        }
        
        answer[1]= nodeCount.get(answer[0])[0] - answer[2] - answer[3];
        
        return answer;
    }
}
import java.util.stream.*;
import java.util.*;

class Solution {
    
    static class Node implements Comparable<Node>{
        int stage;
        double fail;
        
        public Node(int stage, double fail){
            this.stage=stage;
            this.fail=fail;
        }
        
        @Override
        public int compareTo(Node node){
            if(fail==node.fail){
                return node.stage-stage>0?-1:1;
            }
            return node.fail-fail>0.0?1:-1;
        }
    }
    
    public int[] solution(int N, int[] stages) {
        int[] fails=new int[N+1];
        int[] failCnts=new int[N+1];
        int userSize=stages.length;
        
        Arrays.stream(stages)
            .filter(i->i<=N)
            .forEach(i->fails[i]++);
        
        for(int i=1;i<=N;i++){
            failCnts[i]+=fails[i]+failCnts[i-1];
        }
        
        List<Node>list = new ArrayList<>();
        for(int i=1;i<=N;i++){
            double bunmo=(userSize-failCnts[i-1]);    
            Node node=new Node(i,(double)fails[i]/(bunmo==0.0?1.0:bunmo));
            list.add(node);
        }
        
        
        Collections.sort(list);
        
        return list.stream()
            .mapToInt(node->node.stage)
            .toArray();
    }
}
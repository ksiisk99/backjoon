import java.util.*;

class Solution {
    private ArrayList<Integer>[] list;
    private int answer;
    
    void dfs(int[] info, List<Integer> nextNodes, int num, int sheep, int wolf) {
        sheep += info[num]^1;
        wolf += info[num];
        answer = Math.max(answer, sheep);
        
        if(sheep<=wolf){
            return;
        }
        
        List<Integer> next = new ArrayList<>(nextNodes);
        next.addAll(list[num]);
        
        next.remove(Integer.valueOf(num));
        for(int n:next){
            dfs(info, next, n, sheep, wolf);
        }
    }
    
    public int solution(int[] info, int[][] edges) {
        list=new ArrayList[info.length];
        for(int i=0;i<info.length;i++) list[i]=new ArrayList<>();
        
        for(int[] edge:edges){
            list[edge[0]].add(edge[1]);
        }
        
        List<Integer> nextNodes = new ArrayList<>();
        nextNodes.add(0);
        dfs(info, nextNodes, 0, 0, 0);
        
        return answer;
    }
}
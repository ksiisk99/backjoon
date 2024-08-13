class Solution {
    boolean[]visit;
    
    void dfs(int[][] computers, int n, int node){
        visit[node]=true;
        for(int i=0;i<n;i++){
            if(i!=node && !visit[i] && computers[i][node]==1) {
                dfs(computers,n,i);
            }
        }
    }
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        visit=new boolean[n+1];
        for(int i=0;i<n;i++){
            if(!visit[i]){
                answer++;
                dfs(computers, n, i);
            }
        }
        return answer;
    }
}
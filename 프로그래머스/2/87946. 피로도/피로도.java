class Solution {
    static int N;
    static int answer;
    static boolean[] visit;
    static int[] select;
    public int solution(int k, int[][] dungeons) {
        answer=0;
        N=dungeons.length;
        visit=new boolean[N];
        select=new int[N];
        dfs(k,0,dungeons);
        return answer;
    }
    
    public void dfs(int k, int cnt, int[][] dungeons){
        if(cnt==N){
            int tmp=0;
            for(int i=0;i<cnt;i++){
                int[] dungeon=dungeons[select[i]];
                if(k>=dungeon[0]){
                    tmp++;
                    k-=dungeon[1];
                }else break;
            }
            answer=Math.max(answer,tmp);
            return;
        }
        
        for(int i=0;i<N;i++){
            if(!visit[i]){
                visit[i]=true;
                select[cnt]=i;
                dfs(k,cnt+1,dungeons);
                visit[i]=false;
            }
        }
    }
}
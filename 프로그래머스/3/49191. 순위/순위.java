class Solution {
    public int solution(int n, int[][] results) {
        int answer = 0;
        int[][] graph=new int[n+1][n+1];
        for(int[] result:results){
            graph[result[0]][result[1]]=1;
            graph[result[1]][result[0]]=-1;
        }
        
        for(int k=1;k<=n;k++){
            for(int i=1;i<=n;i++){
                for(int j=1;j<=n;j++){
                    if(graph[i][k]==1 && graph[k][j]==1) {
                        graph[i][j]=1;
                        graph[j][i]=-1;
                    }
                    
                    if(graph[i][k]==-1 && graph[k][j]==-1){
                        graph[i][j]=-1;
                        graph[j][i]=1;
                    }
                }
            }
        }
        
        for(int i=1;i<=n;i++){
            int cnt=0;
            for(int j=1;j<=n;j++){
                if(graph[i][j]==-1 || graph[i][j]==1){
                    cnt++;
                }
            }
            if(cnt==n-1){
                answer++;
            }
        }
        return answer;
    }
}
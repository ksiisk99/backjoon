class Solution {
    private int[][] allWeak;
    private int[] flag;
    private int N, answer=Integer.MAX_VALUE, distSize;
    
    void permutation(int cnt, int mask, int[] dist) {
        clear(mask, dist);
        
        for(int i=0;i<distSize;i++){
            if((mask&(1<<i))==0){
                flag[cnt]=dist[i];
                permutation(cnt+1, (mask|(1<<i)), dist);
            }
        }
        
    }
    
    void clear(int mask, int[] dist){
        int friendNum = 0;
        for(int i=0;i<dist.length;i++){
            if((mask&(1<<i))>0){
                friendNum++;
            }
        }
        if(friendNum==0)return;
        
        int check = 0;
        int cnt = 0;
        for(int i=0;i<N;i++){
            int d = allWeak[i][0];
            int idx = 1;
            cnt = 0;
            check = 0;
            for(int j=0;j<friendNum;j++){
                cnt++;
                int friendDist = flag[j];
                while(idx<N) {
                    if(friendDist>=(allWeak[i][idx]-d)){
                        friendDist -= (allWeak[i][idx]-d);
                        d=allWeak[i][idx++];
                    } else{
                        d=allWeak[i][idx++];
                        if(cnt==friendNum && idx==N){
                            check = 1;
                        }
                        break;
                    }
                } 
                
                if(check!=1 && idx==N){
                    check=2;
                    break;
                }
            }
            
            if(check==2){
                answer = Math.min(friendNum, answer);
                break;
            }
        }
        
    }
    
    public int solution(int n, int[] weak, int[] dist) {
        N=weak.length;
        distSize = dist.length;
        allWeak = new int[N][N];
        flag = new int[distSize];
        
        for(int i=0;i<N;i++){
            int idx=0;
            for(int j=i;j<weak.length;j++){
                allWeak[i][idx++]=weak[j];
            }
            
            for(int j=0;j<i;j++){
                allWeak[i][idx++]=weak[j]+n;
            }
        }
        permutation(0, 0, dist);
        
        if(answer==Integer.MAX_VALUE) return -1;
        return answer;
    }
}
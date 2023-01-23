class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;

        int dist=1;
        for(int station:stations){
            if(dist<station-w){
                answer+=calc(station-w,dist,(w*2+1));
            }
            dist=station+w+1;
        }
        
        if(dist<=n){
            answer+=calc(n+1,dist,(w*2+1));
        }
        return answer;
    }
    
    int calc(int station, int dist,int w){
        int result=0;
        int tmp=station-dist;
        result+=tmp/w;
        if(tmp%w!=0){
            result++;
        } 
        return result;
    }
}
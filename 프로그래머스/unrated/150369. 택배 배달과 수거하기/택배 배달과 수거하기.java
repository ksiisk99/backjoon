class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;

        int i=n-1;
       for(;i>=0;){
            int dIdx=i;
            int pIdx=i;
            if(deliveries[i]==0 && pickups[i]==0){
                i--;
                continue;
            }

            int dBox=0;
            int pBox=0;
            while(dIdx>=0){
                dBox+=deliveries[dIdx];

                if(dBox>=cap){
                    deliveries[dIdx]-=cap-(dBox-deliveries[dIdx]);
                    break;
                }
                deliveries[dIdx]=0;
                dIdx--;
            }

            while(pIdx>=0){
                pBox+=pickups[pIdx];

                if(pBox>=cap){
                    pickups[pIdx]-=cap-(pBox-pickups[pIdx]);
                    break;
                }
                pickups[pIdx]=0;
                pIdx--;
            }

            answer+=(i+1)*2;
            i=Math.max(pIdx,dIdx);

        }
        return answer;
    }
}
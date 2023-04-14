import java.util.*;

class Solution {
    public int solution(int[][] targets) {
        int answer = 0;
        Arrays.sort(targets, new Comparator<int[]>(){
                @Override
                public int compare(int[] a,int[] b){
                    int result=Integer.compare(a[0],b[0]);
                    if(result==0){
                        return Integer.compare(a[1],b[1]);
                    }
                    return result;
                }
        });
        
        for(int i=0;i<targets.length;i++){
            answer++;
            int e=targets[i][1];
            for(int j=i+1;j<targets.length;j++){
                if(e<=targets[j][0]){
                    i=j-1;
                    break;
                }
                e=Math.min(e,targets[j][1]);
                if(j==targets.length-1){
                    return answer;
                }
            }
        }
        return answer;
    }
}
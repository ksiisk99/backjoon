import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        int answer = 1;
        
        Arrays.sort(routes, new Comparator<int[]>(){
            @Override
            public int compare(int[] a,int []b){
                return a[1]-b[1];
            }
        });
        
        int tmp=routes[0][1];
        for(int i=1;i<routes.length;i++){
            if(tmp<routes[i][0]){
                tmp=routes[i][1];
                answer++;
            }
        }
        return answer;
    }
}

//[-20,-15] [-18, -13] [-14, -5] [-5, -3]
//[3,7] [4, 6] [8, 10] [11, 13]
import java.util.*;

class Solution {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        int answer = 0;
                Comparator<int[]>comparator = new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[col-1] != o2[col-1]){
                    return Integer.compare(o1[col-1],o2[col-1]);
                }else{
                    return Integer.compare(o2[0],o1[0]);
                }
            }
        };

        Arrays.sort(data,comparator);
        
        for(int i=row_begin; i<=row_end;i++){
            int idx=i;
            answer ^= Arrays.stream(data[i-1])
                .map(n->n%idx)
                .sum();
        }
        return answer;
    }
}
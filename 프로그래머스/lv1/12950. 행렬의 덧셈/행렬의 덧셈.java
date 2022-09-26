import java.util.stream.*;

class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int row=arr1.length;
        int col=arr1[0].length;
        int[][] answer=new int[row][col];
        IntStream.range(0,row)
            .forEach(i->IntStream.range(0,col)
                    .forEach(j->answer[i][j]=arr1[i][j]+arr2[i][j]));
        return answer;
    }
}
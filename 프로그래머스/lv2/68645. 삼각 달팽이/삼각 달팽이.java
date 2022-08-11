import java.util.*;
class Solution {
    public int[] solution(int n) {
        List<Integer>list=new ArrayList<>();
        int[][] board=new int[n][n];
        int num=1;
        int cnt=1;
        int x=-1,y=0;
        while(n!=0){
            for(int i=0;i<n;i++){
                board[++x][y]=num++;
            }
            
            n--;
            if(n==0)break;
            for(int i=0;i<n;i++){
                board[x][++y]=num++;
            }
            
            n--;
            if(n==0)break;
            for(int i=0;i<n;i++){
                board[--x][--y]=num++;
            }
            n--;
        }
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board.length;j++){
                if(board[i][j]!=0){
                    list.add(board[i][j]);
                }else break;
            }
        }
        return list.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }
}
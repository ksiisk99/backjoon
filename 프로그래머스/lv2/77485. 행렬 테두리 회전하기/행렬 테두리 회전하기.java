import java.util.*;

class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        int[][] board=new int[rows+1][columns+1];
        int idx=1;
        for(int i=1;i<=rows;i++){
            for(int j=1;j<=columns;j++){
                board[i][j]=idx++;
            }
        }
        idx=0;
        
        for(int i=0;i<queries.length;i++){
            
            int xLen=queries[i][2]-queries[i][0];
            int yLen=queries[i][3]-queries[i][1];
            int tmp=board[queries[i][0]][queries[i][1]];
            int MIN=tmp;
            int x=queries[i][0];
            int y=queries[i][1];
            for(int j=x+1;j<=x+xLen;j++){
                board[j-1][y]=board[j][y];
                MIN=Math.min(MIN,board[j][y]);
            }
            x=queries[i][2];
            for(int j=y+1;j<=y+yLen;j++){
                board[x][j-1]=board[x][j];
                MIN=Math.min(MIN,board[x][j]);
            }
            y=queries[i][3];
            for(int j=x;j>=x-xLen+1;j--){
                board[j][y]=board[j-1][y];
                MIN=Math.min(MIN,board[j-1][y]);
            }
            x=queries[i][0];
            
            for(int j=y;j>=y-yLen+1;j--){
                board[x][j]=board[x][j-1];
                MIN=Math.min(MIN,board[x][j-1]);
            }
            board[queries[i][0]][queries[i][1]+1]=tmp;
            answer[idx++]=MIN;
        }
        return answer;
    }
}
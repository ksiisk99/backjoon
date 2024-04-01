import java.util.*;
class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer>stack=new Stack<>();
        int N=board.length;
        for(int num:moves){
            for(int i=0;i<N;i++){
                if(board[i][num-1]!=0){
                    if(stack.isEmpty()){
                        stack.push(board[i][num-1]);
                    }else{
                        if(stack.peek()==board[i][num-1]){
                            int n=stack.pop();
                            answer+=2;
                            System.out.println(n);
                        }else stack.push(board[i][num-1]);
                    }
                    board[i][num-1]=0;
                    break;
                }
            }
        }
        return answer;
    }
}
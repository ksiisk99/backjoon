class Solution
{   
    public int solution(int[][] board){
        int answer=0;
        for(int i=0;i<board[0].length;i++){
            if(board[0][i]==1){
                answer=1;
                break;
            }
        }
        if(answer!=1){
             for(int i=0;i<board.length;i++){
                if(board[i][0]==1){
                    answer=1;
                    break;
                }
            }
        }
        
        for(int i=1;i<board.length;i++){
            for(int j=1;j<board[0].length;j++){
                int diagonal=board[i-1][j-1];
                int vert=board[i-1][j];
                int hor=board[i][j-1];
                
                if(board[i][j]==1 && diagonal>0 && vert>0 && hor>0){
                    if(diagonal==vert && diagonal==hor && hor==vert){ //하나 큰 정사각형이 됨
                        board[i][j]=diagonal+1;
                    }else{
                        int size=Math.min(diagonal,hor);
                        size=Math.min(size,vert);
                        board[i][j]=size+1;
                    }
                    answer=Math.max(answer,board[i][j]*board[i][j]);                  
                }
            }
        }
        
        return answer;
    }
        
}
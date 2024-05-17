/*
1. 선공 개수랑 후공 개수가 같거나, 선공이랑 후공+1이랑 같아야 된다.
2. 선공이 먼저 끝나면 선공이랑 후공+1이 같아야 된다.
3. 후공이 먼저 끝나면 선공이랑 후공이 같아야 된다.
*/
class Solution {

    public int solution(String[] board) {
        int answer = -1;
        int oCount=0,xCount=0,xWin=0,oWin=0;
        
        for(String s:board){
            for(int i=0;i<3;i++){
                if(s.charAt(i)=='O'){
                    oCount++;
                }else if(s.charAt(i)=='X'){
                    xCount++;
                }
            }
        }
        if(oCount+xCount == 0){
            return 1;
        }else if(oCount<xCount){
            return 0;
        }else if(oCount>=xCount+2){
            return 0;
        }
        
        
        for(int i=0;i<3;i++){
            if(board[i].charAt(0)==board[i].charAt(1)
              && board[i].charAt(1)==board[i].charAt(2)){
                if(board[i].charAt(0)=='O'){
                    oWin++;
                }else if(board[i].charAt(0)=='X'){
                    xWin++;
                }
            }
            
            if(board[0].charAt(i)==board[1].charAt(i)
              && board[0].charAt(i)==board[2].charAt(i)){
                if(board[0].charAt(i)=='O'){
                    oWin++;
                }else if(board[0].charAt(i)=='X'){
                    xWin++;
                }
            }
        }
        
        if(board[0].charAt(0)==board[1].charAt(1)
          && board[1].charAt(1)==board[2].charAt(2)){
            if(board[1].charAt(1)=='O'){
                oWin++;
            }else if(board[1].charAt(1)=='X'){
                xWin++;
            }
        }
        
        if(board[0].charAt(2)==board[1].charAt(1)
          && board[1].charAt(1)==board[2].charAt(0)){
            if(board[1].charAt(1)=='O'){
                oWin++;
            }else if(board[1].charAt(1)=='X'){
                xWin++;
            }
        }
        
        if(oWin+xWin==0){
            return 1;
        }else if(oWin>xWin){
            if(oCount>xCount){
                return 1;
            }
        }else if(xWin>oWin && xCount==oCount){
            return 1;
        }
        return 0;
    }
}
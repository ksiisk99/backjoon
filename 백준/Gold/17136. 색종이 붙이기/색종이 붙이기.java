import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static StringBuilder sb = new StringBuilder();
    private static int result;
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int[][] board;
    private static int[] paper = {0, 5, 5, 5, 5, 5};


    public static void main(String[] args) throws IOException {
        input();

        dfs(0, 0, 0);

        System.out.print(result == Integer.MAX_VALUE ? -1 : result);
    }

    private static void dfs(int x, int y, int cnt) {
        if (x >= 9 && y > 9) {
            result = Math.min(result, cnt);
            return;
        }

        if(y>9){
            dfs(x+1,0,cnt);
            return;
        }

        if(board[x][y]==1){
            for(int i=5;i>=1;i--){
                if(paper[i]>0 && isAttach(x,y,i)){
                    paper[i]--;
                    attach(x,y,i, 0);
                    dfs(x,y+1,cnt+1);
                    paper[i]++;
                    attach(x,y,i, 1);
                }
            }
        }else{
            dfs(x,y+1,cnt);
        }
    }

    private static void attach(int x, int y, int size, int state) {
        for(int i=x;i<x+size;i++){
            for(int j=y;j<y+size;j++){
                board[i][j]=state;
            }
        }
    }

    private static boolean isAttach(int x, int y, int size) {
        for(int i=x;i<x+size;i++){
            for(int j=y;j<y+size;j++){
                if(i>9 || j>9){
                    return false;
                }

                if(board[i][j]!=1){
                    return false;
                }
            }
        }
        return true;
    }

    private static void input() throws IOException {
        StringTokenizer st;
        result = Integer.MAX_VALUE;
        board = new int[10][10];

        for (int i = 0; i < 10; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 10; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

}
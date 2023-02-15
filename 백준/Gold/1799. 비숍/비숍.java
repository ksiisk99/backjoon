import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    private static int N;
    private static int[][] arr;
    private static List<int[]> position;
    private static boolean[] leftCheck;
    private static boolean[] rightCheck;
    private static boolean[][] colorBoard;

    private static int dfs(boolean color, int idx) {
        if(idx>=position.size())return 0;
        int result = 0;

        for(int i=idx;i<position.size();i++){
            int[] t = position.get(i);
            int x = t[0];
            int y = t[1];
            if(leftCheck[x + y] || rightCheck[y - x + N])continue;
            if(colorBoard[x][y]!=color)continue;
            leftCheck[x + y] = true;
            rightCheck[y - x + N] = true;
            result = Math.max(result,dfs(color,i+1)+1);
            leftCheck[x + y] = false;
            rightCheck[y - x + N] = false;
        }
        return result;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        colorBoard = new boolean[N][N];
        leftCheck = new boolean[N * 2 + 1];
        rightCheck = new boolean[N * 2 + 1];
        position = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == 1) {
                    position.add(new int[]{i, j});
                }
                if(i%2==0){
                    if(j%2==0){
                        colorBoard[i][j]=true;
                    }
                }else{
                    if(j%2==1){
                        colorBoard[i][j]=true;
                    }
                }
            }
        }

        System.out.println(dfs(true,0)+dfs(false,0));
    }
}
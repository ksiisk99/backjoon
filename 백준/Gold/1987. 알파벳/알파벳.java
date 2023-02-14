import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    private static StringBuilder sb;
    private static StringTokenizer st;
    private static int N, M;
    private static int[][] arr;
    private static int[] dx = {0, 0, 1, -1};
    private static int[] dy = {1, -1, 0, 0};

    private static int dfs(int bit, int x, int y) {
        int result = 0;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
            if ((bit & (1 << arr[nx][ny])) > 0) continue;
            result = Math.max(result, dfs(bit | (1 << arr[nx][ny]), nx, ny) + 1);
        }

        return result;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                arr[i][j] = s.charAt(j) - 'A';
            }
        }

        System.out.println(dfs((1 << arr[0][0]), 0, 0) + 1);
    }
}
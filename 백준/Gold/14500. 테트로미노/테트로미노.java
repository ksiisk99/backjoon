import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int N, M;
    private static int[] dx = {0, 0, -1, 1};
    private static int[] dy = {1, -1, 0, 0};
    private static int[][] board;
    private static int answer;
    private static boolean[][] visit;

    public static void main(String[] args) throws IOException {
        input();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                dfs(i, j, 1, board[i][j]);
            }
        }
        System.out.print(answer);
    }

    public static void dfs(int x, int y, int cnt, int sum) {
        if (cnt == 4) {
            answer = Math.max(answer, sum);
            return;
        }
        visit[x][y] = true;
        if (cnt == 3) {
            if (x - 2 >= 0 && visit[x - 1][y] && visit[x - 2][y]) {
                if (y - 1 >= 0) dfs(x - 1, y - 1, cnt + 1, sum + board[x - 1][y - 1]);
                if (y + 1 < M) dfs(x - 1, y + 1, cnt + 1, sum + board[x - 1][y + 1]);
            } else if (x + 2 < N && visit[x + 1][y] && visit[x + 2][y]) {
                if (y - 1 >= 0) dfs(x + 1, y - 1, cnt + 1, sum + board[x + 1][y - 1]);
                if (y + 1 < M) dfs(x + 1, y + 1, cnt + 1, sum + board[x + 1][y + 1]);
            } else if (y - 2 >= 0 && visit[x][y - 1] && visit[x][y - 2]) {
                if (x - 1 >= 0) dfs(x - 1, y - 1, cnt + 1, sum + board[x - 1][y - 1]);
                if (x + 1 < N) dfs(x + 1, y - 1, cnt + 1, sum + board[x + 1][y - 1]);
            } else if (y + 2 < M && visit[x][y + 1] && visit[x][y + 2]) {
                if (x - 1 >= 0) dfs(x - 1, y + 1, cnt + 1, sum + board[x - 1][y + 1]);
                if (x + 1 < N) dfs(x + 1, y + 1, cnt + 1, sum + board[x + 1][y + 1]);
            }
        }

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || ny < 0 || nx >= N || ny >= M || visit[nx][ny]) continue;

            dfs(nx, ny, cnt + 1, sum + board[nx][ny]);
        }
        visit[x][y] = false;
    }
    
    public static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new int[N][M];
        visit = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static StringBuilder sb = new StringBuilder();
    private static int N, maxHeight;
    private static int[][] area;
    private static int[][] visit;
    private static int[] dx = {0, 0, 1, -1};
    private static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        input();

        int result = 1;
        for (int height = 1; height <= maxHeight; height++) {
            visit = new int[N][N];

            int safeAreaCnt = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (visit[i][j] == 0 && area[i][j] > height) {
                        safeAreaCnt++;
                        dfs(safeAreaCnt, i, j, height);
                    }
                }
            }
            result = Math.max(result, safeAreaCnt);
        }

        System.out.print(result);
    }

    private static void dfs(int safeAreaCnt, int x, int y, int height) {
        visit[x][y] = safeAreaCnt;
        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];

            if (nx < 0 || ny < 0 || nx >= N || ny >= N || area[nx][ny] <= height || visit[nx][ny] > 0) continue;
            dfs(safeAreaCnt, nx, ny, height);
        }
    }


    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        area = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                area[i][j] = Integer.parseInt(st.nextToken());
                maxHeight = Math.max(maxHeight, area[i][j]);
            }
        }
    }

}
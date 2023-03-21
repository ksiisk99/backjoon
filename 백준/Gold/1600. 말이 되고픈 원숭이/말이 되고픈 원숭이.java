import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static StringBuilder sb = new StringBuilder();
    private static int N, K, M;
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int[][] board;
    private static boolean[][][] visit;
    private static int[] dx = {1, -1, 0, 0};
    private static int[] dy = {0, 0, 1, -1};
    private static int[] hx = {-2, -2, -1, -1, 1, 1, 2, 2};
    private static int[] hy = {-1, 1, -2, 2, -2, 2, -1, 1};


    public static void main(String[] args) throws IOException {
        input();
        move();
        System.out.println(-1);
    }

    private static void move() {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0, 0, K});
        visit[0][0][K] = true;

        while (!queue.isEmpty()) {
            int[] info = queue.poll();
            int x = info[0];
            int y = info[1];
            int cnt = info[2];
            int k = info[3];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx < 0 || ny < 0 || nx >= N || ny >= M || visit[nx][ny][k] || board[nx][ny]==1) {
                    continue;
                }

                if (nx == (N - 1) && ny == (M - 1)) {
                    System.out.println(cnt + 1);
                    System.exit(0);
                }
                visit[nx][ny][k] = true;
                queue.add(new int[]{nx, ny, cnt + 1, k});
            }
            if (k > 0) {
                k--;
                for (int i = 0; i < 8; i++) {
                    int nx = x + hx[i];
                    int ny = y + hy[i];
                    if (nx < 0 || ny < 0 || nx >= N || ny >= M || visit[nx][ny][k] || board[nx][ny]==1) {
                        continue;
                    }
                    if (nx == (N - 1) && ny == (M - 1)) {
                        System.out.println(cnt + 1);
                        System.exit(0);
                    }
                    visit[nx][ny][k] = true;
                    queue.add(new int[]{nx, ny, cnt + 1, k});
                }
            }
        }
    }

    private static void input() throws IOException {
        StringTokenizer st;
        K = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        if(N==1 && M==1){
            System.out.println(0);
            System.exit(0);
        }
        board = new int[N][M];
        visit = new boolean[N][M][K + 1];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }
}


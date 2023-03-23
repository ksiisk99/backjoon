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
    private static boolean[][][][] visit;
    private static int[] dx = {1, -1, 0, 0};
    private static int[] dy = {0, 0, 1, -1};


    public static void main(String[] args) throws IOException {
        input();
        move();
        System.out.println(-1);
    }

    private static void move() {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0, 1, K, 0});
        visit[0][K][0][0] = true;

        while (!queue.isEmpty()) {
            int[] info = queue.poll();
            int x = info[0];
            int y = info[1];
            int cnt = info[2];
            int k = info[3];
            int day = (info[4] * -1) + 1;

            if(!visit[day][k][x][y]){
                visit[day][k][x][y]=true;
                queue.add(new int[]{x,y,cnt+1,k,day});
            }

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx < 0 || ny < 0 || nx >= N || ny >= M || visit[day][k][nx][ny]) {
                    continue;
                }

                if (board[nx][ny] == 0) {
                    verifyReach(nx, ny, cnt);
                    visit[day][k][nx][ny] = true;
                    queue.add(new int[]{nx, ny, cnt + 1, k, day});
                } else if (k > 0 && !visit[day][k - 1][nx][ny] && day == 1) {
                    verifyReach(nx, ny, cnt);
                    visit[day][k - 1][nx][ny] = true;
                    visit[day][k - 1][nx][ny] = true;
                    queue.add(new int[]{nx, ny, cnt + 1, k - 1, day});
                }

            }
        }
    }

    public static void verifyReach(int x, int y, int cnt) {
        if (x == (N - 1) && y == (M - 1)) {
            System.out.println(cnt + 1);
            System.exit(0);
        }
    }

    private static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        if (N == 1 && M == 1) {
            System.out.println(1);
            System.exit(0);
        }
        board = new int[N][M];
        visit = new boolean[2][K + 1][N][M];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                board[i][j] = s.charAt(j) - '0';
            }
        }
    }
}


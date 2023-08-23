import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int N, M, x, y, K;
    private static int[] dir;
    private static int[] dx = {0, 0, 0, -1, 1};
    private static int[] dy = {0, 1, -1, 0, 0};
    private static int[][] board;

    public static void main(String[] args) throws IOException {
        input();
        StringBuilder sb = new StringBuilder();

        int[] dice = new int[6];

        final int UP = 0;
        final int DOWN = 1;
        for (int i = 0; i < K; i++) {
            int nx = x + dx[dir[i]];
            int ny = y + dy[dir[i]];

            if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;

            int tmpUp = dice[UP];
            int tmpDown = dice[DOWN];
            if (dir[i] == 1) { //동
                dice[UP] = dice[2];
                dice[DOWN] = dice[3];
                dice[3] = tmpUp;
                dice[2] = tmpDown;
            } else if (dir[i] == 2) { //서
                dice[UP] = dice[3];
                dice[DOWN] = dice[2];
                dice[2] = tmpUp;
                dice[3] = tmpDown;
            } else if (dir[i] == 3) { //북
                dice[UP] = dice[4];
                dice[DOWN] = dice[5];
                dice[5] = tmpUp;
                dice[4] = tmpDown;
            } else { //남
                dice[UP] = dice[5];
                dice[DOWN] = dice[4];
                dice[4] = tmpUp;
                dice[5] = tmpDown;
            }

            if (board[nx][ny] == 0) {
                board[nx][ny] = dice[DOWN];
            } else {
                dice[DOWN] = board[nx][ny];
                board[nx][ny] = 0;
            }
            sb.append(dice[UP]);
            sb.append("\n");

            x = nx;
            y = ny;
        }

        System.out.print(sb.toString());
    }

    public static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new int[N][M];

        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        dir = new int[K];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            dir[i] = Integer.parseInt(st.nextToken());
        }
    }

}
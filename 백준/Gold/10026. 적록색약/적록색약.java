import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static StringBuilder sb = new StringBuilder();
    private static int N;
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static char[][] board;
    private static int[] dx = {0, 0, 1, -1};
    private static int[] dy = {1, -1, 0, 0};
    private static int[][] visit;


    public static void main(String[] args) throws IOException {
        input();

        int state = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (visit[i][j] == 0) {
                    zoning(i, j, ++state, board[i][j]);
                }
            }
        }
        sb.append(state);

        state = 0;
        visit = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (visit[i][j] == 0) {
                    zoning2(i, j, ++state, board[i][j]);
                }
            }
        }
        sb.append(" " + state);

        System.out.print(sb.toString());
    }

    private static void zoning2(int x, int y, int state, char color) {
        visit[x][y] = state;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx < 0 || ny < 0 || nx >= N || ny >= N || visit[nx][ny] > 0) continue;
            if (board[nx][ny] != color && (board[nx][ny] == 'B' || color == 'B')) continue;
            zoning2(nx, ny, state, color);
        }
    }

    private static void zoning(int x, int y, int state, char color) {
        visit[x][y] = state;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx < 0 || ny < 0 || nx >= N || ny >= N || visit[nx][ny] > 0 || board[nx][ny] != color) continue;
            zoning(nx, ny, state, color);
        }
    }


    private static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        board = new char[N][N];
        visit = new int[N][N];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < N; j++) {
                board[i][j] = s.charAt(j);
            }
        }
    }
}


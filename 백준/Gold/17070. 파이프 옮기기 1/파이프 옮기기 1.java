import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static StringBuilder sb = new StringBuilder();
    private static int N;
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int[][] board;
    private static int[][] dx = {{0}, {1}, {1, 0}, {0, 1, 1}}; //머리가 가로로 놓여있을 때, 머리가 세로로 놓여있을 때, 머리가 대각선으로 놓여있을 때
    private static int[][] dy = {{1}, {0}, {0, 1}, {1, 1, 0}};

    public static void main(String[] args) throws IOException {
        input();
        System.out.print(move(0, 1, 0));
    }

    private static int move(int x, int y, int head) {
        if (x == N - 1 && y == N - 1) {
            return 1;
        }
        int result = 0;
        for (int i = 0; i < dx[head].length; i++) {
            int nx = x + dx[head][i];
            int ny = y + dy[head][i];
            int nextHead = head;
            if (nextHead == 2) {
                if (i == 0) {
                    nextHead = 1;
                } else {
                    nextHead = 0;
                }
            }
            if (nx < 0 || ny < 0 || nx >= N || ny >= N || board[nx][ny] == 1) continue;
            result += move(nx, ny, nextHead);
        }

        if (checkDiagonalBoundaryLine(x, y)) {
            result += move(x + 1, y + 1, 2);
        }

        return result;
    }

    private static boolean checkDiagonalBoundaryLine(int x, int y) {
        for (int i = 0; i < 3; i++) {
            int nx = x + dx[3][i];
            int ny = y + dy[3][i];
            if (nx < 0 || ny < 0 || nx >= N || ny >= N || board[nx][ny] == 1) {
                return false;
            }
        }
        return true;
    }


    private static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        board = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

}
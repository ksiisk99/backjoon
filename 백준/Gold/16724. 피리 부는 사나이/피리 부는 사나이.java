import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static StringBuilder sb = new StringBuilder();
    private static int N, M, result;
    private static char[][] board;
    private static int[][] visit;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new char[N][M];
        visit = new int[N][M];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                board[i][j] = s.charAt(j);
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (visit[i][j] == 0) {
                    move(i, j);
                }
            }
        }

        System.out.println(result);
    }

    private static void move(int x, int y) {
        int nx = x, ny = y;
        visit[x][y] = 1;
        switch (board[x][y]) {
            case 'D':
                nx = x + 1;
                break;
            case 'L':
                ny = y - 1;
                break;
            case 'U':
                nx = x - 1;
                break;
            case 'R':
                ny = y + 1;
        }

        if (visit[nx][ny] == 0) {
            move(nx, ny);
        }
        if (visit[nx][ny] == 1) {
            result++;
        }
        visit[x][y] = 2;
    }
}
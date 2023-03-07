import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    private static StringBuilder sb = new StringBuilder();
    private static int N, M;
    private static int[][] board;
    private static int[][] numBoard;
    private static int[] movableCnt;
    private static int[] dx = {0, 0, 1, -1};
    private static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new int[N][M];
        numBoard = new int[N][M];
        movableCnt = new int[N * M + 2];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                board[i][j] = s.charAt(j) - '0';
            }
        }

        int number = 1;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (numBoard[i][j] == 0 && board[i][j] == 0) {
                    movableCnt[number] = numbering(number, i, j);
                    number++;
                }
            }
        }
        breakWall();
        System.out.print(sb.toString());
    }

    private static void breakWall() {
        Set<Integer> check = new HashSet<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (numBoard[i][j] == 0) {
                    int cnt = 1;
                    for (int d = 0; d < 4; d++) {
                        int nx = i + dx[d];
                        int ny = j + dy[d];

                        if (nx < 0 || ny < 0 || nx >= N || ny >= M || numBoard[nx][ny] == 0 || check.contains(numBoard[nx][ny])) {
                            continue;
                        }
                        cnt += movableCnt[numBoard[nx][ny]];
                        check.add(numBoard[nx][ny]);
                    }
                    check.clear();
                    board[i][j] = cnt % 10;
                }
                sb.append(board[i][j]);
            }
            sb.append("\n");
        }
    }

    private static int numbering(int number, int x, int y) {
        numBoard[x][y] = number;

        int cnt = 1;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx < 0 || ny < 0 || nx >= N || ny >= M || board[nx][ny] == 1 || numBoard[nx][ny] != 0) continue;
            cnt += numbering(number, nx, ny);

        }
        return cnt;
    }

}
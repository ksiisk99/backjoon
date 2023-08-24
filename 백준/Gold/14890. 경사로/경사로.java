import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int N, L;
    private static int[] dx = {0, 0, -1, 1};
    private static int[] dy = {1, -1, 0, 0};
    private static int[][] board;
    private static int answer;
    private static int[][] sequence;

    public static void main(String[] args) throws IOException {
        input();
        calcWidth();
        calcHeight();
        System.out.print(answer);
    }

    private static void calcHeight() {
        for (int i = 0; i < N; i++) {
            boolean can = true;
            int len = 1;

            for (int j = 0; j < N - 1; j++) {
                if (board[j + 1][i] == board[j][i]) {
                    len++;
                    continue;
                } else if (Math.abs(board[j][i] - board[j + 1][i]) >= 2) {
                    can = false;
                    break;
                } else if (board[j][i] < board[j + 1][i]) { //오르막길
                    if (len < L) {
                        can = false;
                        break;
                    }
                    len = 1;
                } else { //내리막길
                    int size = j + L + 1;
                    if (size > N) {
                        can = false;
                        break;
                    }

                    int cnt = 0;
                    for (int l = j + 1; l < size; l++) {
                        if (board[j + 1][i] == board[l][i]) {
                            cnt++;
                        }
                    }

                    if (cnt != L) {
                        can = false;
                        break;
                    }

                    len = 0;
                    j = size - 2;
                }
            }

            if (can) {
                answer++;
            }
        }
    }

    private static void calcWidth() {
        for (int i = 0; i < N; i++) {
            boolean can = true;
            boolean down = false;
            int len = 1;

            for (int j = 0; j < N - 1; j++) {
                if (board[i][j + 1] == board[i][j]) {
                    len++;
                    continue;
                } else if (Math.abs(board[i][j] - board[i][j + 1]) >= 2) {
                    can = false;
                    break;
                } else if (board[i][j] < board[i][j + 1]) { //오르막길
                    if (len < L) {
                        can = false;
                        break;
                    }
                    len = 1;
                } else { //내리막길
                    int size = j + L + 1;
                    if (size > N) {
                        can = false;
                        break;
                    }

                    int cnt = 0;
                    for (int l = j + 1; l < size; l++) {
                        if (board[i][j + 1] == board[i][l]) {
                            cnt++;
                        }
                    }

                    if (cnt != L) {
                        can = false;
                        break;
                    }

                    len = 0;
                    j = size - 2;
                }
            }

            if (can) {
                answer++;
            }
        }
    }

    public static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        board = new int[N][N];
        sequence = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            Arrays.fill(sequence[i], 1);
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

}
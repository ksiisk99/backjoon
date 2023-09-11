import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int N;
    private static char[][] board;

    public static void main(String[] args) throws IOException {
        input();

        int answer = findMaxCandy();

        for (int i = 0; i < N; i++) {
            for (int j = 1; j < N; j++) {
                if (board[i][j] != board[i][j - 1]) {
                    swap(i, j, i, j - 1);
                    answer = Math.max(answer, findMaxCandy());
                    swap(i, j, i, j - 1);
                }

                if(board[j][i] != board[j-1][i]) {
                    swap(j, i, j-1, i);
                    answer = Math.max(answer, findMaxCandy());
                    swap(j, i, j-1, i);
                }
            }
        }

        System.out.print(answer);
    }

    public static void swap(int x, int y, int x2, int y2) {
        char tmp = board[x][y];
        board[x][y] = board[x2][y2];
        board[x2][y2] = tmp;
    }

    public static int findMaxCandy() {
        int result = 0;
        for (int i = 0; i < N; i++) {
            int cnt = 1;
            int cnt2 = 1;
            for (int j = 1; j < N; j++) {
                if (board[i][j] == board[i][j - 1]) {
                    cnt++;
                    result = Math.max(result, cnt);
                } else {
                    cnt = 1;
                }

                if (board[j][i] == board[j - 1][i]) {
                    cnt2++;
                    result = Math.max(result, cnt2);
                } else {
                    cnt2 = 1;
                }
            }
        }
        return result;
    }

    public static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        board = new char[N][N];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < N; j++) {
                board[i][j] = s.charAt(j);
            }
        }
    }

}
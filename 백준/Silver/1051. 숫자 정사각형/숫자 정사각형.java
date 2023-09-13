import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int N, M;
    private static int[][] board;

    public static void main(String[] args) throws IOException {
        input();
        int answer = 1;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                int size = 1;
                while (i + size < N && j + size < M) {
                    int n = board[i][j];
                    if (n == board[i][j + size] &&
                            n == board[i + size][j] &&
                            n == board[i + size][j + size]
                    ) {
                        size++;
                        answer = Math.max(answer, size * size);
                        size--;
                    }

                    size++;
                }
            }
        }

        System.out.print(answer);
    }

    public static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new int[N][M];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                board[i][j] = s.charAt(j) - '0';
            }
        }
    }
}
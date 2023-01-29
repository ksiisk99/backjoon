import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static StringBuilder sb;
    private static StringTokenizer st;
    private static int N, M, K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        char[][] board = new char[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String tmp = st.nextToken();
            for (int j = 0; j < M; j++) {
                board[i][j] = tmp.charAt(j);
            }
        }

        System.out.println(Math.min(calc('W', board), calc('B', board)));
    }

    public static int calc(char color, char[][] board) {
        int result = Integer.MAX_VALUE;
        int[][] intervalSum = new int[N + 1][M + 1];
        int value;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if ((i + j) % 2 == 0) {
                    value = board[i][j] != color ? 1 : 0;
                } else {
                    value = board[i][j] == color ? 1 : 0;
                }
                intervalSum[i + 1][j + 1] = intervalSum[i][j + 1] + intervalSum[i + 1][j] - intervalSum[i][j] + value;
            }
        }

        for (int i = 1; i <= N - K + 1; i++) {
            for (int j = 1; j <= M - K + 1; j++) {
                result = Math.min(result,
                        intervalSum[i + K - 1][j + K - 1]
                                - intervalSum[i + K - 1][j - 1]
                                - intervalSum[i - 1][j + K - 1]
                                + intervalSum[i - 1][j - 1]);
            }
        }
        return result;
    }
}
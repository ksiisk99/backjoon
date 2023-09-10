import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int N, M, B;
    private static int[][] board;
    private static int maxH;
    private static int minH = 256;

    public static void main(String[] args) throws IOException {
        input();

        int answerTime = Integer.MAX_VALUE;
        int answerHeight = 0;
        for (int h = minH; h <= maxH; h++) {
            int time = 0;
            int block = B;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (board[i][j] < h) {
                        time += (h - board[i][j]);
                        block -= (h - board[i][j]);
                    } else if (board[i][j] > h) {
                        time += (board[i][j] - h) * 2;
                        block += (board[i][j] - h);
                    }
                }
            }

            if (block < 0) {
                continue;
            }

            if (answerTime >= time) {
                answerTime = time;
                answerHeight = h;
            }
        }
        System.out.print(answerTime + " " + answerHeight);
    }

    public static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        board = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                maxH = Math.max(maxH, board[i][j]);
                minH = Math.min(minH, board[i][j]);
            }
        }

    }

}
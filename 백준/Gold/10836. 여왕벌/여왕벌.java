import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int M, N;
    private static int[][] board;
    private static int[][] arr;


    public static void main(String[] args) throws IOException {
        input();

        int size = 2 * M;
        for (int i = 0; i < N; i++) {
            List<Integer> tmp = new ArrayList<>();
            add(i, tmp);

            int idx = 0;
            for (int j = M - 1; j >= 0; j--) {
                board[j][0] += tmp.get(idx++);
            }

            for (int j = 1; j < M; j++) {
                board[0][j] += tmp.get(idx++);
            }
        }

        for (int i = 1; i < M; i++) {
            for (int j = 1; j < M; j++) {
                board[i][j] = board[i - 1][j];
            }
        }

        print();
    }

    private static void print() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < M; j++) {
                sb.append(board[i][j]);
                sb.append(" ");
            }
            sb.append("\n");
        }

        System.out.print(sb.toString());
    }

    private static void add(int idx, List<Integer> tmp) {
        for (int i = 0; i < arr[idx][0]; i++) {
            tmp.add(0);
        }

        for (int i = 0; i < arr[idx][1]; i++) {
            tmp.add(1);
        }

        for (int i = 0; i < arr[idx][2]; i++) {
            tmp.add(2);
        }
    }


    private static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        board = new int[M][M];
        arr = new int[N][3];

        for (int i = 0; i < M; i++) {
            Arrays.fill(board[i], 1);
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder answer = new StringBuilder();
    private static int N, M, K;
    private static int[][] arr;

    public static void main(String[] args) throws IOException {
        input();

        for (int i = 1; i <= M; i++) {
            for (int j = 1; j <= N; j++) {
                arr[j][i] += arr[j][i - 1];
                if (arr[j][i] >= K) {
                    System.out.print(j + " " + i);
                    return;
                }
            }
        }
    }


    private static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[N + 1][M + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 1; j <= M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder sb = new StringBuilder();
    private static int N, M, total9Count;
    private static int[][] arr;


    public static void main(String[] args) throws IOException {
        input();

        int answer = total9Count;

        for (int i = 0; i < N; i++) {
            int row9Count = 0;

            for (int j = 0; j < M; j++) {
                row9Count += calculateNineCount(arr[i][j]);
            }

            if (answer > (total9Count - row9Count)) {
                answer = total9Count - row9Count;
            }
        }

        for (int i = 0; i < M; i++) {
            int col9Count = 0;

            for (int j = 0; j < N; j++) {
                col9Count += calculateNineCount(arr[j][i]);
            }

            if (answer > (total9Count - col9Count)) {
                answer = total9Count - col9Count;
            }
        }

        System.out.print(answer);
    }

    private static int calculateNineCount(int num) {
        int count = 0;
        while (num > 0) {
            if (num % 10 == 9) {
                count++;
            }
            num /= 10;
        }
        return count;
    }

    private static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < M; j++) {
                int num = Integer.parseInt(st.nextToken());
                total9Count += calculateNineCount(num);
                arr[i][j] = num;
            }

        }
    }

}
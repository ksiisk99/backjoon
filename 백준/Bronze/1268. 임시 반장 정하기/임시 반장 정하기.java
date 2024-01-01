import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder sb = new StringBuilder();
    private static int N;
    private static int[][] students;

    public static void main(String[] args) throws IOException {
        input();

        int[] friendCount = new int[N + 1];
        int maxCount = -1;
        int 임시반장 = 0;

        for (int i = 1; i < N; i++) {
            for (int j = i + 1; j <= N; j++) {
                if (i == j) continue;

                for (int n = 1; n <= 5; n++) {
                    if (students[i][n] == students[j][n]) {
                        friendCount[i]++;
                        friendCount[j]++;
                        break;
                    }
                }
            }

            if (maxCount < friendCount[i]) {
                maxCount = friendCount[i];
                임시반장 = i;
            }
        }

        System.out.print(임시반장);
    }

    private static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        students = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j = 1; j <= 5; j++) {
                students[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

}
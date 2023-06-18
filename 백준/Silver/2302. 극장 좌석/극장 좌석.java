import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        int N = Integer.parseInt(br.readLine());

        int[] dp = new int[N + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= N; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        int M = Integer.parseInt(br.readLine());
        int result = 1;
        int tmp = 0;
        for (int i = 0; i < M; i++) {
            int num = Integer.parseInt(br.readLine());
            result *= dp[num - tmp - 1];
            tmp = num;
        }

        result *= dp[N - tmp];

        System.out.print(result);
    }
}


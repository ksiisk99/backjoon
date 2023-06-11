import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[1001];
        dp[1] = 1;
        dp[3] = 1;
        dp[4] = 1;

        for (int i = 5; i <= N; i++) {
            if (dp[i - 1] == 0) {
                dp[i] = 1;
            }

            if (dp[i - 3] == 0) {
                dp[i] = 1;
            }

            if (dp[i - 4] == 0) {
                dp[i] = 1;
            }
        }

        System.out.print(dp[N] == 1 ? "SK" : "CY");

    }
}


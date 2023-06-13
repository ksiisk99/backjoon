import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int MOD = 1000000009;
        int[] dp = new int[1000001];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        dp[4] = 7;

        for (int i = 5; i < 1000001; i++) {
            dp[i] = ((dp[i - 1] + dp[i - 2]) % MOD + dp[i - 3]) % MOD;
        }

        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());

            sb.append(dp[N]);
            sb.append("\n");
        }

        System.out.print(sb);
    }
}


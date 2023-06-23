import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] dp = new int[K + 1];
        Arrays.fill(dp, 10001);
        dp[0]=0;
        int[] coin = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            coin[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 1; i <= N; i++) {
            for (int j = coin[i]; j <= K; j++) {
                dp[j] = Math.min(dp[j], dp[j - coin[i]] + 1);
            }
        }

        System.out.print(dp[K] == 10001 ? -1 : dp[K]);
    }
}


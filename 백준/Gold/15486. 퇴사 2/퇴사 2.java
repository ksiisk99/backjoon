import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        int N = Integer.parseInt(br.readLine());

        int[] dp = new int[N + 2];
        int[] T = new int[N + 1];
        int[] P = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = N; i >= 1; i--) {
            if (i + T[i] > N+1) {
                dp[i] = dp[i + 1];
            } else {
                dp[i]=Math.max(dp[i+1],dp[i+T[i]]+P[i]);
            }
        }

        System.out.print(dp[1]);
    }
}


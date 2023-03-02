import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static StringBuilder sb = new StringBuilder();
    private static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        int[] T = new int[N + 1];
        int[] P = new int[N + 1];
        int[] dp = new int[N * 5 + 1];
        int result = 0;
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= N ; i++) {
            dp[i]=Math.max(dp[i],dp[i-1]);
            dp[i + T[i]] = Math.max(dp[i + T[i]], dp[i] + P[i]);
            if (i + T[i] <= N + 1) result = Math.max(result, dp[i + T[i]]);
        }
        System.out.println(result);
    }


}
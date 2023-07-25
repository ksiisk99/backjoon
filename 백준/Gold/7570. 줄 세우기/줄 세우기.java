import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] dp = new int[N + 1];
        int max = 0;
        for (int i = 0; i < N; i++) {
            int idx = Integer.parseInt(st.nextToken());
            dp[idx] = dp[idx - 1] + 1;
            max = Math.max(max, dp[idx]);
        }

        System.out.print(N-max);
    }
}
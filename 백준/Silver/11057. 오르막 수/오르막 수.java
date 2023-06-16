import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        int N = Integer.parseInt(br.readLine());

        int[][] dp = new int[N + 1][10];

        for (int i = 1; i <= N; i++) {
            dp[i][0] = 1;
            for (int j = 1; j <= 9; j++) {
                dp[i][j] = (dp[i - 1][j] + dp[i][j - 1]) % 10007;
            }
        }

        int result = 0;
        for(int i=0;i<=9;i++){
            result += dp[N][i];
        }
        System.out.print(result % 10007);
    }
}


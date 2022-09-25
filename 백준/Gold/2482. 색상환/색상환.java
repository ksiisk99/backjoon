import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb;
    static int N,K;
    static int[][] dp;
    static int MOD=1000000003;



    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        sb=new StringBuilder();
        
        N=Integer.parseInt(br.readLine());
        K=Integer.parseInt(br.readLine());
        dp=new int[N+1][K+1];

        for(int i=1;i<=N;i++) {
            dp[i][1] = i;
            dp[i][0]=1;
        }

        for(int i=4;i<=N;i++){
            for(int j=2;j<=K;j++){
                dp[i][j]=(dp[i-2][j-1]+dp[i-1][j])%MOD;
            }
        }
        System.out.println(dp[N][K]);
    }
}
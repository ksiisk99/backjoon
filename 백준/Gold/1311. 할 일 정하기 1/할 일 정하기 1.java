import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb;
    static int[][] dp;
    static int[][] arr;
    static int N;

    static int recursion(int n, int flag){
        if(n>=N)return 0;
        if(dp[n][flag]!=Integer.MAX_VALUE)return dp[n][flag];

        for(int i=0;i<N;i++){
            if((flag&(1<<i)) == 0) {
                dp[n][flag] = Math.min(dp[n][flag]
                        ,recursion(n + 1, flag | (1 << i)) + arr[n][i]);
            }
        }
        return dp[n][flag];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        sb=new StringBuilder();
        StringTokenizer st;
        N=Integer.parseInt(br.readLine());
        dp=new int[N][(1<<N)];
        arr=new int[N][N];

        for(int i=0;i<N;i++){
            st=new StringTokenizer(br.readLine());
            Arrays.fill(dp[i],Integer.MAX_VALUE);
            for(int j=0;j<N;j++){
                arr[i][j]=Integer.parseInt(st.nextToken());
            }
        }
        System.out.println(recursion(0,0));
    }

}
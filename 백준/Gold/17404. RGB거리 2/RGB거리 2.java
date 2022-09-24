import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb;
    static int N;
    static int[][] arr;
    static int[][] dp;



    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        sb=new StringBuilder();
        StringTokenizer st;

        N=Integer.parseInt(br.readLine());
        arr=new int[N+1][3];
        dp=new int[N+1][3];

        for(int i=0;i<N;i++){
            st=new StringTokenizer(br.readLine());
            for(int j=0;j<3;j++){
                arr[i][j]=Integer.parseInt(st.nextToken());
            }
        }

        int MAX=1000*1000;
        int answer=MAX;

        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if(i==j)dp[0][j]=arr[0][j];
                else dp[0][j]=MAX;
            }

            for(int j=1;j<N;j++){
                dp[j][0]=Math.min(dp[j-1][1],dp[j-1][2])+arr[j][0];
                dp[j][1]=Math.min(dp[j-1][0],dp[j-1][2])+arr[j][1];
                dp[j][2]=Math.min(dp[j-1][0],dp[j-1][1])+arr[j][2];
            }

            for(int j=0;j<3;j++){
                if(i!=j)answer=Math.min(answer,dp[N-1][j]);
            }
        }

        System.out.println(answer);
    }
}
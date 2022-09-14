import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb;
    static int[][] dp;
    static int[][] arr;
    static int N;
    static int finishBit=0;
    static int INF=987654321;

    static int recursion(int n, int flag){
        if(flag==finishBit) {
            if(arr[n][0]==0)return INF;
            return arr[n][0];
        }

        if(dp[n][flag]>0)return dp[n][flag];

        dp[n][flag]=INF;

        for(int i=0;i<N;i++){
            if(arr[n][i]==0)continue;

            if((flag&(1<<i)) == 0)
                dp[n][flag]=Math.min(dp[n][flag], recursion(i,flag|(1<<i))+arr[n][i]);
        }
        return dp[n][flag];
    }



    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        sb=new StringBuilder();
        StringTokenizer st;
        N=Integer.parseInt(br.readLine());
        arr=new int[N][N];
        dp=new int[N][(1<<N)-1];
        finishBit=(1<<N)-1;

        for(int i=0;i<N;i++){
            st=new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                arr[i][j]=Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(recursion(0,1));
    }

}
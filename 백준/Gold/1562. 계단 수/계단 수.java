import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    private static StringBuilder sb;
    private static StringTokenizer st;
    private static final int DIV = 1000000000;
    private static int[][][] dp;
    private static int N;

    private static int dfs(int num, int len, int bit){
        if(dp[num][len][bit]!=0)return dp[num][len][bit];

        if(len==N){
            if(bit==1023)return 1;
            else return 0;
        }

        int total=0;
        if(num<9){
            int tmp=num+1;
            total+=dfs(tmp,len+1,(bit|(1<<tmp)));
        }

        if(num>0){
            int tmp=num-1;
            total+=dfs(tmp,len+1,(bit|(1<<tmp)));
        }
        total%=DIV;
        return dp[num][len][bit]=total;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        dp =new int[10][N+1][1<<10];

        int answer=0;
        for(int i=1;i<=9;i++){
            answer+=dfs(i,1,1<<i);
            answer%=DIV;
        }
        System.out.println(answer);
    }
}
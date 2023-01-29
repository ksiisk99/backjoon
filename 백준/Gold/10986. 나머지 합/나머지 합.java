import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static StringBuilder sb;
    private static StringTokenizer st;
    private static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        long[] arr=new long[N+1];
        int[] cnt=new int[M+1];
        long result=0;

        st = new StringTokenizer(br.readLine());
        for(int i=1;i<=N;i++){
            arr[i]=Long.parseLong(st.nextToken())+arr[i-1];
            arr[i]%=M;
            cnt[(int)arr[i]]++;
        }

        result=cnt[0];//i~j까지가 아닌 0~j까지 구간의 합이 M으로 나누어 떨어지는 경우의 수
        for(int i=0;i<M;i++){
            result+= (long) cnt[i] *(cnt[i]-1)/2; //i~j까지의 구간의 합 중 M으로 나누어 떨이지는 경우의 수 중에서 2개를 선택하는 경우의 수
        }

        System.out.println(result);
    }

}
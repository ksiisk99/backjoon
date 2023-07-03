import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());

        int[][] arr=new int[2][N];
        for(int i=0;i<2;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                arr[i][j]=Integer.parseInt(st.nextToken());
            }
        }

        Arrays.sort(arr[0]);
        Arrays.sort(arr[1]);

        int result = 0;
        for(int i=0;i<N;i++){
            result += arr[0][N-i-1]*arr[1][i];
        }
        System.out.print(result);
    }
}

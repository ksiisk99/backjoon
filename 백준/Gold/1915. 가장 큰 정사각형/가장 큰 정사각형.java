import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] arr = new int[N+1][M+1];
        int result = 0;
        
        for(int i=1;i<=N;i++){
            String s = br.readLine();
            for(int j=1;j<=M;j++){
                arr[i][j]=s.charAt(j-1)-'0';
                result = Math.max(result, arr[i][j]);
            }
        }
        
        for(int i=1;i<=N;i++){
            for(int j=1;j<=M;j++){
                if(arr[i][j]==0)continue;

                int n = Math.min(arr[i-1][j], arr[i][j-1]);
                n = Math.min(n,arr[i-1][j-1]);

                if(n!=0){
                    arr[i][j]=n+1;
                    result = Math.max(result, arr[i][j]);
                }
            }
        }

        System.out.print(result*result);
    }
}

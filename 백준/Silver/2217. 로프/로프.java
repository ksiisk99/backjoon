import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());

        int[] arr=new int[N+1];
        for(int i=1;i<=N;i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);

        int result = 0;
        for(int i=N;i>=1;i--){
            int tmp = arr[i] * (N-i+1);
            if(result<tmp){
                result=tmp;
            }
        }
        System.out.print(result);
    }
}

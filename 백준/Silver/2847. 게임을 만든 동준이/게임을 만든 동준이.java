import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());

        int[] level = new int[N];
        for(int i=0;i<N;i++){
            level[i] = Integer.parseInt(br.readLine());
        }

        int result = 0;
        for(int i=N-1;i>=1;i--){
            int tmp = level[i-1]-level[i];
            if(tmp>=0){
                result += (tmp+1);
                level[i-1] = level[i]-1;
            }
        }

        System.out.print(result);
    }
}

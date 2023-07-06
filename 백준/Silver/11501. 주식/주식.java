import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for(int t=0;t<T;t++){
            int N = Integer.parseInt(br.readLine());
            int[] money = new int[N];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=0;i<N;i++){
                money[i]=Integer.parseInt(st.nextToken());
            }

            long result =0;
            for(int i=N-1;i>=1;i--){
                int tmp = 0;
                int j =i-1;
                for(;j>=0;j--){
                    if(money[i]>money[j]){
                        tmp+=(money[i]-money[j]);
                    }else{
                        break;
                    }
                }
                i=j+1;
                result+=tmp;
            }

            sb.append(result+"\n");
        }

        System.out.print(sb);
    }
}

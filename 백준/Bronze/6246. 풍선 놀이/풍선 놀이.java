import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder answer = new StringBuilder();
    private static int S, Q;
    private static boolean[] slot;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        S = Integer.parseInt(st.nextToken());
        slot = new boolean[S + 1];
        Q = Integer.parseInt(st.nextToken());

        for (int q = 0; q < Q; q++) {
            st = new StringTokenizer(br.readLine());

            int L = Integer.parseInt(st.nextToken());
            int I = Integer.parseInt(st.nextToken());

            for (int i = L; i <= S; i += I) {
                slot[i] = true;
            }
        }
        
        int answer = 0;
        for(int i=1;i<=S;i++){
            if(!slot[i]) {
                answer++;
            }
        }

        System.out.print(answer);
    }

    private static void input() throws IOException {

    }
}
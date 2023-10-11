import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int D, N;
    private static int[] oven, pizza;


    public static void main(String[] args) throws IOException {
        input();

        for (int i = 1; i < D; i++) {
            if (oven[i - 1] < oven[i]) {
                oven[i] = oven[i - 1];
            }
        }

        int idx = 0;
        int answer = 0;
        for (int i = D - 1; i >= 0; i--) {
            if (oven[i] >= pizza[idx]) {
                idx++;
                answer = i + 1;
            }
            if (idx == N) break;
        }

        if (idx != N) {
            answer = 0;
        }
        System.out.print(answer);
    }


    private static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        D = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        oven = new int[D];
        pizza = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < D; i++) {
            oven[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            pizza[i] = Integer.parseInt(st.nextToken());
        }
    }

}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder sb = new StringBuilder();
    private static int N;
    private static int[] 주식;

    public static void main(String[] args) throws IOException {
        input();

        int buy = Integer.MAX_VALUE;
        int answer = 0;

        for (int i = 0; i < N; i++) {
            if (buy > 주식[i]) {
                buy = 주식[i];
            } else {
                int sell = 주식[i] - buy;
                answer = Math.max(answer, sell);
            }
        }

        System.out.print(answer);
    }

    private static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        주식 = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            주식[i] = Integer.parseInt(st.nextToken());
        }
    }

}
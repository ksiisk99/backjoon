import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder answer = new StringBuilder();
    private static int N;
    private static long[] 부서;


    public static void main(String[] args) throws IOException {
        input();

        Arrays.sort(부서);

        long answer = 부서[0];
        for (int i = 1; i < N; i++) {
            부서[i] += 부서[i-1];
            answer += 부서[i];
        }

        System.out.println(answer);
    }

    private static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        부서 = new long[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int count = Integer.parseInt(st.nextToken());
            long totalTime = 0;

            for (int j = 0; j < count; j++) {
                totalTime += Long.parseLong(st.nextToken());
            }

            부서[i] = totalTime;
        }

    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder sb = new StringBuilder();
    private static int N;
    private static long K;
    private static int[] course;

    public static void main(String[] args) throws IOException {
        input();

        int answer = 0;

        for (int i = 1; i <= N; i++) {
            K -= course[i];

            if (K < 0) {
                answer = i;
                break;
            }
        }

        if (answer == 0) {
            for (int i = N; i >= 1; i--) {
                K -= course[i];

                if (K < 0) {
                    answer = i;
                    break;
                }
            }
        }

        System.out.print(answer);
    }

    private static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Long.parseLong(st.nextToken());
        course = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            course[i] = Integer.parseInt(st.nextToken());
        }
    }

}
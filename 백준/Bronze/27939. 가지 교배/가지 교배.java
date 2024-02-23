import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder answer = new StringBuilder();
    private static int n, m, k;
    private static boolean[] 가지;

    public static void main(String[] args) throws IOException {
        input();

        String answer = "P";
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            boolean can = true;
            for (int j = 0; j < k; j++) {
                int index = Integer.parseInt(st.nextToken());
                if (!가지[index]) {
                    can = false;
                    break;
                }
            }

            if (can) {
                answer = "W";
            }
        }

        System.out.print(answer);
    }


    private static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        가지 = new boolean[n + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            if (st.nextToken().equals("W")) {
                가지[i] = true;
            }
        }

        st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

    }

}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int N, C, W;
    private static List<Integer> tree;

    public static void main(String[] args) throws IOException {
        input();

        long answer = 0;
        for (int i = 1; i <= 10000; i++) {
            long cost = calculateCost(i);

            answer = Math.max(answer, cost);
        }

        System.out.print(answer);
    }

    private static long calculateCost(int cutLength) {
        long result = 0;

        for (int length : tree) {
            if (length < cutLength) continue;

            int cnt = length / cutLength;
            int t1 = cutLength * cnt * W;

            if (length % cutLength == 0) {
                cnt--;
            }
            int t2 = cnt * C;

            if (t1 <= t2) continue;
            result += (t1 - t2);
        }

        return result;
    }


    private static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        tree = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            tree.add(Integer.parseInt(br.readLine()));
        }
    }

}
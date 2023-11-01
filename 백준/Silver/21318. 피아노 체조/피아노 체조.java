import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int N, Q;
    private static int[] arr;

    public static void main(String[] args) throws IOException {
        input();
    }

    private static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        arr = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        int before = 0;
        for (int i = 1; i <= N; i++) {
            int n = Integer.parseInt(st.nextToken());
            if (before > n) {
                arr[i - 1]++;
            }
            arr[i] += arr[i - 1];
            before = n;
        }

        StringBuilder sb = new StringBuilder();
        Q = Integer.parseInt(br.readLine());
        for (int q = 0; q < Q; q++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            sb.append(arr[y - 1] - arr[x - 1]);
            sb.append("\n");
        }

        System.out.print(sb.toString());
    }
}

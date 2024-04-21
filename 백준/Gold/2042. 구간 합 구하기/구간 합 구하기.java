import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder sb = new StringBuilder();
    private static int N, M, K;
    private static long[] tree, arr;


    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new long[N + 1];
        for (int i = 1; i <= N; i++) {
            arr[i] = Long.parseLong(br.readLine());
        }

        tree = createTree();
        init(1, N, 1);

        for (int i = 0; i < M + K; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long c = Long.parseLong(st.nextToken());

            if (a == 1) {
                long diff = c - arr[b];
                arr[b] = c;
                update(1, N, 1, b, diff);
            } else {
                sb.append(sum(1, N, b, (int) c, 1) + "\n");
            }
        }

        System.out.print(sb.toString());
    }

    private static void update(int start, int end, int node, int b, long diff) {
        if (b < start || b > end) {
            return;
        }

        tree[node] += diff;
        if (start == end) {
            return;
        }

        int mid = (start + end) / 2;
        update(start, mid, node * 2, b, diff);
        update(mid + 1, end, node * 2 + 1, b, diff);

    }

    private static long sum(int start, int end, int left, int right, int node) {
        if (left > end || right < start) {
            return 0;
        }

        if (left <= start && end <= right) {
            return tree[node];
        }

        int mid = (start + end) / 2;

        long leftSum = sum(start, mid, left, right, node * 2);
        long rightSum = sum(mid + 1, end, left, right, node * 2 + 1);

        return leftSum + rightSum;
    }

    private static long[] createTree() {
        int h = (int) Math.ceil(Math.log(N) / Math.log(2)) + 1;
        int size = (int) Math.pow(2, h);

        return new long[size];
    }

    private static long init(int start, int end, int node) {
        if (start == end) {
            return tree[node] = arr[start];
        }

        int mid = (start + end) / 2;

        long left = init(start, mid, node * 2);
        long right = init(mid + 1, end, node * 2 + 1);

        return tree[node] = (left + right);
    }

    private static void input() throws IOException {


    }
}

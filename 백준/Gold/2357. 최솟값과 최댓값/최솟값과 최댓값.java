import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.function.IntBinaryOperator;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder sb = new StringBuilder();
    private static int N, M, min, max;
    private static int[] maxTree, minTree, arr;


    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        maxTree = createTree();
        minTree = createTree();
        init(maxTree, 1, N, 1, Math::max);
        init(minTree, 1, N, 1, Math::min);

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            min = Integer.MAX_VALUE;
            max = -1;
            find(maxTree, 1, N, a, b, 1, true);
            find(minTree, 1, N, a, b, 1, false);

            sb.append(min + " " + max + "\n");
        }

        System.out.print(sb.toString());
    }

    private static void find(int[] tree, int start, int end, int left, int right, int node, boolean type) {
        if (left > end || right < start) {
            return;
        }

        if (left <= start && end <= right) {
            if(type) {
                max = Math.max(max, tree[node]);
            } else {
                min = Math.min(min, tree[node]);
            }
            return;
        }

        int mid = (start + end) / 2;
        find(tree, start, mid, left, right, node * 2, type);
        find(tree, mid + 1, end, left, right, node * 2 + 1, type);
    }

    private static int[] createTree() {
        int h = (int) Math.ceil(Math.log(N) / Math.log(2)) + 1;
        int size = (int) Math.pow(2, h);

        return new int[size];
    }

    private static int init(int[] tree, int start, int end, int node, IntBinaryOperator operator) {
        if (start == end) {
            return tree[node] = arr[start];
        }

        int mid = (start + end) / 2;

        int left = init(tree, start, mid, node * 2, operator);
        int right = init(tree, mid + 1, end, node * 2 + 1, operator);

        return tree[node] = operator.applyAsInt(left, right);
    }

    private static void input() throws IOException {

    }
}

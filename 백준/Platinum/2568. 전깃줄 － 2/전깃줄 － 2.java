import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static StringBuilder sb = new StringBuilder();

    static class Node implements Comparable<Node> {
        int a, b;

        public Node(int a, int b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public int compareTo(Node o) {
            return a - o.a;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        Node[] nodes = new Node[N];
        Node[] trace = new Node[N];
        boolean[] visit = new boolean[500001];
        int[] lis = new int[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            nodes[i] = new Node(a, b);
            visit[a] = true;
        }
        Arrays.sort(nodes);

        int idx = -1;
        for (int i = 0; i < N; i++) {
            if (idx == -1 || lis[idx] < nodes[i].b) {
                lis[++idx] = nodes[i].b;
                trace[i] = new Node(idx, nodes[i].a);
            } else {
                int tmp = binarySearch(lis, idx, nodes[i].b);
                lis[tmp - 1] = nodes[i].b;
                trace[i] = new Node(tmp - 1, nodes[i].a);
            }
        }

        sb.append(N - (idx+1));
        sb.append("\n");

        for (int i = N - 1; i >= 0; i--) {
            if (trace[i].a == idx) {
                visit[trace[i].b] = false;
                idx--;
            }
        }

        for (int i = 0; i < N; i++) {
            if (visit[nodes[i].a]) {
                sb.append(nodes[i].a);
                sb.append("\n");
            }
        }
        System.out.print(sb.toString());
    }

    private static int binarySearch(int[] lis, int size, int b) {
        int left = 0, right = size;
        while (left < right) {
            int mid = (left + right) / 2;
            if (lis[mid] < b) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return right + 1;
    }

}
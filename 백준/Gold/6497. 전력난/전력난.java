import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class Main {
    private static StringBuilder sb;
    private static StringTokenizer st;
    private static int[] parent;

    static class Node implements Comparable<Node> {
        int x;
        int y;
        int cost;

        public Node(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return cost - o.cost;
        }
    }

    static int find(int x) {
        if (x == parent[x]) return x;
        return parent[x] = find(parent[x]);
    }

    static void union(int a, int b) {
        if (a < b) {
            parent[b] = a;
            return;
        }
        parent[a] = b;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        while (true) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            if (N == 0 && M == 0) break;

            parent = new int[N];
            PriorityQueue<Node> adj = new PriorityQueue<>();
            for (int i = 0; i < N; i++) {
                parent[i] = i;
            }

            int total = 0;
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int cost = Integer.parseInt(st.nextToken());
                total += cost;
                adj.add(new Node(x, y, cost));
            }

            int minTotal = 0;
            while (!adj.isEmpty()) {
                Node node = adj.poll();
                int x = node.x;
                int y = node.y;
                x = find(x);
                y = find(y);
                if (x != y) {
                    union(x, y);
                    minTotal += node.cost;
                }
            }
            sb.append(total - minTotal).append("\n");
        }

        System.out.print(sb.toString());

    }

}
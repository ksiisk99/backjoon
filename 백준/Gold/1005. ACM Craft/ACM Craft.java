import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


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

        int T = Integer.parseInt(br.readLine());
        for (int t = 0;t < T; t++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int[] cost = new int[N + 1];
            int[] degree = new int[N + 1];
            int[] maxCost = new int[N + 1];
            int[] originalDegree=new int[N+1];

            parent = new int[N + 1];
            List<Integer>[] list = new ArrayList[N + 1];

            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++) {
                parent[i] = i;
                list[i] = new ArrayList<Integer>();
                cost[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                list[a].add(b);
                degree[b]++;
            }
            int W = Integer.parseInt(br.readLine());

            Queue<Integer> queue = new LinkedList<>();
            for (int i = 1; i <= N; i++) {
                if (degree[i] == 0) {
                    queue.add(i);
                    maxCost[i]=cost[i];
                }
            }

            while (!queue.isEmpty()) {
                int idx = queue.poll();

                for (int next : list[idx]) {
                    degree[next]--;
                    maxCost[next]=Math.max(maxCost[idx]+cost[next],maxCost[next]);
                    if(degree[next]==0){
                        queue.add(next);
                    }
                }

            }

            sb.append(maxCost[W]).append("\n");
        }

        System.out.print(sb.toString());

    }

}
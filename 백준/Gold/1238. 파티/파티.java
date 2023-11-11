import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int N, X;
    private static List<int[]>[] edges, reverseEdges;

    public static void main(String[] args) throws IOException {
        input();

        int[] dist = dijkstra(edges);
        int[] reverseDist = dijkstra(reverseEdges);

        int answer = 0;
        for (int i = 1; i <= N; i++) {
            answer = Math.max(answer, dist[i] + reverseDist[i]);
        }

        System.out.print(answer);
    }

    private static int[] dijkstra(List<int[]>[] edges) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        int[] dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        boolean[] check = new boolean[N + 1];

        dist[X] = 0;
        pq.add(new int[]{X, 0});
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();

            if (check[cur[0]]) continue;
            check[cur[0]] = true;

            for (int[] next : edges[cur[0]]) {
                if (dist[next[0]] > dist[cur[0]] + next[1]) {
                    dist[next[0]] = dist[cur[0]] + next[1];
                    pq.offer(new int[]{next[0], dist[next[0]]});
                }
            }
        }

        return dist;
    }

    private static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        edges = new ArrayList[N + 1];
        reverseEdges = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) {
            edges[i] = new ArrayList<>();
            reverseEdges[i] = new ArrayList<>();
        }
        int M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            edges[a].add(new int[]{b, c});
            reverseEdges[b].add(new int[]{a, c});
        }
    }
}

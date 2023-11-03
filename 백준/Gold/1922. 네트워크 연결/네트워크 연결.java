import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int N, M;
    private static PriorityQueue<int[]> edges = new PriorityQueue<>((a, b) -> a[2] - b[2]);
    private static int[] parent;

    private static int find(int a) {
        if (a == parent[a]) return a;
        return parent[a] = find(parent[a]);
    }

    private static void union(int a, int b) {
        if (a < b) {
            parent[b] = a;
            return;
        }
        parent[a] = b;
    }

    public static void main(String[] args) throws IOException {
        input();

        int answer = 0;

        while (!edges.isEmpty()) {
            int[] edge = edges.poll();
            int a = find(edge[0]);
            int b = find(edge[1]);
            int cost = edge[2];

            if (a != b) {
                answer += cost;
                union(a, b);
            }
        }

        System.out.print(answer);
    }

    private static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        parent = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }

        M = Integer.parseInt(br.readLine());

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            edges.add(new int[]{a, b, c});
        }
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static StringBuilder sb = new StringBuilder();
    private static int result, N, M, n1, n2;
    private static ArrayList<Integer>[] list;
    private static boolean[] visit;

    public static void main(String[] args) throws IOException {
        input();

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{n1, 0});

        int result = -1;
        while (!queue.isEmpty()) {
            int[] node = queue.poll();
            int n = node[0];
            int cnt = node[1];
            if (n == n2) {
                result = cnt;
                break;
            }

            visit[n] = true;
            for (int next : list[n]) {
                if (!visit[next]) {
                    queue.add(new int[]{next, cnt + 1});
                }
            }
        }

        System.out.print(result);
    }


    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        list = new ArrayList[N + 1];
        visit = new boolean[N + 1];
        for (int i = 1; i <= N; i++) list[i] = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        n1 = Integer.parseInt(st.nextToken());
        n2 = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(br.readLine());

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list[a].add(b);
            list[b].add(a);
        }
    }

}
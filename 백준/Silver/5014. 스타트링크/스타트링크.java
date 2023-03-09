import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static StringBuilder sb = new StringBuilder();
    private static int F, S, G, U, D;
    private static boolean[] visit;

    public static void main(String[] args) throws IOException {
        input();

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{S, 0});

        visit[S] = true;
        int result = -1;
        while (!queue.isEmpty()) {
            int[] node = queue.poll();
            int floor = node[0];
            int cnt = node[1];

            if (floor == G) {
                result = cnt;
                break;
            }

            if ((floor + U) <= F && !visit[floor + U]) {
                visit[floor + U] = true;
                queue.add(new int[]{floor + U, cnt + 1});
            }

            if ((floor - D) >= 1 && !visit[floor - D]) {
                visit[floor - D] = true;
                queue.add(new int[]{floor - D, cnt + 1});
            }
        }

        System.out.print(result == -1 ? "use the stairs" : result);
    }


    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        F = Integer.parseInt(st.nextToken());
        visit = new boolean[F + 1];
        S = Integer.parseInt(st.nextToken());
        G = Integer.parseInt(st.nextToken());
        U = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
    }

}
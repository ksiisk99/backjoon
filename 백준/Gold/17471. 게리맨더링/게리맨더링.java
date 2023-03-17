import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static StringBuilder sb = new StringBuilder();
    private static int result, N, totalScore, cnt;
    private static ArrayList<Integer>[] adjust;
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int[] people, visit, area;


    public static void main(String[] args) throws IOException {
        result = Integer.MAX_VALUE;
        input();
        zoning(0);
        System.out.print(result == Integer.MAX_VALUE ? -1 : result);
    }

    private static void zoning(int cnt) {
        if (cnt > N) {
            int sumA = 0;
            int sumB = 0;
            for (int i = 1; i <= N; i++) {
                if (area[i] == 1) {
                    sumA += people[i];
                } else {
                    sumB += people[i];
                }
            }

            visit = new int[N + 1];
            int link = 0;
            for (int i = 1; i <= N; i++) {
                if (visit[i] == 0) {
                    bfs(i, area[i]);
                    link++;
                }
            }

            if (link == 2) {
                result = Math.min(result, Math.abs(sumA - sumB));
            }
            return;
        }

        area[cnt] = 1;
        zoning(cnt + 1);

        area[cnt] = 2;
        zoning(cnt + 1);
    }

    private static void bfs(int i, int state) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(i);

        visit[i] = 1;
        while (!queue.isEmpty()) {
            int node = queue.poll();

            for (int next : adjust[node]) {
                if (visit[next] == 0 && area[next]==state) {
                    visit[next] = 1;
                    queue.add(next);
                }
            }
        }
    }

    private static void input() throws IOException {
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        adjust = new ArrayList[N + 1];
        people = new int[N + 1];
        area = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            people[i] = Integer.parseInt(st.nextToken());
            adjust[i] = new ArrayList<>();
            totalScore += people[i];
        }

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int cnt = Integer.parseInt(st.nextToken());
            for (int j = 0; j < cnt; j++) {
                int node = Integer.parseInt(st.nextToken());
                adjust[i].add(node);
            }
        }
    }

}
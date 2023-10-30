import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int N, M;
    private static List<Integer>[] edges;
    private static List<Integer> answer = new ArrayList<>();
    private static boolean[] visit;
    private static int[] visitCount;
    private static int max;

    public static void main(String[] args) throws IOException {
        input();

        for (int i = 1; i <= N; i++) {
            visit = new boolean[N + 1];
            dfs(i);
        }

        findMax();
        print();
    }

    private static void findMax() {
        for (int i = 1; i <= N; i++) {
            if (visitCount[i] > max) {
                max = visitCount[i];
            }
        }
    }

    private static void print() {
        StringBuilder sb = new StringBuilder();
        
        for (int i = 1; i <= N; i++) {
            if (visitCount[i] == max) {
                max = visitCount[i];
                sb.append(i);
                sb.append(" ");
            }
        }
        System.out.print(sb.toString());
    }

    private static void dfs(int num) {
        visit[num] = true;
        for (int next : edges[num]) {
            if (!visit[next]) {
                visitCount[next]++;
                dfs(next);
            }
        }
    }

    private static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        edges = new ArrayList[N + 1];
        visitCount = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            edges[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            edges[A].add(B);
        }
    }
}
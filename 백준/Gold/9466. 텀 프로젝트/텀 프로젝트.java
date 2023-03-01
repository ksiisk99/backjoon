import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static StringBuilder sb = new StringBuilder();
    private static int result, N, M;
    private static boolean[] visit;
    private static boolean[] cycle;
    private static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            arr = new int[N + 1];
            visit = new boolean[N + 1];
            cycle = new boolean[N + 1];
            for (int i = 1; i <= N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            result = 0;
            for (int i = 1; i <= N; i++) {
                if (!visit[i]) {
                    dfs(i);
                }
            }

            sb.append(N - result);
            sb.append("\n");
        }

        System.out.print(sb.toString());

    }

    private static void dfs(int student) {
        visit[student] = true;
        int nextStudent = arr[student];

        if (!visit[nextStudent]) {
            dfs(nextStudent);
        } else if (!cycle[nextStudent]) {
            result++;
            for(int next=nextStudent; next != student; next = arr[next]){
                result++;
            }
        }
        cycle[student] = true;
    }

}
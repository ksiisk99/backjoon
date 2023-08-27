import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int N, M, H;
    private static int[][] ladder;
    private static int answer = Integer.MAX_VALUE;
    private static List<int[]> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        input();

        backtracking(-1, 0);

        System.out.print(answer == Integer.MAX_VALUE ? -1 : answer);
    }

    private static void backtracking(int idx, int cnt) {
        if (cnt > 3 || answer <= cnt) return;

        if (checkFinish()) {
            answer = Math.min(answer, cnt);
            return;
        }

        for (int i = idx + 1; i < list.size(); i++) {
            int[] info = list.get(i);
            int x = info[0];
            int y = info[1];
            int next = y + 1;

            if (ladder[x][y] == 0 && ladder[x][next] == 0) {
                ladder[x][y] = next;
                ladder[x][next] = y;
                backtracking(i, cnt + 1);
                ladder[x][y] = 0;
                ladder[x][next] = 0;
            }

        }
    }

    public static boolean checkFinish() {
        for (int i = 1; i <= N; i++) {
            int idx = i;
            for (int j = 1; j <= H; j++) {
                if (ladder[j][idx] > 0) {
                    idx = ladder[j][idx];
                }
            }

            if (idx != i) {
                return false;
            }
        }

        return true;
    }


    public static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        ladder = new int[H + 1][N + 1]; //가로선, 세로선

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            ladder[a][b] = b + 1;
            ladder[a][b + 1] = b;
        }

        for (int i = 1; i <= H; i++) {
            for (int j = 1; j <= N; j++) {
                int next = j + 1;
                if (next <= N && ladder[i][j] == 0 && ladder[i][next] == 0) {
                    list.add(new int[]{i, j});
                }
            }
        }
    }

}
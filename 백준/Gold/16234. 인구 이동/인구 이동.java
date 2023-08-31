import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int N, L, R, answer = 0;
    private static int[][] board;
    private static int[][] visit;
    private static int[] dx = {0, 0, 1, -1};
    private static int[] dy = {1, -1, 0, 0};
    private static List<Integer> infos;

    static class Info {
        int cnt;
        int sum;

        public Info(int cnt, int sum) {
            this.cnt = cnt;
            this.sum = sum;
        }
    }


    public static void main(String[] args) throws IOException {
        input();
        visit = new int[N][N];

        while (true) {
            int cnt = 1;
            infos = new ArrayList<>();

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (visit[i][j] == 0) {
                        Info info = dfs(i, j, cnt);
                        infos.add(info.sum / info.cnt);
                        cnt++;
                    }
                }
            }

            if (cnt == (N * N) + 1) {
                break;
            }

            int num = 1;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (visit[i][j] == num) {
                        bfs(i, j, num);
                        num++;
                    }
                }
                if (num == cnt) break;
            }

            answer++;
        }

        System.out.print(answer);
    }

    private static void bfs(int a, int b, int num) {
        Queue<int[]> queue = new LinkedList<>();
        int result = infos.get(num - 1);
        visit[a][b] = 0;
        queue.add(new int[]{a, b});

        while (!queue.isEmpty()) {
            int[] coord = queue.poll();
            int x = coord[0];
            int y = coord[1];
            board[x][y] = result;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;

                if (visit[nx][ny] == num) {
                    visit[nx][ny] = 0;
                    queue.add(new int[]{nx, ny});
                }
            }
        }


    }

    private static Info dfs(int x, int y, int num) {
        //System.out.println(x + " " + y);
        int sum = board[x][y];
        int cnt = 1;
        visit[x][y] = num;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;

            int diff = Math.abs(board[x][y] - board[nx][ny]);
            if (diff < L || diff > R) continue;

            if (visit[nx][ny] == 0) {
                Info info = dfs(nx, ny, num);
                sum += info.sum;
                cnt += info.cnt;
            }
        }
        return new Info(cnt, sum);
    }

    public static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        board = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

    }

}
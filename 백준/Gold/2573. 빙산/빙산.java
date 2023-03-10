import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static StringBuilder sb = new StringBuilder();
    private static int N, M;
    private static int[][] area;
    private static int[][] visit;
    private static int[] dx = {0, 0, 1, -1};
    private static int[] dy = {1, -1, 0, 0};
    private static Queue<int[]> queue;

    public static void main(String[] args) throws IOException {
        input();
        int year = 0;
        while (true) {
            int size = queue.size();
            Queue<int[]> tmpQueue = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                int[] node = queue.poll();
                int x = node[0];
                int y = node[1];

                int height = meltIce(x, y);
                tmpQueue.add(new int[]{x, y, height});
            }

            while (!tmpQueue.isEmpty()) {
                int[] node = tmpQueue.poll();
                int x = node[0];
                int y = node[1];
                int height = node[2];
                area[x][y] = height;
                if (height > 0) {
                    queue.add(new int[]{x, y});
                }
            }
            size = queue.size();
            if (size == 0) {
                year = 0;
                break;
            }

            visit = new int[N][M];
            int num = 0;
            for (int i = 0; i < size; i++) {
                int[] node = queue.poll();
                int x = node[0];
                int y = node[1];
                if (visit[x][y] == 0) {
                    num++;
                    dfs(num, x, y);
                }
                queue.add(new int[]{x, y});
            }
            year++;
            if (num >= 2) {
                break;
            }

        }
        System.out.println(year);
    }

    private static int meltIce(int x, int y) {
        int height = area[x][y];
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx < 0 || ny < 0 || nx >= N || ny >= M || area[nx][ny] > 0) continue;
            height--;
        }
        return height;
    }

    private static void dfs(int num, int x, int y) {
        visit[x][y] = num;
        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];

            if (nx < 0 || ny < 0 || nx >= N || ny >= M || visit[nx][ny] > 0 || area[nx][ny] <= 0) continue;
            dfs(num, nx, ny);
        }
    }


    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        area = new int[N][M];
        queue = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                area[i][j] = Integer.parseInt(st.nextToken());
                if (area[i][j] > 0) {
                    queue.add(new int[]{i, j});
                }
            }
        }
    }

}
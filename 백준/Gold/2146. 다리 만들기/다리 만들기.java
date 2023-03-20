import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static StringBuilder sb = new StringBuilder();
    private static int N;
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int[][] board;
    private static boolean[][] visit;
    private static int[] dx = {1, -1, 0, 0};
    private static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        input();

        int number = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j] == -1) {
                    numbering(++number, i, j);
                }
            }
        }

        int[] dist = new int[number + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j] > 0) {
                    calculateDist(i, j, dist);
                }
            }
        }

        System.out.print(findMinDist(dist));
    }

    private static int findMinDist(int[] dist) {
        int result = Integer.MAX_VALUE;
        for (int i = 1; i < dist.length; i++) {
            result = Math.min(result, dist[i]);
        }
        return result;
    }

    private static void calculateDist(int X, int Y, int[] dist) {
        Queue<int[]> queue = new LinkedList<>();
        int number = board[X][Y];
        visit = new boolean[N][N];
        queue.add(new int[]{X, Y, 0});
        visit[X][Y]=true;

        while (!queue.isEmpty()) {
            int[] info = queue.poll();
            int x = info[0];
            int y = info[1];
            int cnt = info[2];
            if (dist[number] <= cnt) {
                continue;
            }

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx < 0 || ny < 0 || nx >= N || ny >= N || visit[nx][ny]) continue;
                if (board[nx][ny] == 0) {
                    visit[nx][ny]=true;
                    queue.add(new int[]{nx, ny, cnt + 1});
                } else if (board[nx][ny] != number) {
                    dist[number] = Math.min(dist[number], cnt);
                }
            }
        }
    }

    private static void numbering(int number, int x, int y) {
        board[x][y] = number;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
            if (board[nx][ny] == -1) {
                numbering(number, nx, ny);
            }
        }
    }

    private static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        board = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if (board[i][j] == 1) board[i][j] = -1;
            }
        }
    }
}


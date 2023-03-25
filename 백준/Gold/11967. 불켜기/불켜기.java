import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static StringBuilder sb = new StringBuilder();
    private static int N, K, M;
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int[][] board;
    private static boolean[][] visit;
    private static int[] dx = {1, -1, 0, 0};
    private static int[] dy = {0, 0, 1, -1};
    private static List<int[]>[][] list;


    public static void main(String[] args) throws IOException {
        input();
        System.out.println(turnLight());
    }

    private static int turnLight() {
        int light = 1;
        visit[1][1] = true;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{1, 1});

        while (!queue.isEmpty()) {
            int[] info = queue.poll();
            int x = info[0];
            int y = info[1];

            for (int[] next : list[x][y]) {
                int nx = next[0];
                int ny = next[1];
                if (visit[nx][ny]) continue;

                if(board[nx][ny]==0){
                    board[nx][ny] = 1;
                    light++;
                }
                
                for (int i = 0; i < 4; i++) {
                    int nnx = nx + dx[i];
                    int nny = ny + dy[i];
                    if (nnx < 1 || nnx > N || nny < 1 || nny > N) continue;
                    if (board[nnx][nny] == 1 && visit[nnx][nny]) {
                        visit[nx][ny] = true;
                        queue.add(new int[]{nx, ny});
                        break;
                    }
                }
            }
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx < 1 || nx > N || ny < 1 || ny > N) continue;
                if (board[nx][ny] == 1 && !visit[nx][ny]) {
                    visit[nx][ny] = true;
                    queue.add(new int[]{nx, ny});
                }
            }
        }
        return light;
    }

    private static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        list = new ArrayList[N + 1][N + 1];

        board = new int[N + 1][N + 1];
        board[1][1] = 1;
        visit = new boolean[N + 1][N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (list[x][y] == null) {
                list[x][y] = new ArrayList<>();
            }
            if(list[a][b]==null){
                list[a][b]=new ArrayList<>();
            }
            list[x][y].add(new int[]{a, b});
        }
    }
}


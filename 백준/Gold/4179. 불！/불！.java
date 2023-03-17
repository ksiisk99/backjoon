import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static StringBuilder sb = new StringBuilder();
    private static int R, C, fX, fY, jX, jY;
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int[][] board;
    private static Queue<int[]> queue;
    private static final int WALL = -2;
    private static final int LOAD = -3;
    private static int[] dx = {0, 0, 1, -1};
    private static int[] dy = {1, -1, 0, 0};
    private static boolean[][] visit;


    public static void main(String[] args) throws IOException {
        input();

        moveFire();
        moveJihoon();


        System.out.println("IMPOSSIBLE");
    }

    private static void moveJihoon() {
        queue = new LinkedList<>();
        queue.add(new int[]{jX, jY, 1});
        while (!queue.isEmpty()) {
            int[] info = queue.poll();
            int x = info[0];
            int y = info[1];
            int time = info[2];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx < 0 || ny < 0 || nx >= R || ny >= C) {
                    System.out.println(time);
                    System.exit(0);
                }
                if (!visit[nx][ny] && (board[nx][ny] > time || board[nx][ny]==LOAD)) {
                    visit[nx][ny]=true;
                    queue.add(new int[]{nx, ny, time + 1});
                }
            }
        }
    }

    private static void moveFire() {
        while (!queue.isEmpty()) {
            int[] info = queue.poll();
            int x = info[0];
            int y = info[1];
            int time = info[2] + 1;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx < 0 || ny < 0 || nx >= R || ny >= C) continue;

                if (board[nx][ny] == LOAD) {
                    board[nx][ny] = time;
                    queue.add(new int[]{nx, ny, time});
                }
            }
        }
    }

    private static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        board = new int[R][C];
        visit = new boolean[R][C];
        queue = new LinkedList<>();

        for (int i = 0; i < R; i++) {
            String s = br.readLine();
            for (int j = 0; j < C; j++) {
                char c = s.charAt(j);
                if (c == 'J') {
                    visit[i][j]=true;
                    board[i][j] = LOAD;
                    jX = i;
                    jY = j;
                } else if (c == 'F') {
                    visit[i][j]=true;
                    board[i][j] = 0;
                    fX = i;
                    fY = j;
                    queue.add(new int[]{fX, fY, 0});
                } else if (c == '#') {
                    board[i][j] = WALL; //벽
                } else {
                    board[i][j] = LOAD;
                }
            }
        }
    }

}
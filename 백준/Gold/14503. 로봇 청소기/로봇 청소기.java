import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static StringBuilder sb = new StringBuilder();
    private static int N, M, result;
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static Robot robot;
    private static int[][] room;
    private static int[] dx = {-1, 0, 1, 0};//북동남서
    private static int[] dy = {0, 1, 0, -1};

    static class Robot {
        int x;
        int y;
        int d;

        public Robot(int x, int y, int d) {
            this.x = x;
            this.y = y;
            this.d = d;
        }
    }


    public static void main(String[] args) throws IOException {
        input();
        dfs(robot.x, robot.y, robot.d);
        System.out.print(result);
    }

    private static void dfs(int x, int y, int d) {
        if(room[x][y]==0)result++;
        room[x][y] = 2; //청소 완료

        int nd = d;
        int nx;
        int ny;

        for (int i = 0; i < 4; i++) {
            nd = (nd - 1) < 0 ? 3 : (nd - 1);
            nx = x + dx[nd];
            ny = y + dy[nd];
            if (nx < 0 || ny < 0 || nx >= N || ny >= M || room[nx][ny] != 0) {
                continue;
            }

            nx = x + dx[nd];
            ny = y + dy[nd];
            if (room[nx][ny] == 0) {
                dfs(nx, ny, nd);
                return;
            }
        }

        nd = calcDirection(d);
        nx = x + dx[nd];
        ny = y + dy[nd];
        if (nx >= 0 && ny >= 0 && nx < N && ny < M && room[nx][ny] != 1) {
            dfs(nx, ny, d);
        }
    }

    private static int calcDirection(int d) {
        switch (d) {
            case 0:
                return 2;
            case 1:
                return 3;
            case 2:
                return 0;
        }
        return 1;
    }

    private static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        room = new int[N][M];

        st = new StringTokenizer(br.readLine());
        robot = new Robot(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                room[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

}
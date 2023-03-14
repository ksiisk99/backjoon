import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private static StringBuilder sb = new StringBuilder();
    private static int N, M, D, result, numberOfEnemy;
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int[][] board;
    private static int[] archer;

    static class Coordinate {
        int x;
        int y;
        int dist;

        public Coordinate(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        placeArcher(0, -1);
        System.out.print(result);
    }

    private static void placeArcher(int cnt, int idx) {
        if (cnt == 3) {
            result = Math.max(result, defense());
            return;
        }

        for (int i = idx + 1; i < M; i++) {
            archer[cnt] = i;
            placeArcher(cnt + 1, i);
        }
    }

    private static int defense() {
        int[][] tmpBoard = new int[N][M];
        int totalEnemy = numberOfEnemy;

        for (int i = 0; i < N; i++) tmpBoard[i] = Arrays.copyOf(board[i], M);

        int kill = 0;

        Coordinate[] coordinates = new Coordinate[3];
        for (int i = 0; i < 3; i++) coordinates[i] = new Coordinate(100, 100, Integer.MAX_VALUE);

        while (totalEnemy > 0) {
            for (int x = 0; x < N; x++) {
                for (int y = 0; y < M; y++) {
                    if (tmpBoard[x][y] == 0) continue;

                    for (int i = 0; i < 3; i++) {
                        int dist = calcDist(x, y, N, archer[i]);
                        if (dist > D) continue;

                        if (dist <= coordinates[i].dist) {
                            if (dist == coordinates[i].dist && coordinates[i].y < y) {
                                continue;
                            }
                            coordinates[i].x = x;
                            coordinates[i].y = y;
                            coordinates[i].dist = dist;
                        }
                    }
                }
            }

            for(int i=0;i<3;i++){
                int x = coordinates[i].x;
                int y = coordinates[i].y;
                if(x==100 && y==100)continue;

                if(tmpBoard[x][y]==1){
                    kill++;
                    tmpBoard[x][y]=0;
                    totalEnemy--;
                }
                coordinates[i].x=100;
                coordinates[i].y=100;
                coordinates[i].dist=Integer.MAX_VALUE;
            }
            totalEnemy = moveEnemy(tmpBoard, totalEnemy);
        }
        return kill;
    }

    private static int calcDist(int x, int y, int x2, int y2) {
        return Math.abs(x - x2) + Math.abs(y - y2);
    }

    private static int moveEnemy(int[][] tmpBoard, int totalEnemy) {
        for (int i = N - 1; i >= 0; i--) {
            for (int j = 0; j < M; j++) {
                if (tmpBoard[i][j] == 1) {
                    int nx = i + 1;
                    if (nx == N) {
                        totalEnemy--;
                    } else {
                        tmpBoard[nx][j] = 1;
                    }
                }
                tmpBoard[i][j] = 0;
            }
        }
        return totalEnemy;
    }

    private static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        board = new int[N + 1][M];
        archer = new int[3];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if (board[i][j] == 1) {
                    numberOfEnemy++;
                }
            }
        }
    }

}
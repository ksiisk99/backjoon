import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int R, C, T;
    private static int[][] room;
    private static int[] cleaner;
    private static int[] dx = {0, 0, -1, 1};
    private static int[] dy = {1, -1, 0, 0};


    public static void main(String[] args) throws IOException {
        input();

        for (int i = 0; i < T; i++) {
            diffusion();

            clean();
        }

        System.out.print(calcResult());
    }

    private static void print(){
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                System.out.print(room[i][j]+" ");
            }
            System.out.println();
        }
    }

    private static int calcResult() {
        int result = 2;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                result += room[i][j];
            }
        }

        return result;
    }

    private static void clean() {
        topClean();
        bottomClean();
    }

    private static void bottomClean() {
        int x = cleaner[0];

        for (int i = x - 1; i > 0; i--) {
            room[i][0] = room[i - 1][0];
        }

        int col = C - 1;
        for (int i = 0; i < col; i++) {
            room[0][i] = room[0][i + 1];
        }

        for (int i = 0; i < x; i++) {
            room[i][col] = room[i + 1][col];
        }

        for (int i = col; i > 1; i--) {
            room[x][i] = room[x][i - 1];
        }

        room[x][1] = 0;
    }

    private static void topClean() {
        int x = cleaner[1];

        int row = R - 1;
        for (int i = x + 1; i < row; i++) {
            room[i][0] = room[i + 1][0];
        }

        int col = C - 1;
        for (int i = 0; i < col; i++) {
            room[row][i] = room[row][i + 1];
        }

        for (int i = row; i > x; i--) {
            room[i][col] = room[i - 1][col];
        }

        for (int i = col; i > 1; i--) {
            room[x][i] = room[x][i - 1];
        }

        room[x][1] = 0;
    }

    private static void diffusion() {
        int[][] tmp = new int[R][C];
        tmp[cleaner[0]][0]=-1;
        tmp[cleaner[1]][0]=-1;

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (room[i][j] > 0) {
                    int num = room[i][j] / 5;
                    int cnt = 0;
                    for (int d = 0; d < 4; d++) {
                        int nx = i + dx[d];
                        int ny = j + dy[d];

                        if (nx < 0 || ny < 0 || nx >= R || ny >= C || room[nx][ny] == -1) continue;
                        cnt++;
                        tmp[nx][ny] += num;
                    }
                    tmp[i][j] += room[i][j] - (num * cnt);
                }
            }
        }

        room = tmp;
    }


    public static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        room = new int[R][C];
        cleaner = new int[2];
        cleaner[0] = -1;

        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                room[i][j] = Integer.parseInt(st.nextToken());
                if (room[i][j] == -1 && cleaner[0] == -1) {
                    cleaner[0] = i;
                    cleaner[1] = i + 1;
                }
            }
        }

    }

}
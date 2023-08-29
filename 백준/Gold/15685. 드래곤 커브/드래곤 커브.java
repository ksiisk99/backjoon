import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int N;
    private static List<int[]> infos = new ArrayList<>();
    private static int SIZE = 101;
    private static boolean[][] board = new boolean[SIZE][SIZE];
    private static int[] dy = {0, -1, 0, 1};
    private static int[] dx = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        input();

        for (int[] info : infos) {
            int x = info[0];
            int y = info[1];
            int d = info[2];
            int g = info[3];

            board[y][x] = true;
            y += dy[d];
            x += dx[d];
            board[y][x] = true;

            List<Integer> dir = new ArrayList<>();
            dir.add(d);

            createCurve(g, x, y, dir);

        }

        System.out.print(calc());
    }

    private static void createCurve(int g, int x, int y, List<Integer> dir) {
        for (int i = 1; i <= g; i++) {
            int size = dir.size();
            for (int s = size - 1; s >= 0; s--) {
                int d = (dir.get(s) + 1) % 4;
                x += dx[d];
                y += dy[d];

                board[y][x] = true;
                dir.add(d);
            }
        }

    }

    private static int calc() {
        int result = 0;
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                if (board[i][j] && board[i + 1][j] && board[i][j + 1] && board[i + 1][j + 1]) {
                    result++;
                }
            }
        }
        return result;
    }


    public static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());

            infos.add(new int[]{x, y, d, g});
        }
    }

}
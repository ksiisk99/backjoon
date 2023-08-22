import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


    public static void main(String[] args) throws IOException {
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        int N = Integer.parseInt(br.readLine());
        int[][] board = new int[N + 1][N + 1];
        int K = Integer.parseInt(br.readLine());

        for (int i = 0; i < K; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            board[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 1;
        }

        int L = Integer.parseInt(br.readLine());
        String[] direct = new String[10001];
        for (int i = 0; i < L; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            direct[Integer.parseInt(st.nextToken())] = st.nextToken();
        }

        LinkedList<int[]> snake = new LinkedList<>();
        int dir = 0;
        int time = 0;
        int x = 1;
        int y = 1;
        snake.add(new int[]{x, y});
        board[x][y]=2;

        while (true) {
            time++;
            int nx = x + dx[dir];
            int ny = y + dy[dir];

            if (nx < 1 || ny < 1 || nx > N || ny > N || board[nx][ny] == 2) break;

            if (board[nx][ny] == 0) {
                int[] tail = snake.pollLast();
                board[tail[0]][tail[1]] = 0;
            }

            board[nx][ny] = 2;
            snake.addFirst(new int[]{nx, ny});

            if (direct[time] != null) {
                dir = convertDirect(dir, direct[time]);
            }
            x = nx;
            y = ny;
        }

        System.out.println(time);
    }

    public static int convertDirect(int dir, String c) {
        if (c.equals("D")) {
            dir++;
            return dir % 4;
        }
        dir--;
        if (dir == -1) return 3;
        return dir;

    }


}
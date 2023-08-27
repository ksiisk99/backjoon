import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int N, M;
    private static int cctvCnt;
    private static int answer = Integer.MAX_VALUE;
    private static List<int[]>[] cctv = new ArrayList[6];
    private static List<int[]> list = new ArrayList<>();
    private static int[] cctvDir;
    private static int[][] board;
    private static int[] dx = {0, 0, 1, -1};
    private static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        init();
        input();
        backtracking(0);
        System.out.print(answer);
    }

    private static void init() {
        cctv[1] = new ArrayList<>(Arrays.asList(new int[]{0}, new int[]{1}, new int[]{2}, new int[]{3}));
        cctv[2] = new ArrayList<>(Arrays.asList(new int[]{0, 1}, new int[]{2, 3}));
        cctv[3] = new ArrayList<>(Arrays.asList(new int[]{0, 2}, new int[]{0, 3}, new int[]{1, 2}, new int[]{1, 3}));
        cctv[4] = new ArrayList<>(Arrays.asList(new int[]{0, 2, 1}, new int[]{3, 1, 2}, new int[]{1, 3, 0}, new int[]{2, 0, 3}));
        cctv[5] = new ArrayList<>(Arrays.asList(new int[]{0, 1, 2, 3}));
    }

    private static void backtracking(int cnt) {
        if (cnt == cctvCnt) {
            answer = Math.min(answer, fillCctv());
            return;
        }

        int[] info = list.get(cnt);
        int x = info[0];
        int y = info[1];
        int cctvNum = board[x][y];

        for (int d = 0; d < cctv[cctvNum].size(); d++) {
            cctvDir[cnt] = d;
            backtracking(cnt + 1);
        }


    }

    private static int fillCctv() {
        int[][] newBoard = new int[N][M];
        copy(board, newBoard);

        for (int i = 0; i < cctvCnt; i++) {
            int[] info = list.get(i);
            int x = info[0];
            int y = info[1];
            int cctvNum = board[x][y];

            int[] dir = cctv[cctvNum].get(cctvDir[i]);
            for (int d = 0; d < dir.length; d++) {
                fill(newBoard, x, y, dir[d]);
            }
        }

        return countSafeArea(newBoard);
    }

    private static void copy(int[][] board, int[][] newBoard) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                newBoard[i][j] = board[i][j];
            }
        }
    }

    private static void fill(int[][] newBoard, int x, int y, int dir) {
        while (true) {
            int nx = x + dx[dir];
            int ny = y + dy[dir];

            if (nx < 0 || ny < 0 || nx >= N || ny >= M) return;
            if (newBoard[nx][ny] == 6) return;
            newBoard[nx][ny] = -1;
            x = nx;
            y = ny;
        }

    }

    public static int countSafeArea(int[][] board) {
        int result = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (board[i][j] == 0) {
                    result++;
                }
            }
        }
        return result;
    }

    public static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if (board[i][j] > 0 && board[i][j] < 6) {
                    cctvCnt++;
                    list.add(new int[]{i, j});
                }
            }
        }
        cctvDir = new int[cctvCnt];
    }

}
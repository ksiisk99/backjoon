import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int[][] board = new int[21][21];
    private static StringBuilder sb = new StringBuilder();


    public static void main(String[] args) throws IOException {
        input();

        for (int i = 1; i <= 19 && sb.length() == 0; i++) {
            for (int j = 1; j <= 19; j++) {
                if (board[i][j] != 0) {
                    if (isFinish(i, j)) {
                        break;
                    }
                }
            }
        }


        if (sb.length() == 0) {
            sb.append(0);
        }
        System.out.print(sb.toString());
    }

    private static void makeResult(int i, int j) {
        sb.append(board[i][j]);
        sb.append("\n");
        sb.append(i);
        sb.append(" ");
        sb.append(j);
    }

    private static boolean isFinish(int i, int j) {
        if (checkCol(i, j)) {
            makeResult(i, j);
            return true;
        } else if (checkRow(i, j)) {
            makeResult(i, j);
            return true;
        } else if (checkLeftDaeGak(i, j)) {
            return true;
        } else if (checkRightDaeGak(i, j)) {
            makeResult(i, j);
            return true;
        }
        return false;
    }

    public static boolean checkCol(int x, int y) {
        int num = board[x][y];
        int continueCnt = 1;

        int ty = y;
        while (true) {
            int ny = ty - 1;
            if (ny < 1) break;

            if (board[x][ny] == num) {
                continueCnt++;
            } else {
                break;
            }
            ty = ny;
        }

        ty = y;
        while (true) {
            int ny = ty + 1;
            if (ny > 19) break;

            if (board[x][ny] == num) {
                continueCnt++;
            } else {
                break;
            }
            ty = ny;
        }

        if (continueCnt == 5) return true;
        return false;
    }

    public static boolean checkRow(int x, int y) {
        int num = board[x][y];
        int continueCnt = 1;

        int tx = x;
        while (true) {
            int nx = tx - 1;
            if (nx < 1) break;

            if (board[nx][y] == num) {
                continueCnt++;
            } else {
                break;
            }
            tx = nx;
        }

        tx = x;
        while (true) {
            int nx = tx + 1;
            if (nx > 19) break;

            if (board[nx][y] == num) {
                continueCnt++;
            } else {
                break;
            }
            tx = nx;
        }

        if (continueCnt == 5) return true;
        return false;
    }

    public static boolean checkRightDaeGak(int x, int y) {
        int num = board[x][y];
        int continueCnt = 1;
        int tx = x;
        int ty = y;

        while (true) {
            int nx = tx + 1;
            int ny = ty + 1;

            if (nx > 19 || ny > 19) break;

            if (board[nx][ny] == num) {
                continueCnt++;
            } else {
                break;
            }

            tx = nx;
            ty = ny;
        }

        tx = x;
        ty = y;

        while (true) {
            int nx = tx - 1;
            int ny = ty - 1;
            if (nx < 1 || ny < 1) break;

            if (board[nx][ny] == num) {
                continueCnt++;
            } else {
                break;
            }

            tx = nx;
            ty = ny;
        }

        if (continueCnt == 5) return true;
        return false;
    }

    public static boolean checkLeftDaeGak(int x, int y) {
        int num = board[x][y];
        int continueCnt = 1;
        int tx = x;
        int ty = y;
        while (true) {
            int nx = tx - 1;
            int ny = ty + 1;
            if (nx < 1 || ny > 19) break;

            if (board[nx][ny] == num) {
                continueCnt++;
            } else {
                break;
            }

            tx = nx;
            ty = ny;
        }

        tx = x;
        ty = y;
        while (true) {
            int nx = tx + 1;
            int ny = ty - 1;

            if (nx > 19 || ny < 1) break;

            if (board[nx][ny] == num) {
                continueCnt++;
            } else {
                break;
            }

            tx = nx;
            ty = ny;
        }


        if (continueCnt == 5) {
            makeResult(tx , ty);
            return true;
        }
        return false;
    }

    public static void input() throws IOException {
        StringTokenizer st;

        for (int i = 1; i <= 19; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= 19; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

}
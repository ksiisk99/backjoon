import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static StringBuilder sb = new StringBuilder();
    private static int N, M, result = Integer.MAX_VALUE;
    private static char[][] board;
    private static Point hole;

    static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new char[N][M];
        Point[] point = new Point[2];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                board[i][j] = s.charAt(j);
                if (board[i][j] == 'O') {
                    hole = new Point(i, j);
                } else if (board[i][j] == 'R') {
                    point[0] = new Point(i, j);
                    board[i][j] = '.';
                } else if (board[i][j] == 'B') {
                    point[1] = new Point(i, j);
                    board[i][j] = '.';
                }
            }
        }

        recursive(-1, 0, point);

        System.out.print(result == Integer.MAX_VALUE ? -1 : result);
    }

    private static void recursive(int beforeDir, int cnt, Point[] point) {
        if (point[1].x == hole.x && point[1].y == hole.y) {
            return;
        }

        if (point[0].x == hole.x && point[0].y == hole.y) {
            result = Math.min(result, cnt);
            return;
        }

        if (cnt == 10) {
            return;
        }

        for (int dir = 0; dir < 4; dir++) {
            if (beforeDir == dir) continue;
            Point[] nextPoint = move(dir, point);

            recursive(dir, cnt + 1, nextPoint);
        }
    }

    private static Point[] move(int dir, Point[] nextPoint) {
        Point[] point = new Point[2];
        point[0] = new Point(nextPoint[0].x, nextPoint[0].y);
        point[1] = new Point(nextPoint[1].x, nextPoint[1].y);

        int firstIndex = 0;
        int secondIndex = 0;
        //상하좌우
        if (dir == 0) {
            if (point[0].x < point[1].x) {
                firstIndex = 0;
                secondIndex = 1;
            } else {
                firstIndex = 1;
                secondIndex = 0;
            }
            int x = point[firstIndex].x;
            int y = point[firstIndex].y;
            int x2 = point[secondIndex].x;
            int y2 = point[secondIndex].y;
            while (x != 1) {
                if (board[x - 1][y] == '.') {
                    point[firstIndex].x--;
                    x--;
                } else if (board[x - 1][y] == 'O') {
                    point[firstIndex].x--;
                    x--;
                    break;
                } else {
                    break;
                }
            }
            while (x2 != 1) {
                if (board[x2 - 1][y2] == '.' && !((x2 - 1) == x && y2 == y)) {
                    point[secondIndex].x--;
                    x2--;
                } else if (board[x2 - 1][y2] == 'O') {
                    point[secondIndex].x--;
                    return point;
                } else {
                    break;
                }
            }
        } else if (dir == 1) {
            if (point[0].x > point[1].x) {
                firstIndex = 0;
                secondIndex = 1;
            } else {
                firstIndex = 1;
                secondIndex = 0;
            }
            int x = point[firstIndex].x;
            int y = point[firstIndex].y;
            int x2 = point[secondIndex].x;
            int y2 = point[secondIndex].y;
            while (x != (N - 1)) {
                if (board[x + 1][y] == '.') {
                    point[firstIndex].x++;
                    x++;
                } else if (board[x + 1][y] == 'O') {
                    point[firstIndex].x++;
                    x++;
                    break;
                } else {
                    break;
                }
            }
            while (x2 != (N - 1)) {
                if (board[x2 + 1][y2] == '.' && !((x2 + 1) == x && y2 == y)) {
                    point[secondIndex].x++;
                    x2++;
                } else if (board[x2 + 1][y2] == 'O') {
                    point[secondIndex].x++;
                    return point;
                } else {
                    break;
                }
            }
        } else if (dir == 2) {
            if (point[0].y < point[1].y) {
                firstIndex = 0;
                secondIndex = 1;
            } else {
                firstIndex = 1;
                secondIndex = 0;
            }
            int x = point[firstIndex].x;
            int y = point[firstIndex].y;
            int x2 = point[secondIndex].x;
            int y2 = point[secondIndex].y;
            while (y != 1) {
                if (board[x][y - 1] == '.') {
                    point[firstIndex].y--;
                    y--;
                } else if (board[x][y - 1] == 'O') {
                    point[firstIndex].y--;
                    y--;
                    break;
                } else {
                    break;
                }
            }
            while (y2 != 1) {
                if (board[x2][y2 - 1] == '.' && !(x2 == x && (y2 - 1) == y)) {
                    point[secondIndex].y--;
                    y2--;
                } else if (board[x2][y2 - 1] == 'O') {
                    point[secondIndex].y--;
                    return point;
                } else {
                    break;
                }
            }
        } else {
            if (point[0].y > point[1].y) {
                firstIndex = 0;
                secondIndex = 1;
            } else {
                firstIndex = 1;
                secondIndex = 0;
            }
            int x = point[firstIndex].x;
            int y = point[firstIndex].y;
            int x2 = point[secondIndex].x;
            int y2 = point[secondIndex].y;
            while (y != (M - 1)) {
                if (board[x][y + 1] == '.') {
                    point[firstIndex].y++;
                    y++;
                } else if (board[x][y + 1] == 'O') {
                    point[firstIndex].y++;
                    y++;
                    break;
                } else {
                    break;
                }
            }
            while (y2 != (M - 1)) {
                if (board[x2][y2 + 1] == '.' && !(x2 == x && (y2 + 1) == y)) {
                    point[secondIndex].y++;
                    y2++;
                } else if (board[x2][y2 + 1] == 'O') {
                    point[secondIndex].y++;
                    return point;
                } else {
                    break;
                }
            }
        }
        return point;
    }


}
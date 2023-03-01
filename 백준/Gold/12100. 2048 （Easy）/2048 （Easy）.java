import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static StringBuilder sb = new StringBuilder();
    private static int N, result = 2;

    static void backtracking(int cnt, int[][] board) {
        if (cnt == 5) {
            return;
        }
        for (int dir = 0; dir < 4; dir++) {
            int[][] nextBoard = move(dir, board);
            backtracking(cnt + 1, nextBoard);
        }
    }

    private static boolean isMove(int[][] board, int[][] nextBoard) {
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (board[i][j] != nextBoard[i][j]) {
                    return true;
                }
            }
        }
        return false;
    }

    private static int[][] move(int dir, int[][] next) {
        int[][] board = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                board[i][j] = next[i][j];
            }
        }
        //0(상) , 1(하) , 2(좌) , 3(우)
        if (dir == 0) {
            for (int j = 1; j <= N; j++) {
                int idx = 1;
                int block = 0;
                for (int i = 1; i <= N; i++) {
                    if (board[i][j] == 0) continue;

                    if (board[i][j] == block) {
                        board[idx - 1][j] = block * 2;
                        board[i][j] = 0;
                        block = 0;
                        result = Math.max(result, board[idx - 1][j]);
                    } else {
                        block = board[i][j];
                        board[i][j] = 0;
                        board[idx][j] = block;
                        idx++;
                    }
                }
            }
        } else if (dir == 1) {
            for (int j = 1; j <= N; j++) {
                int idx = N;
                int block = 0;
                for (int i = N; i >= 1; i--) {
                    if (board[i][j] == 0) continue;

                    if (board[i][j] == block) {
                        board[idx + 1][j] = block * 2;
                        board[i][j] = 0;
                        block = 0;
                        result = Math.max(result, board[idx + 1][j]);
                    } else {
                        block = board[i][j];
                        board[i][j] = 0;
                        board[idx][j] = block;
                        idx--;
                    }
                }
            }
        } else if (dir == 2) {
            for (int i = 1; i <= N; i++) {
                int idx = 1;
                int block = 0;
                for (int j = 1; j <= N; j++) {
                    if (board[i][j] == 0) continue;

                    if (block == board[i][j]) {
                        board[i][idx - 1] = block * 2;
                        block = 0;
                        board[i][j] = 0;
                        result = Math.max(result, board[i][idx - 1]);
                    } else {
                        block = board[i][j];
                        board[i][j] = 0;
                        board[i][idx] = block;
                        idx++;
                    }
                }
            }
        } else {
            for (int i = 1; i <= N; i++) {
                int idx = N;
                int block = 0;
                for (int j = N; j >= 1; j--) {
                    if (board[i][j] == 0) continue;

                    if (block == board[i][j]) {
                        board[i][idx + 1] = block * 2;
                        board[i][j] = 0;
                        block=0;
                        result = Math.max(result, board[i][idx + 1]);
                    } else {
                        block=board[i][j];
                        board[i][j]=0;
                        board[i][idx]=block;
                        idx--;
                    }
                }
            }
        }
        return board;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        int[][] board = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                result = Math.max(result, board[i][j]);
            }
        }
        backtracking(0, board);
        System.out.println(result);
    }


}
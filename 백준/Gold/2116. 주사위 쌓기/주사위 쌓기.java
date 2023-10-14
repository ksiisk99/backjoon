import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int N;
    private static int[][] board;
    private static final int A = 0, F = 5, B = 1, D = 3, C = 2, E = 4;

    //AF(0 5) BD(1 3) CE(2 4)
    public static void main(String[] args) throws IOException {
        input();

        int answer = 0;
        for (int idx = 0; idx < 6; idx++) {
            int sum = getMaxNum(0, idx);
            int top = board[0][idx];

            for (int i = 1; i < N; i++) {
                int bottomIdx = getIndexBySameNum(i, top);
                sum += getMaxNum(i, bottomIdx);

                top = board[i][getOppositeIdx(bottomIdx)];
            }

            answer = Math.max(answer, sum);
        }
        System.out.print(answer);
    }

    private static int getIndexBySameNum(int idx, int top) {
        int i = 0;
        for (; i < 6; i++) {
            if (board[idx][i] == top) {
                break;
            }
        }
        return i;
    }

    private static int getMaxNum(int idx, int tmp) {
        int oppositeIdx = getOppositeIdx(tmp);

        int result = 0;
        for (int i = 0; i < 6; i++) {
            if (i == tmp || i == oppositeIdx) continue;
            result = Math.max(result, board[idx][i]);
        }

        return result;
    }

    private static int getOppositeIdx(int idx) {
        int result = 0;
        if (idx == A) result = F;
        else if (idx == F) result = A;
        else if (idx == B) result = D;
        else if (idx == D) result = B;
        else if (idx == C) result = E;
        else if (idx == E) result = C;

        return result;
    }

    private static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        board = new int[N][6];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 6; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

}
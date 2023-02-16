import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static final int[][] board = new int[9][9];
    private static int[] checkCol = new int[9];
    private static int[] checkRow = new int[9];
    private static int[] checkSquare = new int[9];
    private static List<int[]> position = new ArrayList<>();
    private static StringBuilder sb = new StringBuilder();
    private static boolean check=false;

    private static void dfs(int cnt) {
        if(check)return;
        if (cnt == position.size()) {
            printResult();
            check=true;
            return;
        }
        int[] tmp = position.get(cnt);
        int x = tmp[0];
        int y = tmp[1];
        if (board[x][y] != 0) return;

        for (int i = 1; i <= 9; i++) {
            if ((checkCol[y] & (1 << i)) > 0 || (checkRow[x] & (1 << i)) > 0 || (checkSquare[(x / 3) * 3 + (y / 3)] & (1 << i)) > 0) {
                continue;
            }
            board[x][y] = i;
            checkCol[y] |= (1 << i);
            checkRow[x] |= (1 << i);
            checkSquare[(x / 3) * 3 + (y / 3)] |= (1 << i);
            dfs(cnt + 1);
            board[x][y] = 0;
            checkCol[y] &= (~(1 << i));
            checkRow[x] &= (~(1 << i));
            checkSquare[(x / 3) * 3 + (y / 3)] &= (~(1 << i));

        }
    }

    private static void printResult() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                sb.append(board[i][j]);
            }
            sb.append("\n");
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 9; i++) {
            String s = br.readLine();
            for (int j = 0; j < 9; j++) {
                board[i][j] = s.charAt(j) - '0';
                if (board[i][j] == 0) {
                    position.add(new int[]{i, j});
                } else {
                    checkCol[j] |= (1 << board[i][j]);
                    checkRow[i] |= (1 << board[i][j]);
                    checkSquare[(i / 3) * 3 + (j / 3)] |= (1 << board[i][j]);
                }
            }
        }
        dfs(0);
        System.out.print(sb);
    }
}
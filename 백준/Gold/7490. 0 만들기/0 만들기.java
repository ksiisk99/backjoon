import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int T, N;
    private static int[] queries;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        input();

        for (int i = 0; i < T; i++) {
            N = queries[i];
            backtracking(1, 1, 1, 0, "1");
            sb.append("\n");
        }

        System.out.print(sb.toString());
    }

    private static void backtracking(int num, int before, int op, int result, String expression) {
        if (num == N) {
            result += (before * op);
            if (result == 0) {
                sb.append(expression);
                sb.append("\n");
            }
            return;
        }

        backtracking(num + 1, (before * 10) + (num + 1), op, result, expression + " " + (num + 1));
        backtracking(num + 1, num + 1, 1, result + (before * op), expression + "+" + (num + 1));
        backtracking(num + 1, num + 1, -1, result + (before * op), expression + "-" + (num + 1));
    }

    private static void input() throws IOException {
        T = Integer.parseInt(br.readLine());
        queries = new int[T];
        for (int i = 0; i < T; i++) {
            queries[i] = Integer.parseInt(br.readLine());
        }
    }

}
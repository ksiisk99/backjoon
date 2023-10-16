import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int N;
    private static int[] top;

    public static void main(String[] args) throws IOException {
        input();

        StringBuilder sb = new StringBuilder();
        Stack<int[]> stack = new Stack<>();

        for (int i = 1; i <= N; i++) {
            int height = top[i];

            if (stack.isEmpty()) {
                sb.append("0 ");
            } else {
                boolean check = true;
                while (!stack.isEmpty()) {
                    int[] info = stack.peek();
                    if (info[1] >= height) {
                        sb.append(info[0]);
                        sb.append(" ");
                        check = false;
                        break;
                    }
                    stack.pop();
                }

                if (check) {
                    sb.append("0 ");
                }
            }

            stack.push(new int[]{i, height});
        }

        System.out.print(sb.toString());

    }


    private static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        top = new int[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            top[i] = Integer.parseInt(st.nextToken());
        }
    }
}
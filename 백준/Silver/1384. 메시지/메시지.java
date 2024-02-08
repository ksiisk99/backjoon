import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder answer = new StringBuilder();
    private static int N;
    private static String S;
    private static List<String> children;
    private static boolean[][] check;

    public static void main(String[] args) throws IOException {

        int groupCount = 1;
        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) break;

            input(n);

            answer.append("Group " + groupCount++);
            answer.append("\n");

            boolean nobody = true;

            for (int i = 0; i < n; i++) {
                String name = children.get(i);

                for (int j = 0; j < n - 1; j++) {
                    if (check[i][j]) {
                        int next = (n - 1 + i - j) % n;

                        answer.append(children.get(next) + " was nasty about " + name + "\n");
                        nobody = false;
                    }
                }
            }

            if (nobody) {
                answer.append("Nobody was nasty\n");
            }

            answer.append("\n");
        }

        System.out.print(answer.toString());
    }

    private static void input(int n) throws IOException {
        check = new boolean[n][n - 1];
        children = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            children.add(name);

            for (int j = 0; j < n - 1; j++) {
                String s = st.nextToken();

                if (s.equals("N")) {
                    check[i][j] = true;
                }
            }
        }
    }
}
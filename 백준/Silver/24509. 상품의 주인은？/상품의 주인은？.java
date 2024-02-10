import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.function.Predicate;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder answer = new StringBuilder();
    private static int N;
    private static int[][] score;
    private static boolean[] check;

    public static void main(String[] args) throws IOException {
        input();

        for (int i = 0; i < 4; i++) {
            int maxScore = -1;
            int number = 0;

            for (int j = 1; j <= N; j++) {
                if (maxScore < score[j][i] && !check[j]) {
                    maxScore = score[j][i];
                    number = j;
                }
            }

            check[number] = true;
            answer.append(number + " ");
        }

        System.out.print(answer.toString());
    }

    private static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        score = new int[N + 1][4];
        check = new boolean[N + 1];

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int number = Integer.parseInt(st.nextToken());
            for (int j = 0; j < 4; j++) {
                score[number][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    private static boolean test(Predicate<String> predicate) {
        return predicate.test("abc");
    }
}
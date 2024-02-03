import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder answer = new StringBuilder();
    private static int N, M;
    private static String S;
    private static Set<Character> set = Set.of('A', 'E', 'I', 'O', 'U');

    public static void main(String[] args) throws IOException {
        input();

        int aCount = 0;
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);

            if (aCount == 1) {
                if (S.charAt(i) == 'A') {
                    aCount++;
                    answer.append(c);
                }
                continue;
            } else if (aCount == 2) {
                if (!set.contains(c)) {
                    answer.append(c);
                    System.out.print("YES\n" + answer.toString());
                    return;
                }
                continue;
            }

            if (answer.length() < (M - 3)) {
                answer.append(c);
            }

            if (S.charAt(i) == 'A' && answer.length() == (M - 3)) {
                aCount++;
                answer.append(c);
            }


        }

        System.out.print("NO");
    }

    private static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        S = br.readLine();
    }
}
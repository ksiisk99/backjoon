import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder answer = new StringBuilder();
    private static int N;
    private static String S;

    public static void main(String[] args) throws IOException {
        input();

        int[] alphabetCount = new int[26];

        for (int i = 0; i < (N / 2); i++) {
            alphabetCount[S.charAt(i) - 'a']++;
            alphabetCount[S.charAt(N - i - 1) - 'a']++;
        }

        String answer = "Yes";
        for (int i = 0; i < 26; i++) {
            if (alphabetCount[i] % 2 == 1) {
                answer = "No";
                break;
            }
        }

        System.out.print(answer);
    }


    private static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        S = br.readLine();
    }

}
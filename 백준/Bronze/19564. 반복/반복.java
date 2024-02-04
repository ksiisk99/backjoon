import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder answer = new StringBuilder();
    private static String S;

    public static void main(String[] args) throws IOException {
        input();

        int answer = 1;

        for (int i = 1; i < S.length(); i++) {
            if (S.charAt(i-1) >= S.charAt(i)) {
                answer++;
            }
        }

        System.out.print(answer);
    }

    private static void input() throws IOException {
        S = br.readLine();
    }
}
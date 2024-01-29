import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder sb = new StringBuilder();
    private static String S;

    public static void main(String[] args) throws IOException {
        input();

        for (int i = 1; i <= 999; i++) {
            sb = new StringBuilder();

            for (int j = i; j <= 999; j++) {
                sb.append(j);

                if (sb.toString().equals(S)) {
                    System.out.print(i + " " + j);
                    return;
                }
            }
        }
    }

    private static void input() throws IOException {
        S = br.readLine();
    }

}
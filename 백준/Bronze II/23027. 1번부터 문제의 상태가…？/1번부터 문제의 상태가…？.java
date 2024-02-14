import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder answer = new StringBuilder();

    public static void main(String[] args) throws IOException {
        String S = br.readLine();

        if (S.contains("A")) {
            S = S.replaceAll("[ABCDF]", "A");
        } else if (S.contains("B")) {
            S = S.replaceAll("[BCDF]", "B");
        } else if (S.contains("C")) {
            S = S.replaceAll("[CDF]", "C");
        } else {
            S = S.replaceAll(".", "A");
        }

        System.out.print(S);
    }

    private static void input() throws IOException {

    }

}
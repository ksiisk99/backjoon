import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder answer = new StringBuilder();

    public static void main(String[] args) throws IOException {
        br.readLine();

        String answer = br.readLine()
                .chars()
                .filter(c -> c != 'A' && c != 'J' && c != 'V')
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();

        System.out.print(answer.isEmpty() ? "nojava" : answer);
    }

    private static void input() throws IOException {
    }

}
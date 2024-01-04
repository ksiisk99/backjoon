import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        String input = br.readLine();

        String replaceAlphabet = "CAMBRIDGE";

        for (int i = 0; i < replaceAlphabet.length(); i++) {
            input = input.replace(String.valueOf(replaceAlphabet.charAt(i)), "");
        }

        System.out.print(input);
    }

    private static void input() throws IOException {

    }

}
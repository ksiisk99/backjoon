import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder sb = new StringBuilder();
    private static int N;
    private static String word;


    public static void main(String[] args) throws IOException {
        input();

        long answer = 0L;
        int hiddenNumber = 0;
        for (int i = 0; i < N; i++) {
            if (word.charAt(i) >= '0' && word.charAt(i) <= '9') {
                hiddenNumber *= 10;
                hiddenNumber += (word.charAt(i) - '0');
            } else {
                if (hiddenNumber < 1000000) {
                    answer += hiddenNumber;
                }
                hiddenNumber = 0;
            }
        }

        System.out.print(answer + hiddenNumber);
    }

    private static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        word = br.readLine();
    }

}
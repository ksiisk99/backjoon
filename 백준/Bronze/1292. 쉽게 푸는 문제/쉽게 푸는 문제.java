import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder sb = new StringBuilder();
    private static int A, B;

    public static void main(String[] args) throws IOException {
        input();

        int answer = 0;
        int number = 1;
        int index = 0;
        while (index < B) {
            for (int i = 1; i <= number; i++) {
                index++;
                if (index >= A && index <= B) {
                    answer += number;
                }
            }

            number++;
        }

        System.out.print(answer);
    }

    private static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
    }
}
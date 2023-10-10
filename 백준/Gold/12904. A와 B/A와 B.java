import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder S, T;

    public static void main(String[] args) throws IOException {
        input();

        int answer = 0;
        while (true) {
            if (S.length() > T.length()) {
                break;
            }

            if (S.toString().equals(T.toString())) {
                answer = 1;
                break;
            }

            if (T.charAt(T.length() - 1) == 'A') {
                T.deleteCharAt(T.length()-1);
            } else {
                T.deleteCharAt(T.length()-1);
                T.reverse();
            }
        }

        System.out.print(answer);
    }


    private static void input() throws IOException {
        //StringTokenizer st = new StringTokenizer(br.readLine());
        S = new StringBuilder();
        T = new StringBuilder();
        S.append(br.readLine());
        T.append(br.readLine());
    }

}
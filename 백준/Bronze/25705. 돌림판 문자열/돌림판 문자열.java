import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder answer = new StringBuilder();
    private static int N, M;
    private static String 돌림판, S;

    public static void main(String[] args) throws IOException {
        input();

        if (isFail()) {
            System.out.print("-1");
            return;
        }

        int point = 돌림판.length() - 1;
        int answer = 0;

        for (int i = 0; i < S.length(); i++) {
            char alphabet = S.charAt(i);
            answer++;
            point = (point + 1) % N;

            while (alphabet != 돌림판.charAt(point)) {
                point = (point + 1) % N;
                answer++;
            }
        }

        System.out.print(answer);
    }

    private static boolean isFail() {
        for (int i = 0; i < S.length(); i++) {
            if (돌림판.indexOf(S.charAt(i)) == -1) {
                return true;
            }
        }
        return false;
    }


    private static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        돌림판 = br.readLine();
        M = Integer.parseInt(br.readLine());
        S = br.readLine();
    }

}


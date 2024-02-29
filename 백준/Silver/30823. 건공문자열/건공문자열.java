import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder answer = new StringBuilder();
    private static List<String> list = new ArrayList<>();
    private static int N, K;
    private static String S;

    public static void main(String[] args) throws IOException {
        input();

        if ((N % 2 == 0 && K % 2 == 0) || (N % 2 == 1 && K % 2 == 1)) {
            StringBuilder sb = new StringBuilder(S.substring(0, K - 1));
            answer.append(S.substring(K - 1) + sb.reverse().toString());
        } else {
            answer.append(S.substring(K - 1) + S.substring(0, K - 1));
        }


        System.out.print(answer.toString());
    }

    private static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        S = br.readLine();
    }

}
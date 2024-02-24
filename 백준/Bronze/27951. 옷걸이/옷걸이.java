import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder answer = new StringBuilder();
    private static int N, U, D;
    private static int[] 옷걸이;

    public static void main(String[] args) throws IOException {
        input();

        for (int i = 0; i < N; i++) {
            if ((옷걸이[i] == 1 || 옷걸이[i] == 3) && U > 0) {
                U--;
                answer.append("U");
            } else if ((옷걸이[i] == 2 || 옷걸이[i] == 3) && D > 0) {
                D--;
                answer.append("D");
            }
        }

        System.out.print(
                N == answer.length() ? "YES\n" + answer.toString() : "NO"
        );
    }

    private static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        옷걸이 = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            옷걸이[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        U = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
    }

}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder answer = new StringBuilder();
    private static int N, U, D;
    private static int[] 옷걸이;
    private static int[] count = new int[4];

    public static void main(String[] args) throws IOException {
        input();

        if (count[1] + count[3] < U || count[2] + count[3] < D) {
            System.out.print("NO");
            return;
        }

//        if (count[3] < Math.max(0, U - count[1]) + Math.max(0, D - count[2])) {
//            System.out.print("NO");
//            return;
//        }

        char[] answer = new char[N];

        for (int i = 0; i < N; i++) {
            if (옷걸이[i] == 1 && U > 0) {
                U--;
                answer[i] = 'U';
            } else if (옷걸이[i] == 2 && D > 0) {
                D--;
                answer[i] = 'D';
            }
        }

        for (int i = 0; i < N; i++) {
            if (옷걸이[i] == 3) {
                if (U > 0) {
                    U--;
                    answer[i] = 'U';
                } else if (D > 0) {
                    D--;
                    answer[i] = 'D';
                }
            }
        }
        System.out.println("YES");
        System.out.print(answer);
    }

    private static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        옷걸이 = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            옷걸이[i] = Integer.parseInt(st.nextToken());
            count[옷걸이[i]]++;
        }

        st = new StringTokenizer(br.readLine());
        U = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
    }

}


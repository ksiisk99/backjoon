import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder sb = new StringBuilder();
    private static int N;
    private static int[] pc;

    public static void main(String[] args) throws IOException {
        input();

        int answer = 0;
        boolean[] check = new boolean[101];
        for (int i = 0; i < N; i++) {
            int pcNumber = pc[i];
            if (check[pcNumber]) {
                answer++;
            }

            check[pcNumber] = true;
        }

        System.out.println(answer);
    }

    private static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        pc = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            pc[i] = Integer.parseInt(st.nextToken());
        }
    }
}
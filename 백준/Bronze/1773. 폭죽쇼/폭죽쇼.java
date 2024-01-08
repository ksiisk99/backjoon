import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder sb = new StringBuilder();
    private static int N, C;
    private static Set<Integer> students = new HashSet<>();

    public static void main(String[] args) throws IOException {
        input();

        int answer = 0;
        boolean[] check = new boolean[C + 1];
        for (int t : students) {
            for (int i = t; i <= C; i += t) {
                if (!check[i]) {
                    answer++;
                    check[i] = true;
                }
            }
        }

        System.out.print(answer);
    }

    private static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            students.add(Integer.parseInt(br.readLine()));
        }
    }

}
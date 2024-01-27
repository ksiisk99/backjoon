import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder sb = new StringBuilder();
    private static int N;
    private static int[] 뽑기;

    public static void main(String[] args) throws IOException {
        input();

        int answer = 0;
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < N * 2; i++) {
            if (!set.contains(뽑기[i])) {
                set.add(뽑기[i]);
            } else {
                set.remove(뽑기[i]);
            }

            answer = Math.max(answer, set.size());
        }

        System.out.print(answer);
    }

    private static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        뽑기 = new int[N * 2];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N * 2; i++) {
            뽑기[i] = Integer.parseInt(st.nextToken());
        }
    }

}
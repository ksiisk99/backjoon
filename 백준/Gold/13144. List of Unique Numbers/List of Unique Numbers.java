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
    private static int[] arr;

    public static void main(String[] args) throws IOException {
        input();

        int right = 0;
        long answer = 0L;
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < N; i++) {
            while (right < N && !set.contains(arr[right])) {
                set.add(arr[right++]);
            }

            answer += (right - i);

            set.remove(arr[i]);
        }

        System.out.print(answer);
    }

    private static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
    }
}

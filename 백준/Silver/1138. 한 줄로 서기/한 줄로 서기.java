import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int N;
    private static int[] arr;
    private static List<Integer> answer = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        input();

        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= N; i++) {
            int cnt = 0;
            for (int height : answer) {
                if (height == i) {
                    cnt = -1;
                    break;
                }

                if (height > i) {
                    cnt++;
                }
            }

            if (cnt == arr[i]) {
                answer.add(i);
                i = 0;
            }
        }

        answer.stream()
                .forEach(n -> {
                    sb.append(n);
                    sb.append(" ");
                });

        System.out.print(sb.toString());
    }


    public static void input() throws IOException {
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        arr = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
    }
}
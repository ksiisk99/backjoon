import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int N;
    private static Map<String, Integer> start = new HashMap<>();
    private static List<String> end = new ArrayList<>();
    private static boolean[] visit;

    public static void main(String[] args) throws IOException {
        input();
        int answer = 0;

        for (int i = 0; i < N; i++) {
            String number = end.get(i);

            int startIndex = start.get(number);
            int cnt = 0;
            for (int j = startIndex; j < N; j++) {
                if (visit[j]) {
                    cnt++;
                }
            }
            visit[startIndex] = true;

            if (startIndex + cnt != i) {
                answer++;
            }
        }

        System.out.print(answer);
    }


    public static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        visit = new boolean[N + 1];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            start.put(str, i);
        }

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            end.add(str);
        }
    }

}
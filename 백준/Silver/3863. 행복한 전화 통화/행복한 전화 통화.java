import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder answer = new StringBuilder();

    static class Call {
        int start;
        int end;

        public Call(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args) throws IOException {

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            if (N == 0 && M == 0) break;

            List<Call> calls = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());

                st.nextToken();
                st.nextToken();

                int start = Integer.parseInt(st.nextToken());
                int end = start + Integer.parseInt(st.nextToken()) - 1;

                calls.add(new Call(start, end));

            }

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int 경찰start = Integer.parseInt(st.nextToken());
                int 경찰end = 경찰start + Integer.parseInt(st.nextToken()) - 1;
                int cnt = 도청(calls, 경찰start, 경찰end);
                answer.append(cnt + "\n");
            }

        }
        System.out.print(answer.toString());
    }

    private static int 도청(List<Call> calls, int 경찰start, int 경찰end) {
        return (int) calls.stream()
                .filter(call -> {
                    if (call.start <= 경찰end && call.end >= 경찰start) return true;
                    return false;
                })
                .count();
    }


    private static void input() throws IOException {

    }

}


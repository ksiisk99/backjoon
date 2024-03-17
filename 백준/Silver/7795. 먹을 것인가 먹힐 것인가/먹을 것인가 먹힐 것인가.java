import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder answer = new StringBuilder();
    private static int X, Y;

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());

        while ((T--) > 0) {
            int N, M;
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            List<Integer> A = new ArrayList<>();
            List<Integer> B = new ArrayList<>();

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                A.add(Integer.parseInt(st.nextToken()));
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                B.add(Integer.parseInt(st.nextToken()));
            }

            Collections.sort(A);

            answer.append(process(A, B));
            answer.append("\n");
        }

        System.out.print(answer.toString());
    }

    private static int process(List<Integer> A, List<Integer> B) {
        int count = 0;

        for (int num : B) {
            int upperIndex = upperBound(num, A);
            count += (A.size() - upperIndex);
        }

        return count;
    }

    private static int upperBound(int num, List<Integer> A) {
        int left = 0, right = A.size();

        while (left < right) {
            int mid = (left + right) / 2;

            if (A.get(mid) <= num) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }

}


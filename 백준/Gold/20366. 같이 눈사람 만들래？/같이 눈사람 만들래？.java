import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder sb = new StringBuilder();
    private static int N;
    private static int[] arr;

    public static void main(String[] args) throws IOException {
        input();
        Arrays.sort(arr);

        int answer = Integer.MAX_VALUE;

        for (int i = 0; i < N - 3; i++) {
            for (int j = i + 3; j < N; j++) {
                int sum = arr[i] + arr[j];

                int left = i + 1;
                int right = j - 1;

                while (left < right) {
                    int sum2 = arr[left] + arr[right];

                    answer = Math.min(answer, Math.abs(sum - sum2));

                    if (sum <= sum2) {
                        right--;
                    } else {
                        left++;
                    }
                }
            }
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

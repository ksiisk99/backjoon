import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int N;
    private static int[] arr;

    public static void main(String[] args) throws IOException {
        input();

        int left = 0, right = N - 1;
        int answer = 0;

        while (left < right) {
            int s = calculate(left, right);
            answer = Math.max(answer, s);

            if (arr[left] <= arr[right]) {
                left++;
            } else {
                right--;
            }
        }

        System.out.print(answer);
    }

    private static int calculate(int left, int right) {
        int diff = right - left - 1;

        return Math.min(arr[left], arr[right]) * diff;
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

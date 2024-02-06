import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder answer = new StringBuilder();
    private static int N;
    private static int[] arr;

    public static void main(String[] args) throws IOException {
        input();

        int upIndex = 0;
        int height = 0;
        while (upIndex < N) {
            if (height >= arr[upIndex]) {
                upIndex--;
                break;
            }

            height = arr[upIndex];
            upIndex++;
        }

        if (upIndex == N) {
            System.out.println("YES");
            return;
        }

        int downIndex = N - 1;
        height = 0;
        while (downIndex >= 0) {
            if (height >= arr[downIndex]) {
                downIndex++;
                break;
            }

            height = arr[downIndex];
            downIndex--;
        }

        if (downIndex == -1) {
            System.out.println("YES");
            return;
        }

        if (upIndex == downIndex) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

    private static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
    }
}
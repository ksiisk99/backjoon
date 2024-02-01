import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder sb = new StringBuilder();
    private static int N, B, H, W;

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        while ((T--) > 0) {
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] arr = new int[N];

            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            int answer = 0;
            while (true) {
                for (int i = 0; i < N; i++) {
                    if (arr[i] % 2 == 1) {
                        arr[i]++;
                    }
                }

                if (isFinish(arr)) {
                    break;
                }

                int[] newArr = new int[N];
                for (int i = 0; i < N; i++) {
                    newArr[(i + 1) % N] = (arr[i] / 2) + (arr[(i + 1) % N] / 2);
                }

                answer++;
                arr = newArr;
            }

            sb.append(answer + "\n");
        }

        System.out.print(sb.toString());

    }

    private static boolean isFinish(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[0] != arr[i]) {
                return false;
            }
        }

        return true;
    }

    private static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
    }

}
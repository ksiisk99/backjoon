import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int N, K;
    private static int[] arr;

    public static void main(String[] args) throws IOException {
        input();

        int left = 0, right = 1;
        int answer = 0;
        int k = 0;

        if (arr[0] % 2 != 0) {
            k++;
        } else {
            answer = 1;
        }

        while (left<=right && right < N) {
            if (arr[right] % 2 != 0) {
                if (k < K) {
                    k++;
                    right++;
                } else {
                    if (arr[left] % 2 != 0) {
                        k--;
                    }
                    left++;
                }
            } else {
                right++;
            }

            //System.out.println(left+" "+right+" "+k);
            answer = Math.max(answer, right - left - k);
        }

        System.out.print(answer);
    }


    private static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
    }
}

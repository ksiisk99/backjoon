import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder answer = new StringBuilder();
    private static int N;
    private static int[] arr;


    public static void main(String[] args) throws IOException {
        input();

        Arrays.sort(arr);
        int maxHeight = 0;
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            if (arr[i] > maxHeight) {
                maxHeight = arr[i];
                cnt++;
                arr[i] = 0;
            }
        }

        maxHeight = 0;
        for (int i = 0; i < N; i++) {
            if (arr[i] != 0 && arr[i] > maxHeight) {
                maxHeight = arr[i];
                cnt++;
            }
        }

        System.out.println(cnt);
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

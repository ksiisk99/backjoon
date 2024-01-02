import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder sb = new StringBuilder();
    private static int N;
    private static int[] arr;

    public static void main(String[] args) throws IOException {
        input();
        Arrays.sort(arr);

        int left = 0;
        int right = 0;
        int answer = 4;

        while (right < N) {
            if (arr[right] - arr[left] < 5) {
                answer = Math.min(answer, 5 - (right - left + 1));
                right++;
            } else {
                left++;
            }
        }
//1 5 6 7 8 9 15
        System.out.print(answer);

    }

    private static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

    }

}
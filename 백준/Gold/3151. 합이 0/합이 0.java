import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int N;
    private static int[] arr;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        input();
        Arrays.sort(arr);
        
        long answer = 0;
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                int sum = arr[i] + arr[j];

                int lower = lowerBound(j + 1, -sum);
                int upper = upperBound(j + 1, -sum);
                answer += (upper - lower);
            }
        }

        System.out.print(answer);
    }

    private static int lowerBound(int left, int target) {
        int right = N;

        while (left < right) {
            int mid = (left + right) / 2;

            if (arr[mid] >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return right;
    }

    private static int upperBound(int left, int target) {
        int right = N;

        while (left < right) {
            int mid = (left + right) / 2;

            if (arr[mid] > target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return right;
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

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder sb = new StringBuilder();
    private static int N;
    private static int[] arr;


    public static void main(String[] args) throws IOException {
        input();

        int left = 0, right = 0;
        int leftMaxHeight = 0, rightMaxHeight = 0;

        for (int i = 0; i < N; i++) {
            if (arr[i] > leftMaxHeight) {
                leftMaxHeight = arr[i];
                left++;
            }

            if (arr[N - i - 1] > rightMaxHeight) {
                right++;
                rightMaxHeight = arr[N - i - 1];
            }
        }

        System.out.print(left+"\n"+right);
    }

    private static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
    }

}
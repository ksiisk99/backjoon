import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int N, K;
    private static int[] arr;
    private static boolean[] visit;


    public static void main(String[] args) throws IOException {
        input();

        int answer = 0;
        while (!isFinish()) {
            answer++;
            rotateBelt();
            moveRobot();
            createRobot();
        }

        System.out.print(answer);
    }

    private static boolean isFinish() {
        int result = 0;
        for (int i = 1; i <= N; i++) {
            if (arr[i] <= 0) result++;
        }
        if (result >= K) {
            return true;
        }
        return false;
    }

    private static void createRobot() {
        if (arr[1] >= 1 && !visit[1]) {
            visit[1] = true;
            arr[1]--;
        }
    }

    private static void moveRobot() {
        visit[N / 2] = false;

        for (int i = (N / 2) - 1; i >= 1; i--) {
            if (arr[i+1] > 0 && !visit[i + 1] && visit[i]) {
                visit[i] = false;
                visit[i + 1] = true;
                arr[i+1]--;
            }
        }
    }

    private static void rotateBelt() {
        int tmp = arr[N];

        for (int i = N; i > 1; i--) {
            arr[i] = arr[i - 1];
        }
        arr[1] = tmp;

        for (int i = N / 2; i > 1; i--) {
            visit[i] = visit[i - 1];
        }
        visit[1] = false;


    }

    public static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()) * 2;
        K = Integer.parseInt(st.nextToken());
        arr = new int[N + 1];
        visit = new boolean[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

    }

}
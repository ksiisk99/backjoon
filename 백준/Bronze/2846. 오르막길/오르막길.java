import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder sb = new StringBuilder();
    private static int N;
    private static int[] road;
    private static int answer;

    public static void main(String[] args) throws IOException {
        input();

        int currentHeight = 0;
        int nextHeight = 0;
        int startHeight = road[0];
        for (int i = 0; i < N - 1; i++) {
            currentHeight = road[i];
            nextHeight = road[i + 1];

            if (currentHeight >= nextHeight) {
                startHeight = nextHeight;
                continue;
            }

            answer = Math.max(answer, (nextHeight - startHeight));
        }

        System.out.print(answer);
    }

    private static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        road = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            road[i] = Integer.parseInt(st.nextToken());
        }
    }
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder sb = new StringBuilder();
    private static int N, K;
    private static int[] cranes, boxes;

    public static void main(String[] args) throws IOException {
        input();
        Arrays.sort(cranes);
        Arrays.sort(boxes);

        int cnt = 0;
        int answer = -1;

        Queue<int[]> queue = new LinkedList<>();
        for (int i = cranes.length - 1; i >= 0; i--) {
            queue.offer(new int[]{cranes[i], boxes.length - 1});
        }

        while (!queue.isEmpty()) {
            int size = queue.size();
            answer++;

            for (int i = 0; i < size; i++) {
                int[] info = queue.poll();
                int power = info[0];
                int idx = info[1];

                for (int j = idx; j >= 0; j--) {
                    if (power >= boxes[j]) {
                        boxes[j] = Integer.MAX_VALUE;
                        cnt++;
                        queue.offer(new int[]{power, j - 1});
                        break;
                    }
                }
            }
        }

        if (cnt != boxes.length) {
            answer = -1;
        }

        System.out.print(answer);

    }

    private static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        cranes = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            cranes[i] = Integer.parseInt(st.nextToken());
        }

        K = Integer.parseInt(br.readLine());
        boxes = new int[K];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            boxes[i] = Integer.parseInt(st.nextToken());
        }
    }

}
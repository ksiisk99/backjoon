import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder sb = new StringBuilder();
    private static int N, M;


    public static void main(String[] args) throws IOException {
        input();

        Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 1; i <= N; i++) {
            queue.addLast(i);
        }

        int level = 1;
        while (queue.size() > 1) {
            long rotateCount = (long) Math.pow(level, 3) - 1L;
            rotateCount %= queue.size();

            for (int i = 1; i <= rotateCount; i++) {
                Integer num = queue.pollFirst();
                queue.addLast(num);
            }

            queue.remove();
            level++;
        }

        System.out.print(queue.poll());
    }

    private static void input() throws IOException {
        N = Integer.parseInt(br.readLine());

    }

}
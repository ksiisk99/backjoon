import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder sb = new StringBuilder();
    private static int N;
    private static int[][] cards;


    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());

        Deque<Integer> queue = new ArrayDeque<>();
        int packet = 0;
        while ((packet = Integer.parseInt(br.readLine())) != -1) {
            if (packet == 0) {
                queue.pollFirst();
                continue;
            }

            if (queue.size() < N) {
                queue.addLast(packet);
            }
        }

        if (queue.isEmpty()) {
            System.out.println("empty");
        } else {
            while (!queue.isEmpty()) {
                sb.append(queue.pollFirst() + " ");
            }
            System.out.print(sb.toString());
        }
    }

}
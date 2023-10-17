import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int N;
    private static PriorityQueue<Integer> pq = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        input();

        int answer = 0;
        while (pq.size() > 1) {
            int n1 = pq.poll();
            int n2 = pq.poll();

            int sum = n1 + n2;
            answer += sum;
            pq.add(sum);
        }

        System.out.print(answer);
    }


    private static void input() throws IOException {
        N = Integer.parseInt(br.readLine());

        //StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            pq.add(Integer.parseInt(br.readLine()));
        }
    }
}
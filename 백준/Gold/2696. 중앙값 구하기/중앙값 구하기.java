import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int N, M;
    private static StringBuilder sb = new StringBuilder();


    public static void main(String[] args) throws IOException {
        input();
        int T = Integer.parseInt(br.readLine());

        while ((T--) > 0) {
            int cnt = 0;
            int N = Integer.parseInt(br.readLine());
            sb.append((N + 1) / 2);
            sb.append("\n");

            StringTokenizer st = null;
            PriorityQueue<Integer> minPq = new PriorityQueue<>();
            PriorityQueue<Integer> maxPq = new PriorityQueue<>(Comparator.reverseOrder());

            for (int i = 0; i < N; i++) {
                if (i % 10 == 0) {
                    st = new StringTokenizer(br.readLine());
                }

                int num = Integer.parseInt(st.nextToken());
                if(i%2==0) {
                    maxPq.add(num);
                } else {
                    minPq.add(num);
                }

                if(!minPq.isEmpty() && !maxPq.isEmpty()) {
                    if(minPq.peek() <= maxPq.peek()) {
                        int tmp = maxPq.poll();
                        minPq.add(tmp);
                        maxPq.add(minPq.poll());
                    }
                }

                if (i % 2 == 0) {
                    cnt++;
                    sb.append(maxPq.peek() + " ");
                    if (cnt % 10 == 0) {
                        sb.append("\n");
                    }
                }
            }

            sb.append("\n");
        }

        System.out.print(sb.toString());
    }

    private static void input() throws IOException {


    }
}

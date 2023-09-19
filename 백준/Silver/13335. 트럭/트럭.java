import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int N, W, L;
    private static int[] arr;
    private static List<Integer> answer = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        input();
        Queue<Integer> queue = new LinkedList<>();

        int truckCnt = 0;
        int truckWeight = 0;
        int time = 0;
        for (int i = 0; i < N;) {
            time++;
            if (queue.size() == W) {
                int weight = queue.poll();
                if (weight != 0) {
                    truckWeight -= weight;
                    truckCnt--;
                }
            }

            if (truckCnt + 1 <= W) {
                if (truckWeight + arr[i] <= L) {
                    truckWeight+=arr[i];
                    queue.add(arr[i++]);
                    truckCnt++;
                } else {
                    queue.add(0);
                }
            }

        }

        if(queue.size()>0) {
            time+=(W-queue.size());
            time+=queue.size();
        }
        System.out.print(time);
    }


    public static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
    }
}
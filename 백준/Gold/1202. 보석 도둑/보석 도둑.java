import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    private static StringBuilder sb;
    private static StringTokenizer st;

    static class Jewelry implements Comparable<Jewelry> {
        int weight;
        int cost;

        public Jewelry(int weight, int cost) {
            this.weight = weight;
            this.cost = cost;
        }

        @Override
        public int compareTo(Jewelry o) {
            return weight - o.weight;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] bag = new int[K];
        Jewelry[] jewelries = new Jewelry[N];

        PriorityQueue<Integer> pq = new PriorityQueue<>((o1,o2)->o2-o1);
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            jewelries[i] = new Jewelry(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        for (int i = 0; i < K; i++) {
            bag[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(bag);
        Arrays.sort(jewelries);

        long ans = 0;
        int jewerelyIdx = 0;
        for (int i = 0; i < K; i++) {
            while (jewerelyIdx<N && bag[i] >= jewelries[jewerelyIdx].weight) {
                pq.add(jewelries[jewerelyIdx].cost);
                jewerelyIdx++;
            }
            if (!pq.isEmpty()) ans += pq.poll();
        }
        System.out.println(ans);
    }

}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static class Room {
        int s, t;

        public Room(int s, int t) {
            this.s = s;
            this.t = t;
        }


    }

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        Room[] rooms = new Room[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            int T = Integer.parseInt(st.nextToken());
            rooms[i] = new Room(S, T);
        }
        Arrays.sort(rooms, (Room o1, Room o2) -> {
            return o1.s - o2.s;
        });

        int result = 1;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(rooms[0].t);
        for (int i = 1; i < N; i++) {
            if(pq.peek()<=rooms[i].s){
                pq.poll();
            }else{
                result++;
            }
            pq.add(rooms[i].t);
        }

        System.out.print(result);
    }

}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int T, Q;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        input();
        System.out.print(sb.toString());
    }

    private static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        T = Integer.parseInt(st.nextToken());

        for (int t = 0; t < T; t++) {
            Q = Integer.parseInt(br.readLine());
            PriorityQueue<Integer> maxPQ = new PriorityQueue<>(Comparator.reverseOrder());
            PriorityQueue<Integer> minPQ = new PriorityQueue<>();
            Map<Integer, Integer> map = new HashMap<>();

            for (int q = 0; q < Q; q++) {
                st = new StringTokenizer(br.readLine());
                String in = st.nextToken();
                int num = Integer.parseInt(st.nextToken());
                if (in.equals("I")) {
                    maxPQ.offer(num);
                    minPQ.offer(num);
                    map.put(num, map.getOrDefault(num, 0) + 1);
                    continue;
                }

                if (map.size() == 0) {
                    continue;
                }

                removeMap(map, num, maxPQ, minPQ);
            }

            print(map, maxPQ, minPQ);
        }

    }

    private static void print(Map<Integer, Integer> map, PriorityQueue<Integer> maxPQ, PriorityQueue<Integer> minPQ) {
        if (map.size() == 0) {
            sb.append("EMPTY\n");
            return;
        }

        int maxNum = 0;
        while(!maxPQ.isEmpty()) {
            maxNum = maxPQ.poll();
            if(map.containsKey(maxNum)) {
                break;
            }
        }

        int minNum = 0;
        while(!minPQ.isEmpty()) {
            minNum = minPQ.poll();
            if(map.containsKey(minNum)) {
                break;
            }
        }

        if(map.containsKey(maxNum) && map.containsKey(minNum)) {
            sb.append(maxNum + " " + minNum + "\n");
        } else {
            sb.append("EMPTY\n");
        }
    }

    private static void removeMap(Map<Integer, Integer> map, int num, PriorityQueue<Integer> maxPQ, PriorityQueue<Integer> minPQ) {
        int n = 0;
        if (num == 1) {
            while(!maxPQ.isEmpty()) {
                n = maxPQ.poll();
                if(map.containsKey(n)) {
                   break;
                }
            }
        } else {
            while(!minPQ.isEmpty()) {
                n = minPQ.poll();
                if(map.containsKey(n)) {
                    break;
                }
            }
        }

        if(!map.containsKey(n)) {
            return;
        }

        int cnt = map.get(n);
        if (cnt == 1) {
            map.remove(n);
            return;
        }
        cnt--;
        map.put(n, cnt);


    }
}

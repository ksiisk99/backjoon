import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static class Flower implements Comparable<Flower> {
        int start;
        int end;

        public Flower(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Flower o) {
            if (start == o.start) {
                return o.end - end;
            }
            return start - o.start;
        }
    }

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        List<Flower> flowers = new ArrayList<>();
        int limitStart = 301;
        int limitEnd = 1201;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int startMonth = Integer.parseInt(st.nextToken());
            int startDay = Integer.parseInt(st.nextToken());
            int endMonth = Integer.parseInt(st.nextToken());
            int endDay = Integer.parseInt(st.nextToken());

            Flower flower = new Flower(startMonth * 100 + startDay, endMonth * 100 + endDay);
            flowers.add(flower);
        }

        Collections.sort(flowers);

        int cnt = 0;
        int idx = 0;
        int max = 0;

        while (limitStart < limitEnd) {
            boolean check = false;

            for (int i = idx; i < N; i++) {
                if (limitStart < flowers.get(i).start) {
                    break;
                }

                if (max < flowers.get(i).end) {
                    max = flowers.get(i).end;
                    check = true;
                    idx++;
                }
            }

            if (check) {
                cnt++;
                limitStart = max;
            } else {
                break;
            }
        }

        if (max < limitEnd) System.out.println(0);
        else System.out.println(cnt);

    }
}
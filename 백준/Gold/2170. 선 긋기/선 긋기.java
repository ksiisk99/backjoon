import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static class Line implements Comparable<Line> {
        int x, y;

        public Line(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Line o) {
            if (x == o.x) return y - o.y;
            return x - o.x;
        }
    }

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        Line[] lines = new Line[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            lines[i] = new Line(x, y);
        }

        Arrays.sort(lines);

        int result = 0;
        int len = -1_000_000_000;
        for (int i = 0; i < N; i++) {
            if (len <= lines[i].x) {
                result += Math.abs(lines[i].y - lines[i].x);
                len = lines[i].y;
            } else if (len > lines[i].x && len < lines[i].y) {
                result += Math.abs(lines[i].y - len);
                len = lines[i].y;
            }
        }

        System.out.print(result);
    }

}

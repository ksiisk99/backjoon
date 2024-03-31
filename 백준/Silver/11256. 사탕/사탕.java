import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder answer = new StringBuilder();
    private static int N;

    static class Box {
        int r, c;

        public Box(int r, int c) {
            this.r = r;
            this.c = c;
        }

        public int calculateSize() {
            return r * c;
        }
    }

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        while ((T--) > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int j = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());

            List<Box> boxes = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                int r = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());

                boxes.add(new Box(r, c));
            }

            boxes.sort(((o1, o2) -> (o2.r * o2.c) - (o1.r * o1.c)));

            int cnt = 0;
            for (Box box : boxes) {
                j -= box.calculateSize();
                cnt++;
                if (j <= 0) break;
            }

            answer.append(cnt + "\n");
        }

        System.out.print(answer);

    }
}
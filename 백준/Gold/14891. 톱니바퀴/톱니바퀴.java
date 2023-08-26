import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int N, L;
    private static int[][] gear = new int[4][8];
    private static final int NORTH = 0;
    private static final int SOUTH = 1;
    private static int K;
    private static int ANTI_CLOCK_WISE = -1;
    private static int CLOCK_WISE = 1;
    private static final int RIGHT = 2;
    private static final int LEFT = 6;
    private static List<int[]> rotateArr = new ArrayList<>();
//오른쪽이 2 왼쪽이 6

    public static void main(String[] args) throws IOException {
        input();
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < K; i++) {
            boolean[] visit = new boolean[4];
            List<int[]> list = new ArrayList<>();
            queue.add(rotateArr.get(i));

            while (!queue.isEmpty()) {
                int[] info = queue.poll();
                int idx = info[0];
                int r = info[1];
                int nextR = r == CLOCK_WISE ? ANTI_CLOCK_WISE : CLOCK_WISE;
                visit[idx] = true;

                if (idx == 0) {
                    if (gear[idx][RIGHT] != gear[idx + 1][LEFT] && !visit[idx + 1]) {
                        queue.add(new int[]{idx + 1, nextR});
                    }
                } else if (idx == 1 || idx == 2) {
                    if (gear[idx][RIGHT] != gear[idx + 1][LEFT] && !visit[idx + 1]) {
                        queue.add(new int[]{idx + 1, nextR});
                    }
                    if (gear[idx][LEFT] != gear[idx - 1][RIGHT] && !visit[idx - 1]) {
                        queue.add(new int[]{idx - 1, nextR});
                    }
                } else {
                    if (gear[idx][LEFT] != gear[idx - 1][RIGHT] && !visit[idx - 1]) {
                        queue.add(new int[]{idx - 1, nextR});
                    }
                }
                list.add(info);
            }


            for (int[] in : list) {
                rotate(gear[in[0]], in[1]);
            }

        }

        System.out.print(calcScore());
    }

    private static int calcScore() {
        int sum = 0;
        for (int i = 0; i < 4; i++) {
            if (gear[i][0] == SOUTH) {
                sum += (int) Math.pow(2, i);
            }
        }
        return sum;
    }

    private static void rotate(int[] g, int r) {
        if (r == CLOCK_WISE) {
            int tmp = g[7];
            for (int i = 7; i > 0; i--) {
                g[i] = g[i - 1];
            }
            g[0] = tmp;
        } else {
            int tmp = g[0];
            for (int i = 0; i < 7; i++) {
                g[i] = g[i + 1];
            }
            g[7] = tmp;
        }
    }


    public static void input() throws IOException {
        StringTokenizer st;

        for (int i = 0; i < 4; i++) {
            String s = br.readLine();
            for (int j = 0; j < 8; j++) {
                gear[i][j] = s.charAt(j) - '0';
            }
        }

        K = Integer.parseInt(br.readLine());
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            rotateArr.add(new int[]{Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken())});
        }

    }

}
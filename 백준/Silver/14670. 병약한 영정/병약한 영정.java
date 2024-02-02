import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder answer = new StringBuilder();
    private static int N, M;
    private static int[] 약;
    private static List<Integer>[] 증상;

    public static void main(String[] args) throws IOException {
        input();

        for (int i = 0; i < M; i++) {
            StringBuilder result = new StringBuilder();
            boolean isDie = false;

            for (int r : 증상[i]) {
                if (약[r] == -1) {
                    isDie = true;
                    answer.append("YOU DIED\n");
                    break;
                }

                result.append(약[r] + " ");
            }

            if (!isDie) {
                answer.append(result.toString() + "\n");
            }
        }

        System.out.print(answer.toString());
    }

    private static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        약 = new int[101];
        Arrays.fill(약, -1);

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int 효능 = Integer.parseInt(st.nextToken());
            int name = Integer.parseInt(st.nextToken());

            약[효능] = name;
        }

        M = Integer.parseInt(br.readLine());
        증상 = new ArrayList[M];
        for (int i = 0; i < M; i++) {
            증상[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int R = Integer.parseInt(st.nextToken());

            for (int r = 0; r < R; r++) {
                증상[i].add(Integer.parseInt(st.nextToken()));
            }
        }
    }

}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int N, M;
    private static int[] train;

    public static void main(String[] args) throws IOException {
        input();
        boolean[] visit = new boolean[(1 << 21)];

        int answer = 0;
        for (int i = 1; i <= N; i++) {
            if (!visit[train[i]]) {
                visit[train[i]] = true;
                answer++;
            }
        }

        System.out.print(answer);
    }


    public static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        train = new int[N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int command = Integer.parseInt(st.nextToken());

            if (command == 1) {
                int trainNum = Integer.parseInt(st.nextToken());
                int seatNum = Integer.parseInt(st.nextToken()) - 1;
                train[trainNum] |= (1 << seatNum);
            } else if (command == 2) {
                int trainNum = Integer.parseInt(st.nextToken());
                int seatNum = Integer.parseInt(st.nextToken()) - 1;
                train[trainNum] &= (~(1 << seatNum));
            } else if (command == 3) {
                int trainNum = Integer.parseInt(st.nextToken());
                train[trainNum] = ((~(1<<20)) & (train[trainNum] << 1));
            } else {
                int trainNum = Integer.parseInt(st.nextToken());
                train[trainNum] >>= 1;
            }
        }
    }

}
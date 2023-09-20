import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int N, M, storeCnt;
    private static List<int[]> stores = new ArrayList<>();
    private static int[] dong;
    private static final int NORTH = 1, SOUTH = 2, WEST = 3, EAST = 4;

    public static void main(String[] args) throws IOException {
        input();

        int answer = 0;
        for (int[] store : stores) {
            int dir = store[0];
            int dist = store[1];

            if (dir == dong[0]) {
                answer += Math.abs(dong[1] - dist);
            } else if (dong[0] == NORTH) {
                if (dir == WEST) {
                    answer += dong[1];
                    answer += dist;
                } else if (dir == EAST) {
                    answer += (M - dong[1]);
                    answer += dist;
                } else {
                    int left = dist + dong[1];
                    int right = (M - dist) + (M - dong[1]);
                    answer += Math.min(left, right) + N;
                }
            } else if (dong[0] == SOUTH) {
                if (dir == WEST) {
                    answer += dong[1];
                    answer += (N - dist);
                } else if (dir == EAST) {
                    answer += (M - dong[1]);
                    answer += (N - dist);
                } else {
                    int left = dist + dong[1];
                    int right = (M - dist) + (M - dong[1]);
                    answer += Math.min(left, right) + N;
                }
            } else if (dong[0] == WEST) {
                if (dir == NORTH) {
                    answer += dong[1];
                    answer += dist;
                } else if (dir == SOUTH) {
                    answer += dist;
                    answer += (N - dong[1]);
                } else {
                    int top = dist + dong[1];
                    int down = (N - dist) + (N - dong[1]);
                    answer += Math.min(top, down) + M;
                }
            } else {
                if (dir == NORTH) {
                    answer += dong[1];
                    answer += (M - dist);
                } else if (dir == SOUTH) {
                    answer += (M - dist);
                    answer += (N - dong[1]);
                } else {
                    int top = dist + dong[1];
                    int down = (N - dist) + (N - dong[1]);
                    answer += Math.min(top, down) + M;
                }
            }
        }

        System.out.print(answer);
    }


    public static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        storeCnt = Integer.parseInt(br.readLine());

        for (int i = 0; i < storeCnt; i++) {
            st = new StringTokenizer(br.readLine());
            stores.add(new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
        }

        st = new StringTokenizer(br.readLine());
        dong = new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
    }

}
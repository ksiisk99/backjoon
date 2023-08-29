import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int N, M, answer = Integer.MAX_VALUE;
    private static List<int[]> chicken = new ArrayList<>();
    private static List<int[]> house = new ArrayList<>();
    private static boolean[] selectChicken;

    public static void main(String[] args) throws IOException {
        input();

        dfs(0, 0);
        System.out.print(answer);
    }

    private static void dfs(int cnt, int idx) {
        if (cnt == M) {
            answer = Math.min(answer, calc());
            return;
        }

        if (idx >= chicken.size()) return;

        selectChicken[idx] = true;
        dfs(cnt + 1, idx + 1);
        selectChicken[idx] = false;
        dfs(cnt, idx + 1);
    }

    private static int calc() {
        int result = 0;
        int[] shortestDist = new int[house.size()];
        Arrays.fill(shortestDist, Integer.MAX_VALUE);

        for (int i = 0; i < chicken.size(); i++) {
            if (selectChicken[i]) {
                int[] chickInfo = chicken.get(i);
                int cx = chickInfo[0];
                int cy = chickInfo[1];

                for (int h = 0; h < house.size(); h++) {
                    int[] houseInfo = house.get(h);
                    int hx = houseInfo[0];
                    int hy = houseInfo[1];
                    shortestDist[h] = Math.min(shortestDist[h], calcDist(cx, cy, hx, hy));
                }
            }
        }

        for (int h = 0; h < house.size(); h++) {
            result += shortestDist[h];
        }

        return result;
    }

    private static int calcDist(int x, int y, int x2, int y2) {
        return Math.abs(x - x2) + Math.abs(y - y2);
    }


    public static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 1; j <= N; j++) {
                int n = Integer.parseInt(st.nextToken());
                if (n == 2) {
                    chicken.add(new int[]{i, j});
                } else if (n == 1) {
                    house.add(new int[]{i, j});
                }
            }
        }

        selectChicken = new boolean[chicken.size() + 1];
    }

}
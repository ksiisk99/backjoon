import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static StringBuilder sb = new StringBuilder();
    private static int N, T;
    private static Coordinate house, festival;
    private static Coordinate[] shop;
    private static boolean[] visit;
    private static boolean check;
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static class Coordinate {
        int x;
        int y;

        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            input();
            if (calcDist(house.x, house.y, festival.x, festival.y) <= 1000) {
                sb.append("happy");
                sb.append("\n");
                continue;
            }
            check = false;
            for (int i = 0; i < N; i++) {
                if (!visit[i] && calcDist(house.x, house.y, shop[i].x, shop[i].y) <= 1000) {
                    visit[i] = true;
                    dfs(shop[i].x, shop[i].y);
                }
            }
            if (check) {
                sb.append("happy");
                sb.append("\n");
            }else{
                sb.append("sad");
                sb.append("\n");
            }
        }
        System.out.print(sb.toString());
    }

    private static void dfs(int x, int y) {
        if (check) return;
        if (calcDist(x, y, festival.x, festival.y) <= 1000) {
            check = true;
            return;
        }

        for (int i = 0; i < N; i++) {
            if (check) break;
            if (!visit[i] && calcDist(x, y, shop[i].x, shop[i].y) <= 1000) {
                visit[i] = true;
                dfs(shop[i].x, shop[i].y);
            }
        }
    }

    private static void input() throws IOException {
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        visit = new boolean[N];
        shop = new Coordinate[N];
        st = new StringTokenizer(br.readLine());
        house = new Coordinate(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            shop[i] = new Coordinate(x, y);
        }

        st = new StringTokenizer(br.readLine());
        festival = new Coordinate(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

    }

    private static int calcDist(int x, int y, int x2, int y2) {
        return Math.abs(x - x2) + Math.abs(y - y2);
    }

}
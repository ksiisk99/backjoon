import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder sb = new StringBuilder();
    private static int N, M;
    private static List<Wall> troll = new ArrayList<>();
    private static int[] rooms;

    static class Wall implements Comparable<Wall> {
        int x;
        int y;

        public Wall(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Wall o) {
            return x - o.x;
        }
    }

    public static void main(String[] args) throws IOException {
        input();

        Collections.sort(troll);
        for (Wall wall : troll) {
            int x = wall.x;
            int y = wall.y;

            int num = rooms[x];
            for (int i = x + 1; i <= y; i++) {
                rooms[i] = num;
            }
        }

        int answer = N;
        int num = rooms[1];

        for (int i = 2; i <= N; i++) {
            if (rooms[i] != num) {
                num = rooms[i];
            } else {
                answer--;
            }
        }

        System.out.println(answer);
    }

    private static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        rooms = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            rooms[i] = i;
        }

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            troll.add(new Wall(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

    }

}
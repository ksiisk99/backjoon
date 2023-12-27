import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder sb = new StringBuilder();
    private static int N, K;
    private static List<Nation> countries = new ArrayList<>();
    private static Nation targetNation;

    static class Nation {
        int id;
        int gold;
        int silver;
        int bronze;

        public Nation(int id, int gold, int silver, int bronze) {
            this.id = id;
            this.gold = gold;
            this.silver = silver;
            this.bronze = bronze;
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        int rank = 1;

        for (Nation nation : countries) {
            if (isLose(nation)) {
                rank++;
            }
        }

        System.out.print(rank);
    }

    private static boolean isLose(Nation otherNation) {
        if (targetNation.gold != otherNation.gold) {
            return otherNation.gold < targetNation.gold;
        } else if (targetNation.silver != otherNation.silver) {
            return otherNation.silver < targetNation.silver;
        }
        return otherNation.bronze < targetNation.bronze;
    }

    private static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int id = Integer.parseInt(st.nextToken());
            int gold = Integer.parseInt(st.nextToken());
            int silver = Integer.parseInt(st.nextToken());
            int bronze = Integer.parseInt(st.nextToken());

            Nation nation = new Nation(id, gold, silver, bronze);
            if (id == K) {
                targetNation = nation;
                continue;
            }
            countries.add(nation);
        }
    }
}
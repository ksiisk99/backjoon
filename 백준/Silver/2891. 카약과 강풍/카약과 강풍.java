import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder sb = new StringBuilder();
    private static int N, S, R;
    private static Set<Integer> poorTeams = new HashSet<>();
    private static List<Integer> richTeams = new ArrayList<>();


    public static void main(String[] args) throws IOException {
        input();

        for (int i = 0; i < richTeams.size(); i++) {
            int num = richTeams.get(i);
            if (poorTeams.remove(num)) {
                richTeams.remove(Integer.valueOf(num));
                i--;
            }
        }

        for (int num : richTeams) {
            if (poorTeams.remove(num - 1)) {
                continue;
            }

            poorTeams.remove(num + 1);
        }

        System.out.print(poorTeams.size());
    }

    private static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < S; i++) {
            poorTeams.add(Integer.parseInt(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < R; i++) {
            richTeams.add(Integer.parseInt(st.nextToken()));
        }
    }

}
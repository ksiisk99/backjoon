import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder sb = new StringBuilder();
    private static int U, N;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());

        U = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        List<String>[] list = new ArrayList[U + 1];
        for (int i = 1; i <= U; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            String name = st.nextToken();
            int price = Integer.parseInt(st.nextToken());

            list[price].add(name);
        }

        int minNum = 10001;
        for (int i = 1; i <= U; i++) {
            if (list[i].size() != 0) {
                minNum = Math.min(minNum, list[i].size());
            }
        }

        for (int i = 1; i <= U; i++) {
            if (minNum == list[i].size()) {
                System.out.print(list[i].get(0) + " " + i);
                break;
            }
        }
    }

    private static void input() throws IOException {

    }

}
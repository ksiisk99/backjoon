import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder sb = new StringBuilder();
    private static int N, M;
    private static Set<Integer> students = new HashSet<>();

    public static void main(String[] args) throws IOException {
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            if (N == 0 && M == 0) break;
            int[] 상근 = new int[N];
            int[] 선영 = new int[M];

            for (int i = 0; i < N; i++) {
                상근[i] = Integer.parseInt(br.readLine());
            }

            for (int i = 0; i < M; i++) {
                선영[i] = Integer.parseInt(br.readLine());
            }

            int 상근인덱스 = 0;
            int 선영인덱스 = 0;

            int answer = 0;
            while (상근인덱스 < N && 선영인덱스 < M) {
                if (상근[상근인덱스] < 선영[선영인덱스]) {
                    상근인덱스++;
                } else if (상근[상근인덱스] == 선영[선영인덱스]) {
                    answer++;
                    상근인덱스++;
                    선영인덱스++;
                } else {
                    선영인덱스++;
                }
            }

            sb.append(answer + "\n");
        }

        System.out.print(sb.toString());
    }

    private static void input() throws IOException {

    }

}
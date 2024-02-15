import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder answer = new StringBuilder();
    private static int N, M, q;
    private static int[][] arr;
    private static List<String> queries = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        input();

        for (String query : queries) {
            StringTokenizer st = new StringTokenizer(query);
            int type = Integer.parseInt(st.nextToken());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());

            if (type == 0) {
                int k = Integer.parseInt(st.nextToken());
                arr[i][j] = k;
            } else {
                swap(i, j);
            }
        }

        String answer = Arrays.stream(arr)
                .map(row -> Arrays.stream(row)
                        .mapToObj(String::valueOf)
                        .collect(Collectors.joining(" ")))
                .collect(Collectors.joining("\n"));

        System.out.println(answer);
    }

    private static void swap(int i, int j) {
        for (int col = 0; col < M; col++) {
            int temp = arr[i][col];
            arr[i][col] = arr[j][col];
            arr[j][col] = temp;
        }
    }

    private static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        q = Integer.parseInt(st.nextToken());
        arr = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < q; i++) {
            queries.add(br.readLine());
        }

    }

}
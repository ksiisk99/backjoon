import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder answer = new StringBuilder();
    private static int N, M;

    public static void main(String[] args) throws IOException {
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            if (N == 0 && M == 0) break;

            Map<Integer, Integer> map = new HashMap<>();
            List<Integer> list = new ArrayList<>();
            int firstPoint = 0;
            int secondPoint = 0;

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());

                for (int j = 0; j < M; j++) {
                    Integer number = Integer.parseInt(st.nextToken());

                    int point = map.getOrDefault(number, 0) + 1;
                    map.put(number, point);

                    if (firstPoint < point) {
                        firstPoint = point;
                    } else if (secondPoint < point) {
                        secondPoint = point;
                    }
                }
            }

            final int sp = secondPoint;
            String result = map.entrySet()
                    .stream()
                    .sorted(Map.Entry.comparingByKey())
                    .filter(s -> s.getValue() == sp)
                    .map(s -> s.getKey().toString())
                    .collect(Collectors.joining(" "));

            answer.append(result + "\n");
        }

        System.out.print(answer.toString());
    }

    private static void input() throws IOException {

    }

}
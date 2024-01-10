import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder sb = new StringBuilder();
    private static int N, K;
    private static List<String> numbers = new ArrayList<>();
    private static Set<String> cards = new HashSet<>();
    private static boolean[] check;

    private static int recursive(int count, String number) {
        if (count == K) {
            if (cards.contains(number)) {
                return 0;
            }
            cards.add(number);
            return 1;
        }

        int answer = 0;
        for (int i = 0; i < N; i++) {
            if (!check[i]) {
                check[i] = true;
                answer += recursive(count + 1, number + numbers.get(i));
                check[i] = false;
            }
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        input();

        System.out.print(recursive(0, ""));
    }

    private static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());
        check = new boolean[N];

        for (int i = 0; i < N; i++) {
            numbers.add(br.readLine());
        }
    }

}
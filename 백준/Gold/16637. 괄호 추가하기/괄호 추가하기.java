import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    private static StringBuilder sb = new StringBuilder();
    private static int N, result;
    private static List<Integer> numbers;
    private static List<Character> operands;
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


    public static void main(String[] args) throws IOException {
        input();
        result = Integer.MIN_VALUE;
        bruteForce(0, numbers.get(0));
        System.out.print(result);
    }

    private static void bruteForce(int idx, int ans) {
        if (idx == operands.size()) {
            result = Math.max(result, ans);
            return;
        }

        bruteForce(idx + 1, calculate(ans, numbers.get(idx + 1), operands.get(idx)));

        if (idx + 1 < operands.size()) {
            int tmp = calculate(numbers.get(idx + 1), numbers.get(idx + 2), operands.get(idx + 1));
            bruteForce(idx + 2, calculate(ans, tmp, operands.get(idx)));
        }

    }

    private static int calculate(int n, int n2, char oper) {
        switch (oper) {
            case '+':
                return n + n2;
            case '-':
                return n - n2;
            default:
                return n * n2;
        }
    }


    private static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        String s = br.readLine();
        numbers = new ArrayList<>();
        operands = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (i % 2 == 0) {
                numbers.add(c - '0');
            } else {
                operands.add(c);
            }
        }
    }

}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int N;
    private static String str;

    public static void main(String[] args) throws IOException {
        input();

        Stack<String> left = str.chars()
                .mapToObj(c -> String.valueOf((char) c))
                .collect(Collectors.toCollection(Stack::new));
        Stack<String> right = new Stack<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String type = st.nextToken();

            if (type.equals("P")) {
                left.push(st.nextToken());
            } else if (type.equals("L")) {
                if (!left.isEmpty()) right.push(left.pop());
            } else if (type.equals("D")) {
                if (!right.isEmpty()) left.push(right.pop());
            } else if (type.equals("B")) {
                if (!left.isEmpty()) left.pop();
            }
        }

        while (!left.isEmpty()) {
            right.push(left.pop());
        }

        StringBuilder sb = new StringBuilder();
        for (String s : right) {
            sb.append(s);
        }
        System.out.print(sb.reverse().toString());
    }


    private static void input() throws IOException {
        str = br.readLine();

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());


    }
}
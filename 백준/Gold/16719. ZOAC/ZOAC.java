import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

interface MyFunction {
    int apply(int x);
}

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static boolean[] check;
    private static String s;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        s = br.readLine();
        check = new boolean[s.length()];

        recursive(0, s.length() - 1);

        System.out.print(sb.toString());
    }

    private static void recursive(int left, int right) {
        if (left > right) return;

        int idx = left;

        for (int i = left; i <= right; i++) {
            if (s.charAt(idx) > s.charAt(i)) {
                idx = i;
            }
        }

        check[idx] = true;

        for (int i = 0; i < s.length(); i++) {
            if (check[i]) {
                sb.append(s.charAt(i));
            }
        }
        sb.append("\n");

        recursive(idx + 1, right);
        recursive(left, idx - 1);
    }

    private static void input() throws IOException {

    }

}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        String s = br.readLine();

        Stack<Integer> len = new Stack<>();
        Stack<Integer> mul = new Stack<>();

        int lenCnt = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                lenCnt--;
                len.push(lenCnt);
                mul.push(s.charAt(i - 1) - '0');
                lenCnt = 0;

            } else if (c == ')') {
                int result = lenCnt * mul.pop();
                lenCnt = result + len.pop();
            } else {
                lenCnt++;
            }
        }

        System.out.println(lenCnt);
    }

}

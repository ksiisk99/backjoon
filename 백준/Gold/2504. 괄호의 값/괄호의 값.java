import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static String s;


    public static void main(String[] args) throws IOException {
        input();

        Stack<Character> stack = new Stack<>();
        int answer = 0;
        int tmp = 1;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                tmp *= 2;
                stack.push('(');
            } else if (s.charAt(i) == '[') {
                tmp *= 3;
                stack.push('[');
            } else if (s.charAt(i) == ')') {
                if (stack.isEmpty() || stack.peek() != '(') {
                    answer = 0;
                    break;
                }

                if (s.charAt(i - 1) == '(') {
                    answer += tmp;
                }
                tmp /= 2;
                stack.pop();
            } else if (s.charAt(i) == ']') {
                if (stack.isEmpty() || stack.peek() != '[') {
                    answer = 0;
                    break;
                }
                if (s.charAt(i - 1) == '[') {
                    answer += tmp;
                }
                tmp /= 3;
                stack.pop();
            }
        }

        if (!stack.isEmpty()) {
            answer = 0;
        }
        System.out.print(answer);
    }


    public static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        s = st.nextToken();

    }

}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static StringBuilder sb;
    private static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        String s = br.readLine();
        String boom = br.readLine();

        Stack<String> stack = new Stack<>();
        Stack<Integer> boomStack = new Stack<>();
        int boomIdx = 0;
        int boomSize = boom.length();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == boom.charAt(boomIdx)) {
                boomIdx++;
                if (boomIdx == boomSize) {
                    calcBoom(stack, boomSize);
                    if (!boomStack.isEmpty())
                        boomIdx = boomStack.pop();
                    else
                        boomIdx = 0;
                } else {
                    stack.push(String.valueOf(c));
                }
            } else {
                stack.push(String.valueOf(c));
                boomStack.push(boomIdx);
                if (boomIdx > 0) {
                    boomIdx=0;
                    if (c == boom.charAt(boomIdx)) {
                        boomIdx++;
                    }else{
                        boomStack.pop();
                    }
                }
            }
        }
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        System.out.print(sb.length() == 0 ? "FRULA" : sb.reverse().toString());
    }

    public static void calcBoom(Stack<String> stack, int boomSize) {
        for (int i = 0; i < boomSize - 1; i++) {
            stack.pop();
        }
    }

}
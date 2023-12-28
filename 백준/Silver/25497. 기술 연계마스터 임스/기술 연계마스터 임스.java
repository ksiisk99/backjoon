import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder sb = new StringBuilder();
    private static int N;
    private static String ims;
    private static Stack<Character> lrStack = new Stack<>();
    private static Stack<Character> skStack = new Stack<>();
    private static boolean isPlay = true;

    public static void main(String[] args) throws IOException {
        input();

        int answer = 0;

        for (int i = 0; i < ims.length() && isPlay; i++) {
            char skill = ims.charAt(i);

            if (hasUtilizedSkill(skill)) {
                answer++;
            }
        }

        System.out.print(answer);
    }

    private static boolean hasUtilizedSkill(char skill) {
        if (is기본기술(skill)) {
            return true;
        }

        if (is사전기술(skill)) {
            return false;
        }

        if (can본기술(skill)) {
            return true;
        }

        return false;
    }

    private static boolean can본기술(char skill) {
        Stack<Character> stack = findRequiredStack(skill);

        if(stack.isEmpty()) {
            isPlay = false;
            return false;
        }

        stack.pop();
        return true;

    }

    private static Stack<Character> findRequiredStack(char skill) {
        if (skill == 'R') {
            return lrStack;
        }
        return skStack;
    }

    private static boolean is기본기술(char skill) {
        if (skill >= '1' && skill <= '9') {
            return true;
        }
        return false;
    }

    private static boolean is사전기술(char skill) {
        if (skill == 'L') {
            lrStack.push(skill);
            return true;
        } else if (skill == 'S') {
            skStack.push(skill);
            return true;
        }
        return false;
    }

    private static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        ims = br.readLine();
    }
}
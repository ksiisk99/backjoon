import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int N;
    private static Question[] questions;

    public static class Question {
        int num;
        int strike;
        int ball;

        public Question(int num, int strike, int ball) {
            this.num = num;
            this.strike = strike;
            this.ball = ball;
        }
    }

    public static void main(String[] args) throws IOException {
        input();

        int answer = 0;
        for (int n = 123; n <= 987; n++) {
            if (sameNumber(n) || hasZero(n)) {
                continue;
            }

            int successCnt = 0;

            for (int i = 0; i < N; i++) {
                int strike = calcStrike(n, questions[i].num);
                int ball = calcBall(n, questions[i].num);

                if (strike == questions[i].strike && ball == questions[i].ball) {
                    successCnt++;
                }
            }

            if (successCnt == N) {
                answer++;
            }
        }
        System.out.print(answer);
    }

    private static boolean hasZero(int n) {
        for (int i = 0; i < 3; i++) {
            if (n % 10 == 0) {
                return true;
            }
            n /= 10;
        }
        return false;
    }

    private static int calcStrike(int n, int n2) {
        int result = 0;

        for (int i = 0; i < 3; i++) {
            if (n % 10 == n2 % 10) {
                result++;
            }
            n /= 10;
            n2 /= 10;
        }
        return result;
    }

    private static int calcBall(int n, int n2) {
        int result = 0;


        for (int i = 0; i < 3; i++) {
            int temp = n2;
            for (int j = 0; j < 3; j++) {
                if (i != j && temp % 10 == n % 10) {
                    result++;
                }
                temp /= 10;
            }
            n /= 10;
        }
        return result;
    }

    private static boolean sameNumber(int n) {
        int a = n / 100;
        int b = (n % 100) / 10;
        int c = (n % 10);

        if (a == b || a == c || b == c) return true;
        return false;
    }

    public static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        questions = new Question[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            questions[i] = new Question(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
    }
}
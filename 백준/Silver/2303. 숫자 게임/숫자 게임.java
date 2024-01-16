import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder sb = new StringBuilder();
    private static int N;
    private static int[][] cards;


    public static void main(String[] args) throws IOException {
        input();

        int maxScore = -1;
        int answer = 0;

        for (int n = 1; n <= N; n++) {
            int totalScore = calculateTotalScore(cards[n]);

            for (int i = 0; i < 4; i++) {
                for (int j = i + 1; j < 5; j++) {
                    int temp = totalScore - (cards[n][i] + cards[n][j]);
                    temp %= 10;
                    if (temp >= maxScore) {
                        answer = n;
                        maxScore = temp;
                    }
                }
            }
        }

        System.out.print(answer);
    }

    private static int calculateTotalScore(int[] numbers) {
        int result = 0;
        for (int i = 0; i < 5; i++) {
            result += numbers[i];
        }
        return result;
    }

    private static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        cards = new int[N + 1][5];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < 5; j++) {
                cards[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

}
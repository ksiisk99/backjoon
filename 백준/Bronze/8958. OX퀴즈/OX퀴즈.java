import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder sb = new StringBuilder();
    private static int N;
    private static List<String> quiz = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        input();

        for (int i = 0; i < N; i++) {
            int score = calculateScore(i);
            sb.append(score);
            sb.append("\n");
        }

        System.out.print(sb.toString());
    }

    private static int calculateScore(int index) {
        int score = 0; //최종 스코어
        int oCount = 0;

        String ox = quiz.get(index);
        for (int i = 0; i < ox.length(); i++) {
            if (ox.charAt(i) == 'O') {
                oCount++;
            } else {
                oCount = 0;
            }
            score += oCount;
        }

        return score;
    }


    private static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        for (int i = 0; i < N; i++) {
            quiz.add(br.readLine());
        }
    }
}
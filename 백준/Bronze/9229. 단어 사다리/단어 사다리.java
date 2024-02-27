import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder answer = new StringBuilder();
    private static List<String> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        int cnt = 0;

        while (true) {
            String word = br.readLine();
            if (word.equals("#")) {
                cnt++;

                if (cnt == 2) {
                    break;
                }

                if (canWordLadder()) {
                    answer.append("Correct\n");
                } else {
                    answer.append("Incorrect\n");
                }

                list = new ArrayList<>();
                continue;
            }

            list.add(word);

            cnt = 0;
        }

        System.out.print(answer.toString());
    }

    private static boolean canWordLadder() {
        for (int i = 0; i < list.size() - 1; i++) {
            String word = list.get(i);
            String nextWord = list.get(i + 1);

            if (!next(word, nextWord)) {
                return false;
            }
        }

        return true;
    }

    private static boolean next(String word, String nextWord) {
        if (word.length() != nextWord.length()) return false;

        int diffWordCount = 0;
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) != nextWord.charAt(i)) {
                diffWordCount++;
            }
        }

        if (diffWordCount != 1) {
            return false;
        }

        return true;
    }

    private static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
    }

}


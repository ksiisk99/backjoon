import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int T;
    private static List<String> arr = new ArrayList<>();


    public static void main(String[] args) throws IOException {
        input();

        StringBuilder sb = new StringBuilder();
        for (String s : arr) {
            char[] word = s.toCharArray();
            int idx = -1;

            for (int i = word.length - 1; i > 0; i--) {
                if (word[i - 1] < word[i]) {
                    idx = i - 1;
                    break;
                }
            }

            if (idx == -1) {
                sb.append(s);
                sb.append("\n");
            } else {
                int idx2 = 0;
                for (int i = word.length - 1; i >= 0; i--) {
                    if (word[idx] < word[i]) {
                        idx2 = i;
                        break;
                    }
                }

                char tmp = word[idx];
                word[idx] = word[idx2];
                word[idx2] = tmp;

                Arrays.sort(word, idx + 1, word.length);
                sb.append(word);
                sb.append("\n");
            }
        }

        System.out.print(sb.toString());
    }

    public static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        T = Integer.parseInt(st.nextToken());

        for (int i = 0; i < T; i++) {
            arr.add(br.readLine());
        }
    }

}
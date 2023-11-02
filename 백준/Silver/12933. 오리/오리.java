import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static String s;
    private static boolean[] visit;

    public static void main(String[] args) throws IOException {
        input();

        int answer = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != 'q' || (s.charAt(i) == 'q' && visit[i])) {
                continue;
            }

            int cnt = 0;
            boolean isDuck = false;
            for (int j = i; j < s.length(); j++) {
                if (visit[j]) continue;

                char c = s.charAt(j);
                if (cnt == 0 && c == 'q') {
                    cnt++;
                    visit[j] = true;
                } else if (cnt == 1 && c == 'u') {
                    cnt++;
                    visit[j] = true;
                } else if (cnt == 2 && c == 'a') {
                    cnt++;
                    visit[j] = true;
                } else if (cnt == 3 && c == 'c') {
                    cnt++;
                    visit[j] = true;
                } else if (cnt == 4 && c == 'k') {
                    cnt++;
                    visit[j] = true;
                }

                if (cnt == 5) {
                    isDuck = true;
                    cnt = 0;
                }
            }
            if (isDuck && cnt == 0) {
                answer++;
            } else {
                visit[0] = false;
                break;
            }
        }

        for (int i = 0; i < s.length(); i++) {
            if (!visit[i]) {
                answer = -1;
                break;
            }
        }

        System.out.print(answer);
    }

    private static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        s = st.nextToken();
        visit = new boolean[s.length()];
    }
}

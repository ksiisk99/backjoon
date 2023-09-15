import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int N;
    private static String str;
    private static List<String> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        input();
        int answer = 0;

        int[] alpha = makeAlphaCount(str);

        for (int i = 0; i < N; i++) {
            String s = list.get(i);
            int[] alpha2 = makeAlphaCount(s);

            int addMinusCnt = 0;
            int diffCnt = 0;
            int diffCnt2 = 0;
            for (int j = 0; j < 26; j++) {
                addMinusCnt += Math.abs(alpha[j] - alpha2[j]);
                if (alpha[j] >= alpha2[j]) {
                    diffCnt += Math.abs(alpha[j] - alpha2[j]);
                } else {
                    diffCnt2 += Math.abs(alpha[j] - alpha2[j]);
                }
            }
            //System.out.println(addMinusCnt + " " + diffCnt + " " + diffCnt2);
            if (addMinusCnt <= 1) {
                answer++;
            } else if (s.length() == str.length() && diffCnt == 1 && diffCnt2 == 1) {
                answer++;
            }
        }
        System.out.print(answer);
    }

    public static int[] makeAlphaCount(String s) {
        int[] alpha = new int[26];
        for (int i = 0; i < s.length(); i++) {
            alpha[s.charAt(i) - 'A']++;
        }
        return alpha;
    }


    public static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()) - 1;
        str = br.readLine();
        for (int i = 0; i < N; i++) {
            list.add(br.readLine());
        }
    }
}
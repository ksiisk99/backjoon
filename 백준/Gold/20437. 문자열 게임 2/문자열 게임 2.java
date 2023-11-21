import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            String W = br.readLine();
            int K = Integer.parseInt(br.readLine());
            
            if(K==1) {
                sb.append("1 1\n");
                continue;
            }

            solve(W, K);
        }

        System.out.print(sb.toString());
    }


    private static void solve(String w, int k) {
        int min = Integer.MAX_VALUE;
        int max = 0;
        for (int i = 0; i < w.length(); i++) {
            int cnt = 1;
            for (int j = i + 1; j < w.length(); j++) {
                if (w.charAt(i) == w.charAt(j)) {
                    cnt++;
                }

                if (cnt == k) {
                    int length = j - i + 1;
                    min = Math.min(min, length);
                    max = Math.max(max, length);
                    break;
                }
            }
        }

        if (min == Integer.MAX_VALUE || max == 0) {
            sb.append("-1\n");
        } else {
            sb.append(min + " " + max + "\n");
        }
    }

    private static void input() throws IOException {

    }

}

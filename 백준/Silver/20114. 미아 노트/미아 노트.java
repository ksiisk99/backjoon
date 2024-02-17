import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder answer = new StringBuilder();
    private static int N, H, W;
    private static List<String> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        input();


        for (int w = 0; w < (N * W); w += W) {
            boolean check = false;

            for (int h = 0; h < H && !check; h++) {
                String s = list.get(h);

                for (int i = 0; i < W; i++) {
                    if (s.charAt(w + i) != '?') {
                        answer.append(s.charAt(w + i));
                        check = true;
                        break;
                    }
                }

            }

            if (!check) {
                answer.append("?");
            }
        }


        System.out.print(
                answer.length() == N
                        ? answer.toString()
                        : "?"
        );
    }


    private static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());

        for (int h = 0; h < H; h++) {
            list.add(br.readLine());
        }
    }

}
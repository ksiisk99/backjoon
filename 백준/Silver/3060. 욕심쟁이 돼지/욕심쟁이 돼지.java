import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder sb = new StringBuilder();


    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());

        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());

            int[] pig = new int[6];
            for (int i = 0; i < 6; i++) {
                pig[i] = Integer.parseInt(st.nextToken());
            }

            int day = 1;
            while (true) {
                int 사료 = N;
                for (int i = 0; i < 6; i++) {
                    사료 -= pig[i];
                }

                if (사료 < 0) {
                    break;
                }

                int[] newPig = new int[6];
                for (int i = 0; i < 6; i++) {
                    newPig[i] = pig[i] + (pig[(i + 5) % 6] + pig[(i + 1) % 6] + pig[(i + 3) % 6]);
                }

                pig = newPig;
                day++;
            }

            sb.append(day + "\n");
        }

        System.out.print(sb.toString());
    }

    private static void input() throws IOException {

    }

}
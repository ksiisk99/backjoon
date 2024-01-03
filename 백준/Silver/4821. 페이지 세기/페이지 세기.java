import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        while (true) {
            int N = Integer.parseInt(br.readLine());
            if (N == 0) break;

            boolean[] page = new boolean[N + 1];
            String input = br.readLine();

            String[] pages = input.split(",");
            int result = 0;
            for (int i = 0; i < pages.length; i++) {
                String[] temp = pages[i].split("-");
                if (temp.length == 1) {
                    int page1 = Integer.parseInt(temp[0]);
                    if (page1 <= N && !page[page1]) {
                        page[page1] = true;
                        result++;
                    }
                    continue;
                }

                int page1 = Integer.parseInt(temp[0]);
                int page2 = Integer.parseInt(temp[1]);

                if (page1 > page2) continue;

                for (int j = page1; j <= page2 && j <= N; j++) {
                    if (!page[j]) {
                        page[j] = true;
                        result++;
                    }
                }
            }

            sb.append(result + "\n");

        }

        System.out.print(sb.toString());
    }

    private static void input() throws IOException {

    }

}
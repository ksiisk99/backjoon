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
    private static int[] dx = {0, 1, 0, -1};
    private static int[] dy = {1, 0, -1, 0};
    private static final int VISIT = 2;

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());

        while ((T--) > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int R = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            String s = st.nextToken();

            int[][] arr = createArr(R, C, s);

            String result = convert(R, C, arr);

            answer.append(result.trim());
            answer.append("\n");
        }

        System.out.print(answer.toString());
    }

    private static String convert(int R, int C, int[][] arr) {
        int x = 0, y = 0, d = 0, total = 0;

        StringBuilder word = new StringBuilder();
        StringBuilder answer = new StringBuilder();

        while (total < (R * C)) {
            word.append(arr[x][y]);
            total++;

            if (word.length() == 5) {
                int temp = Integer.parseInt(word.toString(), 2);
                if (temp == 0) {
                    answer.append(" ");
                } else {
                    answer.append((char) (temp - 1 + 'A'));
                }
                word.setLength(0);
            }

            int nx = x + dx[d];
            int ny = y + dy[d];

            if (nx < 0 || ny < 0 || nx >= R || ny >= C || arr[nx][ny] == VISIT) {
                d = (d + 1) % 4;
                nx = x + dx[d];
                ny = y + dy[d];
            }

            arr[x][y] = VISIT;
            x = nx;
            y = ny;
        }

        return answer.toString();
    }

    private static int[][] createArr(int r, int c, String s) {
        int[][] arr = new int[r][c];

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                int index = i * c + j;

                if (index >= s.length()) break;
                arr[i][j] = s.charAt(index) - '0';
            }
        }

        return arr;
    }

    private static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
    }

}
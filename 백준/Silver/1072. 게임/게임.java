import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder answer = new StringBuilder();
    private static int X, Y;

    public static void main(String[] args) throws IOException {
        input();

        int 목표승률 = calculate승률(X, Y);
        if(목표승률>=99) {
            System.out.print(-1);
            return;
        }

        int minWin = binary(목표승률);
        System.out.print(minWin == 0 ? -1 : minWin);
    }

    private static int binary(int 목표승률) {
        int left = 0, right = 1_000_000_000;
        int minWin = 0;

        while (left <= right) {
            int mid = (left + right) / 2;

            int 승률 = calculate승률(X + mid, Y + mid);
            if (목표승률 >= 승률) {
                left = mid + 1;
                minWin = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return minWin;
    }

    private static int calculate승률(double total, double win) {
        return (int) (win * 100 / total);
    }

    private static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());
    }
}


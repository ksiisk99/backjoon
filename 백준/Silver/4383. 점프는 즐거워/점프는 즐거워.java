import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        String input;

        while (true) {
            input = br.readLine();
            if(input==null || input.isEmpty()) {
                break;
            }

            String[] arr = input.trim().split("\\s+");
            if (arr.length == 2) {
                sb.append("Jolly\n");
                continue;
            }

            int N = Integer.parseInt(arr[0]);
            boolean[] check = new boolean[N];
            int jollyCount = 0;

            for (int i = 2; i <= N; i++) {
                int dist = Math.abs(Integer.parseInt(arr[i]) - Integer.parseInt(arr[i - 1]));

                if (dist < N && !check[dist]) {
                    check[dist] = true;
                    jollyCount++;
                }
            }

            if (jollyCount == (N - 1)) {
                sb.append("Jolly\n");
            } else {
                sb.append("Not jolly\n");
            }

        }

        System.out.print(sb.toString());
    }

    private static void input() throws IOException {

    }

}
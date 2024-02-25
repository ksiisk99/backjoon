import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder answer = new StringBuilder();
    private static int T, N;
    private static Boolean[] time;


    public static void main(String[] args) throws IOException {
        input();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int start = calculateSleepTime(st.nextToken(), Integer.parseInt(st.nextToken()));
            int end = calculateSleepTime(st.nextToken(), Integer.parseInt(st.nextToken()));

            for (int j = start + 1; j <= end; j++) {
                time[j] = true;
            }
        }

        int sleepTime = (int) Arrays.stream(time)
                .filter(Boolean::booleanValue)
                .count();

        if (sleepTime >= T) {
            System.out.print(0);
            return;
        }

        int 부족한시간 = T - sleepTime;
        System.out.print(
                부족한시간 > 48 ? "-1" : 부족한시간
        );

    }

    private static int calculateSleepTime(String day, int hour) {
        if (day.equals("Mon")) {
            return hour;
        } else if (day.equals("Tue")) {
            return 24 + hour;
        } else if (day.equals("Wed")) {
            return 2 * 24 + hour;
        } else if (day.equals("Thu")) {
            return 3 * 24 + hour;
        } else {
            return 4 * 24 + hour;
        }
    }

    private static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        T = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        time = new Boolean[24 * 7];
        Arrays.fill(time, false);
    }

}


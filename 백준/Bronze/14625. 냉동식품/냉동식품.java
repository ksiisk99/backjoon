import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder sb = new StringBuilder();
    private static int startHour, startMin, endHour, endMin, N;

    public static void main(String[] args) throws IOException {
        input();

        int answer = 0;
        int currentHour = startHour;
        int currentMin = startMin;

        while (currentHour <= endHour) {
            if (checkNumber(currentHour) || checkNumber(currentMin)) {
                answer++;
            }

            currentMin++;

            if (currentHour == endHour && currentMin > endMin) {
                break;
            }
            
            if (currentMin == 60) {
                currentHour++;
                currentMin = 0;
            }
            
        }

        System.out.print(answer);
    }

    private static boolean checkNumber(int time) {
        if (time % 10 == N || time / 10 == N) {
            return true;
        }
        return false;
    }

    private static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        startHour = Integer.parseInt(st.nextToken());
        startMin = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        endHour = Integer.parseInt(st.nextToken());
        endMin = Integer.parseInt(st.nextToken());

        N = Integer.parseInt(br.readLine());
    }

}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int S, E, Q;
    private static List<Info> infos = new ArrayList<>();

    static class Info {
        int min;
        String name;

        public Info(int min, String name) {
            this.min = min;
            this.name = name;
        }
    }

    public static void main(String[] args) throws IOException {
        input();

        Set<String> visit = new HashSet<>();
        int answer = 0;

        for (Info info : infos) {
            if (info.min <= S) {
                visit.add(info.name);
            } else if(info.min>=E && info.min<=Q && visit.contains(info.name)) {
                visit.remove(info.name);
                answer++;
            }
        }

        System.out.print(answer);
    }


    public static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        S = convertMinute(st.nextToken());
        E = convertMinute(st.nextToken());
        Q = convertMinute(st.nextToken());

        String str = null;
        while (true) {
            str = br.readLine();
            if(str == null || str.isEmpty()) {
                break;
            }
            st = new StringTokenizer(str);

            infos.add(new Info(convertMinute(st.nextToken()), st.nextToken()));
        }
    }

    private static int convertMinute(String time) {
        int hour = Integer.parseInt(time.substring(0, 2)) * 60;
        int min = Integer.parseInt(time.substring(3));

        return hour + min;
    }

}
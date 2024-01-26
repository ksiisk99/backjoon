import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder sb = new StringBuilder();
    private static int N, M;
    private static List<Info> load = new ArrayList<>();
    private static List<Info> 연정 = new ArrayList<>();

    private static class Info {
        int length;
        int speed;

        public Info(int length, int speed) {
            this.length = length;
            this.speed = speed;
        }
    }

    public static void main(String[] args) throws IOException {
        input();

        int answer = 0;
        int loadIndex = 0;
        int 연정Index = 0;

        while (loadIndex < N && 연정Index < M) {
            Info loadInfo = load.get(loadIndex);
            Info 연정Info = 연정.get(연정Index);

            answer = Math.max(answer, 연정Info.speed - loadInfo.speed);

            if (loadInfo.length > 연정Info.length) {
                loadInfo.length -= 연정Info.length;
                연정Index++;
            } else if (loadInfo.length < 연정Info.length) {
                연정Info.length -= loadInfo.length;
                loadIndex++;
            } else {
                연정Index++;
                loadIndex++;
            }
        }

        System.out.print(answer);
    }

    private static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int length = Integer.parseInt(st.nextToken());
            int speed = Integer.parseInt(st.nextToken());

            load.add(new Info(length, speed));
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int length = Integer.parseInt(st.nextToken());
            int speed = Integer.parseInt(st.nextToken());

            연정.add(new Info(length, speed));
        }
    }

}
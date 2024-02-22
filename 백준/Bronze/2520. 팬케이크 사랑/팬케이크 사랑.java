import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder answer = new StringBuilder();
    private static int 우유, 노른자, 설탕, 소금, 밀가루;
    private static int 바나나, 딸기잼, 초콜릿, 호두;

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());

        while ((T--) > 0) {
            input();

            int 반죽 = Integer.MAX_VALUE;
            반죽 = Math.min(반죽, (int) (16 * (우유 / 8.0)));
            반죽 = Math.min(반죽, (int) (16 * (노른자 / 8.0)));
            반죽 = Math.min(반죽, (int) (16 * (설탕 / 4.0)));
            반죽 = Math.min(반죽, 16 * 소금);
            반죽 = Math.min(반죽, (int) (16 * (밀가루 / 9.0)));

            int result = 0;
            int used = Math.max(0, Math.min(바나나, 반죽));
            result += used;
            반죽 -= used;

            used = Math.max(0, Math.min(초콜릿, 반죽));
            result += used;
            반죽 -= used;

            used = Math.max(0, Math.min(딸기잼, 반죽));
            result += used;
            반죽 -= used;

            used = Math.max(0, Math.min(호두, 반죽));
            result += used;

            answer.append(result + "\n");
        }

        System.out.print(answer.toString());
    }


    private static void input() throws IOException {
        br.readLine();

        StringTokenizer st = new StringTokenizer(br.readLine());
        우유 = Integer.parseInt(st.nextToken());
        노른자 = Integer.parseInt(st.nextToken());
        설탕 = Integer.parseInt(st.nextToken());
        소금 = Integer.parseInt(st.nextToken());
        밀가루 = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        바나나 = Integer.parseInt(st.nextToken());
        딸기잼 = Integer.parseInt(st.nextToken()) / 30;
        초콜릿 = Integer.parseInt(st.nextToken()) / 25;
        호두 = Integer.parseInt(st.nextToken()) / 10;
    }

}
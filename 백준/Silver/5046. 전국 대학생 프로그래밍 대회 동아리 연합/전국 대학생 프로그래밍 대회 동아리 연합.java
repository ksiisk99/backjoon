import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder sb = new StringBuilder();
    private static int N, B, H, W;

    public static void main(String[] args) throws IOException {
        input();

        int answer = 500001;

        for (int h = 0; h < H; h++) {
            int cost = Integer.parseInt(br.readLine());

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < W; i++) {
                int 투숙가능인원 = Integer.parseInt(st.nextToken());

                int hotelCost = N * cost;

                if (hotelCost <= B && 투숙가능인원 >= N) {
                    answer = Math.min(answer, hotelCost);
                }
            }
        }

        if (answer == 500001) {
            System.out.print("stay home");
        } else {
            System.out.print(answer);
        }

    }

    private static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
    }

}
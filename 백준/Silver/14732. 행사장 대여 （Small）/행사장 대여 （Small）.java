import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder answer = new StringBuilder();
    private static int N;
    private static boolean[][] room = new boolean[501][501];
    private static int count = 0;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            mark(x1, y1, x2, y2);
        }

        System.out.println(calculateArea());
    }

    private static int calculateArea() {
        int area = 0;

        for (int i = 0; i <= 500; i++) {
            for (int j = 0; j <= 500; j++) {
                if(room[i][j]) {
                    area++;
                }
            }
        }

        return area;
    }

    private static void mark(int x1, int y1, int x2, int y2) {
        for (int i = x1; i < x2; i++) {
            for (int j = y1; j < y2; j++) {
                room[i][j] = true;
            }
        }
    }


    private static void input() throws IOException {

    }

}
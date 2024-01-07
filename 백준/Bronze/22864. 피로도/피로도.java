import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder sb = new StringBuilder();
    private static int A, B, C, M;

    public static void main(String[] args) throws IOException {
        input();

        int energy = 0;
        int answer = 0;
        for (int hour = 1; hour <= 24; hour++) {
            if (energy + A <= M) {
                energy += A;
                answer += B;
            } else {
                energy -= C;
                if(energy < 0){
                    energy = 0;
                }
            }
        }

        System.out.print(answer);
    }

    private static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
    }

}
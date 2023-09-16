import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static double N;
    private static double[][] point = new double[3][2];

    public static void main(String[] args) throws IOException {
        input();

        for (int i = 0; i < 3; i++) {
            if (point[i][0] == point[i][1]) continue;
            
            double mid = (point[i][0] + point[i][1]) / 2;
            for (int j = i + 1; j < 3; j++) {
                if (point[j][0] < mid) {
                    point[j][0] += (mid - point[j][0]) * 2;

                }

                if (point[j][1] < mid) {
                    point[j][1] += (mid - point[j][1]) * 2;
                }
                point[j][0] -= mid;
                point[j][1] -= mid;
            }
            if (N / 2 <= mid) {
                N = mid;
            } else {
                N -= mid;
            }
        }

        System.out.print(N);
    }


    public static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Double.parseDouble(st.nextToken());

        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            double a = Double.parseDouble(st.nextToken());
            double b = Double.parseDouble(st.nextToken());
            point[i][0] = Math.min(a, b);
            point[i][1] = Math.max(a, b);
        }
    }
}
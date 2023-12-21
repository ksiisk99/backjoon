import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder sb = new StringBuilder();
    private static int N, k;

    public static void main(String[] args) throws IOException {
        int max = 0;
        int index = -1;

        for (int i = 0; i < 9; i++) {
            int num = input();

            if (max < num) {
                max = num;
                index = i;
            }
        }

        System.out.println(max);
        System.out.println(index + 1);
    }

    private static int input() throws IOException {
        return Integer.parseInt(br.readLine());
    }
}
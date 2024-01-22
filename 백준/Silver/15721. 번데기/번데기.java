import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder sb = new StringBuilder();
    private static int A, T, 구호;

    public static void main(String[] args) throws IOException {
        input();

        List<Integer> list = new ArrayList<>();
        int level = 1;

        while (list.size() < (T * 2)) {
            for (int i = 0; i < 2; i++) {
                list.add(0);
                list.add(1);
            }

            for (int i = 0; i < (level + 1); i++) {
                list.add(0);
            }

            for (int i = 0; i < (level + 1); i++) {
                list.add(1);
            }

            level++;
        }

        int count = 0;
        for (int i = 0; i < list.size() && T > 0; i++) {
            count++;
            if (list.get(i) == 구호) {
                T--;
            }
        }

        System.out.print((count - 1) % A);
    }

    private static void input() throws IOException {
        A = Integer.parseInt(br.readLine());
        T = Integer.parseInt(br.readLine());
        구호 = Integer.parseInt(br.readLine());
    }

}
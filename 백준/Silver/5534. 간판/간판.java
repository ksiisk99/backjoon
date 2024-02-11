import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder answer = new StringBuilder();
    private static int N;
    private static String newName;
    private static List<String> 간판 = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        input();

        System.out.print(
                간판.stream()
                        .filter(Main::can)
                        .count()
        );
    }

    private static boolean can(String name) {
        for (int i = 1; i <= name.length(); i++) {
            for (int j = 0; j < name.length(); j++) {
                StringBuilder sb = new StringBuilder();

                for (int k = j; k < name.length() && sb.length() < newName.length(); k += i) {
                    sb.append(name.charAt(k));
                }

                if (sb.toString().equals(newName)) {
                    return true;
                }
            }
        }

        return false;
    }

    private static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        newName = br.readLine();

        for (int i = 0; i < N; i++) {
            간판.add(br.readLine());
        }
    }

}
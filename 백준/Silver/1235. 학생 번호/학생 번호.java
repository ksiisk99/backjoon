import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder sb = new StringBuilder();
    private static int N, maxLength;
    private static List<String> students = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        input();
        maxLength = students.get(0).length();

        int k = 100;
        for (int length = 1; length <= maxLength; length++) {
            if (solve(length)) {
                k = length;
                break;
            }
        }

        System.out.print(k);
    }

    private static boolean solve(int length) {
        Set<String> numbers = new HashSet<>();

        for (String number : students) {
            String abbreviatedNumber = number.substring(maxLength - length);
            if (numbers.contains(abbreviatedNumber)) {
                return false;
            }

            numbers.add(abbreviatedNumber);
        }

        return true;
    }


    private static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        for (int i = 0; i < N; i++) {
            students.add(br.readLine());
        }
    }
}
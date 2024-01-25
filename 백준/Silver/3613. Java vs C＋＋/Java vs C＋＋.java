import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        String input = br.readLine();

        if (isError(input)) {
            System.out.print("Error!");
            return;
        }

        int snake = input.indexOf('_');
        if (snake == -1) {
            for (int i = 0; i < input.length(); i++) {
                char temp = input.charAt(i);

                if (input.charAt(i) >= 'A' && input.charAt(i) <= 'Z') {
                    sb.append("_");
                    temp = Character.toLowerCase(temp);
                }

                sb.append(temp);
            }
        } else {
            String[] arr = input.split("_");

            sb.append(arr[0]);

            for (int i = 1; i < arr.length; i++) {
                sb.append(Character.toUpperCase(arr[i].charAt(0)));
                sb.append(arr[i].substring(1));
            }
        }

        System.out.print(sb.toString());
    }

    private static boolean isError(String input) {
        if (input.charAt(0) >= 'A' && input.charAt(0) <= 'Z') {
            return true;
        }

        if (input.charAt(0) == '_') {
            return true;
        }

        if (input.charAt(input.length() - 1) == '_') {
            return true;
        }

        for (int i = 2; i < input.length() - 1; i++) {
            if (input.charAt(i) == '_' && input.charAt(i - 1) == '_') {
                return true;
            }
        }

        int snake = input.indexOf('_');
        if (snake == -1) {
            return false;
        }

        for (int i = 2; i < input.length(); i++) {
            if (input.charAt(i) >= 'A' && input.charAt(i) <= 'Z') {
                return true;
            }
        }

        return false;
    }

    private static void input() throws IOException {

    }

}
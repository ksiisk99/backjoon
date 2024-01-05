import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        String input = br.readLine();

        input = input.replace("XXXX", "AAAA");
        input = input.replace("XX", "BB");

        int index = input.indexOf("X");
        if (index != -1) {
            input = "-1";
        }

        System.out.println(input);
    }

    private static void input() throws IOException {

    }

}
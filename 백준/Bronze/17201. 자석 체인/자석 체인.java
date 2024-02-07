import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder answer = new StringBuilder();
    private static int N;
    private static String S;

    public static void main(String[] args) throws IOException {
        input();

        int index1 = S.indexOf("11");
        int index2 = S.indexOf("22");

        if(index1 == -1 && index2 == -1) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }

    private static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        S = br.readLine();
    }
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


    public static void main(String[] args) throws IOException {
        //input();

        String s = br.readLine();
        StringBuilder answer = new StringBuilder();
        StringBuilder temp = new StringBuilder();

        boolean isTag = false;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '<') {
                if (temp.length() > 0) {
                    answer.append(temp.reverse());
                    temp.setLength(0);
                }
                isTag = true;
                temp.append("<");
            } else if (s.charAt(i) == '>') {
                answer.append(temp.toString());
                answer.append(">");
                temp.setLength(0);
                isTag = false;
            } else if (s.charAt(i) == ' ') {
                if(isTag) {
                    temp.append(" ");
                } else {
                    answer.append(temp.reverse());
                    answer.append(" ");
                    temp.setLength(0);
                }
            } else {
                temp.append(s.charAt(i));
            }
        }

        answer.append(temp.reverse());
        System.out.print(answer);
    }

    public static void input() throws IOException {
        StringTokenizer st;

    }

}
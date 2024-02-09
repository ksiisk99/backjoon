import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder answer = new StringBuilder();
    private static Set<Character> set = Set.of('i', 'a', 'e', 'o', 'u');

    public static void main(String[] args) throws IOException {
        while (true) {
            String word = br.readLine();
            if (word.equals("#")) break;
            
            boolean check = false;
            for (int i = 0; i < word.length(); i++) {
                if (set.contains(word.charAt(i))) {
                    answer.append(word.substring(i));
                    answer.append(word, 0, i);
                    answer.append("ay\n");
                    check = true;
                    break;
                }
            }
            
            if(!check) {
                answer.append(word+"ay\n");
            }
        }

        System.out.print(answer.toString());
    }

    private static void input() throws IOException {

    }
}
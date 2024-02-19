import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder answer = new StringBuilder();


    public static void main(String[] args) throws IOException {
        String input = br.readLine();

        String[] questions = input.split("What is");

        for (int i = 1; i < questions.length; i++) {
            int index = questions[i].indexOf("?");
            if (index == -1) {
                continue;
            }

            answer.append("Forty-two is");
            answer.append(questions[i], 0, index);
            answer.append(".\n");
        }

        System.out.print(answer.toString());

    }


    private static void input() throws IOException {
//        Stream.Builder<String> stringBuilder = Stream.builder();
//        Stream<String> names = Stream.builder().add("asd").add("zxc").build();
//        names.forEach(System.out::print);
    }

}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder answer = new StringBuilder();

    static class Student implements Comparable<Student> {
        String name;
        double height;

        public Student(String name, Double height) {
            this.name = name;
            this.height = height;
        }

        @Override
        public int compareTo(Student o) {
            return Double.compare(o.height, this.height);
        }
    }

    public static void main(String[] args) throws IOException {

        while (true) {
            int n = Integer.parseInt(br.readLine());

            if (n == 0) {
                break;
            }

            List<Student> students = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                students.add(new Student(st.nextToken(), Double.parseDouble(st.nextToken())));
            }

            Collections.sort(students);

            for (int i = 0; i < students.size(); i++) {
                answer.append(students.get(i).name + " ");

                if (i != students.size() - 1 && students.get(i).height != students.get(i + 1).height) {
                    break;
                }
            }

            answer.append("\n");
        }

        System.out.print(answer.toString());
    }

    private static void input() throws IOException {
    }
}


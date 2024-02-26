import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder answer = new StringBuilder();
    private static int N, M;
    private static int[] subjects;
    private static List<Integer>[] students;
    private static List<Integer>[] queries, queries2;


    public static void main(String[] args) throws IOException {
        input();

        수강신청(queries);
        수강신청(queries2);

        print();
    }

    private static void print() {
        for (int i = 1; i <= N; i++) {
            if (students[i].isEmpty()) {
                answer.append("망했어요\n");
                continue;
            }

            answer.append(students[i].stream()
                    .sorted()
                    .map(String::valueOf)
                    .collect(Collectors.joining(" ")));

            answer.append("\n");
        }

        System.out.print(answer.toString());
    }

    private static void 수강신청(List<Integer>[] queries) {
        for (int i = 1; i <= N; i++) {
            for (int subject : queries[i]) {
                subjects[subject]--;
            }
        }

        신청결과(queries);
    }

    private static void 신청결과(List<Integer>[] queries) {
        for (int i = 1; i <= N; i++) {
            for (int subject : queries[i]) {
                if (subjects[subject] >= 0) {
                    students[i].add(subject);
                }
            }
        }
    }

    private static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        students = new ArrayList[N + 1];
        queries = new ArrayList[N + 1];
        queries2 = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            students[i] = new ArrayList();
            queries[i] = new ArrayList<>();
            queries2[i] = new ArrayList<>();
        }

        subjects = new int[M + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= M; i++) {
            subjects[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());

            while (true) {
                int subject = Integer.parseInt(st.nextToken());
                if (subject == -1) {
                    break;
                }

                queries[i].add(subject);
            }
        }

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());

            while (true) {
                int subject = Integer.parseInt(st.nextToken());
                if (subject == -1) {
                    break;
                }

                queries2[i].add(subject);
            }
        }

    }

}


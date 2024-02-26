import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder answer = new StringBuilder();
    private static int N;
    private static List<Integer> A = new ArrayList<>();
    private static List<Integer> B = new ArrayList<>();
    private static Queue<Info> queue = new ArrayDeque<>();

    static class Info {
        private int studentId;
        private int menuId;

        public Info(int studentId, int menuId) {
            this.studentId = studentId;
            this.menuId = menuId;
        }
    }


    public static void main(String[] args) throws IOException {
        input();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            processCommand(st);
        }

        print();
    }

    private static void processCommand(StringTokenizer st) {
        String type = st.nextToken();

        if (type.equals("1")) {
            int studentId = Integer.parseInt(st.nextToken());
            int menuId = Integer.parseInt(st.nextToken());
            queue.add(new Info(studentId, menuId));
        } else {
            int menuId = Integer.parseInt(st.nextToken());

            take(menuId);
        }
    }

    private static void print() {
        String aResult = A.isEmpty() ? "None" : A.stream()
                .sorted()
                .map(Object::toString)
                .collect(Collectors.joining(" "));

        String bResult = B.isEmpty() ? "None" : B.stream()
                .sorted()
                .map(Object::toString)
                .collect(Collectors.joining(" "));

        String cResult = queue.isEmpty() ? "None" : queue.stream()
                .sorted(Comparator.comparingInt(i -> i.studentId))
                .map(i -> String.valueOf(i.studentId))
                .collect(Collectors.joining(" "));

        answer.append(aResult + "\n");
        answer.append(bResult + "\n");
        answer.append(cResult);

        System.out.print(answer.toString());
    }

    private static void take(int menuId) {
        if (queue.isEmpty()) return;

        Info info = queue.poll();

        if (info.menuId == menuId) {
            A.add(info.studentId);
        } else {
            B.add(info.studentId);
        }
    }

    private static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
    }

}


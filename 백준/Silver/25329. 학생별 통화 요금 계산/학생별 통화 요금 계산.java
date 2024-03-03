import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder answer = new StringBuilder();

    private static Map<String, Integer> map = new HashMap<>();
    private static int N;

    static class Student implements Comparable<Student> {
        String name;
        int cost;

        public Student(String name, int cost) {
            this.name = name;
            this.cost = cost;
        }

        @Override
        public String toString() {
            return name + " " + cost;
        }

        @Override
        public int compareTo(Student o) {
            if (cost == o.cost) {
                return name.compareTo(o.name);
            }
            return o.cost - cost;
        }
    }

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            String time = st.nextToken();
            String name = st.nextToken();

            int currentMinute = map.getOrDefault(name, 0) + convertMinute(time);
            map.put(name, currentMinute);
        }

        List<Student> students = map.keySet()
                .stream()
                .map(key -> new Student(key, calculateCost(map.get(key))))
                .collect(Collectors.toList());

        print(students);
    }

    private static void print(List<Student> students) {
        String answer = students.stream()
                .sorted()
                .map(Student::toString)
                .collect(Collectors.joining("\n"));

        System.out.println(answer);
    }

    private static int calculateCost(int minute) {
        if (minute <= 100) {
            return 10;
        }

        int 기본요금 = 10;

        minute -= 100;

        int 추가요금 = ((int) Math.ceil(minute / 50.0)) * 3;

        return 기본요금 + 추가요금;
    }

    private static int convertMinute(String time) {
        StringTokenizer st = new StringTokenizer(time, ":");
        int hour = Integer.parseInt(st.nextToken());
        int min = Integer.parseInt(st.nextToken());

        return hour * 60 + min;
    }


    private static void input() throws IOException {
    }

}
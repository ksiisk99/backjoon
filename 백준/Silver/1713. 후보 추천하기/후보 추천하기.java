import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int N, totalRecommendation;
    private static PriorityQueue<Student> pq = new PriorityQueue<>();

    static class Student implements Comparable<Student> {
        int num;
        int recommendationCnt;
        int time;

        public Student(int num, int recommendationCnt, int time) {
            this.num = num;
            this.recommendationCnt = recommendationCnt;
            this.time = time;
        }

        @Override
        public int compareTo(Student o) {
            if (recommendationCnt == o.recommendationCnt) {
                return time - o.time;
            }
            return recommendationCnt - o.recommendationCnt;
        }

        public void addRecommendation() {
            recommendationCnt++;
        }
    }

    public static void main(String[] args) throws IOException {
        input();

        StringBuilder sb = new StringBuilder();
        pq.stream()
                .mapToInt(s -> s.num)
                .sorted()
                .forEach(i->{
                    sb.append(i);
                    sb.append(" ");
                });
        System.out.print(sb.toString());
    }


    public static void input() throws IOException {
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        totalRecommendation = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < totalRecommendation; i++) {
            int num = Integer.parseInt(st.nextToken());
            Student student = pq.stream()
                    .filter(s -> s.num == num)
                    .findFirst()
                    .orElse(null);

            if (student == null) {
                if (pq.size() == N) {
                    pq.poll();
                }
                pq.add(new Student(num, 1, i));
            } else {
                pq.remove(student);
                student.addRecommendation();
                pq.add(student);
            }

        }
    }
}
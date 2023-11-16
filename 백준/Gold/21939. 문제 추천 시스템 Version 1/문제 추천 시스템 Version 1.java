import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int N, M;
    private static StringBuilder sb = new StringBuilder();
    private static PriorityQueue<Problem> highProblems = new PriorityQueue<>();
    private static PriorityQueue<Problem> lowProblems = new PriorityQueue<>();
    private static int[] pArr = new int[100001];

    static class Problem implements Comparable<Problem> {
        int num;
        int level;

        public Problem(int num, int level) {
            this.num = num;
            this.level = level;
        }

        @Override
        public int compareTo(Problem o) {
            if (level == o.level) {
                return num - o.num;
            }
            return level - o.level;
        }
    }

    public static void main(String[] args) throws IOException {
        input();

        M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String query = st.nextToken();
            if (query.equals("add")) {
                int num = Integer.parseInt(st.nextToken());
                int level = Integer.parseInt(st.nextToken());
                Problem problem = new Problem(num, level);

                highProblems.add(problem);
                lowProblems.add(problem);
                pArr[num]=level;

            } else if (query.equals("recommend")) {
                int x = Integer.parseInt(st.nextToken());

                if (x == 1) {
                    recommend(highProblems);
                } else {
                    recommend(lowProblems);
                }

            } else { //solved
                Integer num = Integer.parseInt(st.nextToken());
                pArr[num]=0;
            }
        }

        System.out.print(sb.toString());
    }

    private static void recommend(PriorityQueue<Problem> problems) {
        while (!problems.isEmpty()) {
            Problem problem = problems.poll();
            if (pArr[problem.num] == problem.level) {
                sb.append(problem.num + "\n");
                problems.add(problem);
                break;
            }
        }
    }

    private static void input() throws IOException {
        highProblems = new PriorityQueue<>((a, b) -> {
            if (a.level == b.level) {
                return b.num - a.num;
            }
            return b.level - a.level;
        });

        lowProblems = new PriorityQueue<>((a, b) -> {
            if (a.level == b.level) {
                return a.num - b.num;
            }
            return a.level - b.level;
        });

        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());
            Problem problem = new Problem(p, l);
            pArr[p]=l;
            highProblems.add(problem);
            lowProblems.add(problem);
        }

    }
}

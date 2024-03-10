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
    private static int N, T;
    private static List<Study>[] list;

    static class Study implements Comparable<Study> {
        int start, end;


        public Study(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Study o) {
            return start - o.start;
        }
    }

    public static void main(String[] args) throws IOException {
        input();

        int max만족도 = 0;
        int answerStartTime = 0;
        int answerEndTime = 0;

        for (int studyStartTime = 0; studyStartTime <= 1000 - T; studyStartTime++) {
            int studyEndTime = studyStartTime + T;

            int 만족도 = calculate만족도(studyStartTime, studyEndTime);

            if (만족도 > max만족도) {
                max만족도 = 만족도;
                answerStartTime = studyStartTime;
                answerEndTime = studyEndTime;
            }
        }

        System.out.print(answerStartTime + " " + answerEndTime);
    }

    private static int calculate만족도(int start, int end) {
        int 만족도 = 0;

        for (int i = 0; i < N; i++) {
            int studyStartTime = start;
            int studyEndTime = end;

            for (Study study : list[i]) {
                if (studyStartTime > study.end || studyEndTime < study.start) {
                    continue;
                }

                studyStartTime = Math.max(studyStartTime, study.start);

                if (studyEndTime > study.end) {
                    만족도 += (study.end - studyStartTime);
                    studyStartTime = study.end;
                } else {
                    만족도 += (studyEndTime - studyStartTime);
                    break;
                }
            }
        }

        return 만족도;
    }

    private static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        list = new ArrayList[N];

        for (int i = 0; i < N; i++) {
            list[i] = new ArrayList<>();

            int k = Integer.parseInt(br.readLine());

            for (int j = 0; j < k; j++) {
                st = new StringTokenizer(br.readLine());

                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                list[i].add(new Study(start, end));
            }

            Collections.sort(list[i]);
        }

    }
}


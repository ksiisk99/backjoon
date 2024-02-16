import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder answer = new StringBuilder();
    private static int N;
    private static int[][] arr;

    public static void main(String[] args) throws IOException {
        input();

        int day = 0, day2 = 0;
        int maxStudent = -1;

        for (int i = 0; i < 4; i++) {
            for (int j = i + 1; j < 5; j++) {
                int countStudent = calculateCountStudent(i, j);

                if (maxStudent < countStudent) {
                    maxStudent = countStudent;
                    day = i;
                    day2 = j;
                }
            }
        }

        System.out.println(maxStudent);
        for (int i = 0; i < 5; i++) {
            if (i == day || i == day2) {
                System.out.print("1 ");
            } else {
                System.out.print("0 ");
            }
        }
    }

    private static int calculateCountStudent(int day, int day2) {
        int count = 0;

        for (int i = 0; i < N; i++) {
            if (arr[i][day] == 1 && arr[i][day2] == 1) {
                count++;
            }
        }

        return count;
    }

    private static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        arr = new int[N][5];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < 5; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

    }

}
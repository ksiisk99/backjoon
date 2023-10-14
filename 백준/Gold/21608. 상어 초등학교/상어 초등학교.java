import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int N, size;
    private static ArrayList<Integer>[] preferences;
    private static int[][] seatingArrangement;
    private static int[] students, dx = {0, 0, 1, -1}, dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        readInput();

        for (int s = 0; s < size; s++) {
            int currentStudent = students[s];
            int maxLoveCount = 0;
            int maxEmptyCount = 0;
            int x = N;
            int y = N;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (seatingArrangement[i][j] > 0) continue;

                    int loveCount = 0;
                    int emptyCount = 0;

                    for (int d = 0; d < 4; d++) {
                        int nx = i + dx[d];
                        int ny = j + dy[d];

                        if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                        if (seatingArrangement[nx][ny] == 0) {
                            emptyCount++;
                            continue;
                        }

                        loveCount += calculateLove(currentStudent, seatingArrangement[nx][ny]);
                    }

                    if (maxLoveCount < loveCount || (maxLoveCount == loveCount && maxEmptyCount < emptyCount) ||
                            (maxEmptyCount == emptyCount && (x > i || (x == i && y >= j)))) {
                        x = i;
                        y = j;
                        maxLoveCount = loveCount;
                        maxEmptyCount = emptyCount;
                    }
                }
            }
            seatingArrangement[x][y] = currentStudent;
        }

        int totalScore = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int loveCount = 0;
                for (int d = 0; d < 4; d++) {
                    int nx = i + dx[d];
                    int ny = j + dy[d];

                    if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                    loveCount += calculateLove(seatingArrangement[i][j], seatingArrangement[nx][ny]);
                }

                if (loveCount > 0) {
                    totalScore += Math.pow(10, loveCount - 1);
                }
            }
        }

        System.out.print(totalScore);
    }

    private static int calculateLove(int student, int otherStudent) {
        if (preferences[student].contains(otherStudent)) {
            return 1;
        }
        return 0;
    }

    private static void readInput() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        size = N * N;
        preferences = new ArrayList[size + 1];
        students = new int[size + 1];
        seatingArrangement = new int[N][N];

        for (int i = 0; i < size; i++) {
            st = new StringTokenizer(br.readLine());
            int student = Integer.parseInt(st.nextToken());
            students[i] = student;
            preferences[student] = new ArrayList<>();

            for (int j = 0; j < 4; j++) {
                preferences[student].add(Integer.parseInt(st.nextToken()));
            }
        }
    }
}
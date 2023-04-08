import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static int N, K, maxScore;
    private static int[][] board;
    private static int[] gunDamages;
    private static int[] dx = {0, 0, 1, -1};
    private static int[] dy = {1, -1, 0, 0};
    private static Map<String, Integer> initialPhysical = new HashMap<>();
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        input();
        shot(0, 0);
        System.out.print(maxScore);
    }

    private static void shot(int cnt, int score) {
        if (cnt == K) {
            maxScore = Math.max(maxScore, score);
            return;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j] > 0) {
                    int tmpScore = 0;

                    if (board[i][j] >= 10) {
                        tmpScore = board[i][j];
                        board[i][j] = 0;
                        shot(cnt + 1, score + tmpScore);
                    } else if (board[i][j] <= gunDamages[cnt]) {
                        int plusScore = initialPhysical.getOrDefault(i + " " + j, board[i][j]);
                        List<Integer> directList = createNewTarget(plusScore, i, j);
                        tmpScore = board[i][j];
                        board[i][j] = 0;
                        //새로 생겨난 타겟에 대해서도 표적을 쏘면 기존 점수를 줘야 된다.
                        shot(cnt + 1, score + plusScore);
                        removeNewTarget(directList, i, j);
                    } else {
                        String key = i + " " + j;
                        boolean isFirst = false;
                        if (!initialPhysical.containsKey(key)) {
                            isFirst = true;
                            initialPhysical.put(key, board[i][j]);
                        }
                        board[i][j] -= gunDamages[cnt];
                        tmpScore = gunDamages[cnt];
                        shot(cnt + 1, score);
                        if (isFirst) {
                            initialPhysical.remove(key);
                        }
                    }
                    board[i][j] += tmpScore;
                    break;
                }
            }
        }
    }


    private static void removeNewTarget(List<Integer> directList, int x, int y) {
        for (int i : directList) {
            board[x + dx[i]][y + dy[i]] = 0;
        }
    }

    private static List<Integer> createNewTarget(int score, int x, int y) {
        List<Integer> result = new ArrayList<>();
        score /= 4;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx < 0 || ny < 0 || nx >= N || ny >= N || board[nx][ny] > 0) {
                continue;
            }
            board[nx][ny] = score;
            result.add(i);
        }
        return result;
    }

    private static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());
        board = new int[N][N];
        gunDamages = new int[K];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            gunDamages[i] = Integer.parseInt(st.nextToken());
        }
    }
}


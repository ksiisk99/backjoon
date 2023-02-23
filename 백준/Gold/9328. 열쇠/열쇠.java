import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static StringBuilder sb = new StringBuilder();
    private static int result, N, M;
    private static final int[] dx = {0, 0, 1, -1};
    private static final int[] dy = {-1, 1, 0, 0};
    private static char[][] map;
    private static boolean[] key;
    private static boolean[][] check;
    private static Map<Integer, List<int[]>> keyPosition;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            keyPosition = new HashMap<>();
            map = new char[N + 2][M + 2];
            check = new boolean[N + 2][M + 2];
            result = 0;

            for (int i = 0; i <= N + 1; i++) {
                map[i][0] = '.';
                map[i][M + 1] = '.';
            }
            for (int i = 0; i <= M + 1; i++) {
                map[0][i] = '.';
                map[N + 1][i] = '.';
            }
            for (int i = 1; i <= N; i++) {
                String input = br.readLine();
                for (int j = 0; j < M; j++) {
                    map[i][j + 1] = input.charAt(j);
                }
            }
            key = new boolean[26];
            String inputKey = br.readLine();
            if (!inputKey.equals("0")) {
                inputKey.chars()
                        .forEach(i -> key[i - 'a'] = true);
            }

            dfs(0, 0);

            sb.append(result);
            sb.append("\n");


        }

        System.out.print(sb.toString());
    }

    private static void dfs(int x, int y) {
        check[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx < 0 || nx > (N + 1) || ny > (M + 1) || ny < 0 || check[nx][ny] || map[nx][ny] == '*') continue;
            if (map[nx][ny] == '$') {
                result++;
                dfs(nx, ny);
            } else if (map[nx][ny] == '.') {
                dfs(nx, ny);
            } else if (map[nx][ny] >= 'A' && map[nx][ny] <= 'Z' && key[map[nx][ny] - 'A']) {
                dfs(nx, ny);
            } else if (map[nx][ny] >= 'a' && map[nx][ny] <= 'z') { //key
                key[map[nx][ny] - 'a'] = true;
                dfs(nx, ny);
                if (keyPosition.containsKey(map[nx][ny] - 'a')) {
                    List<int[]> positions = keyPosition.get(map[nx][ny] - 'a');
                    positions.stream()
                            .forEach(arr -> dfs(arr[0], arr[1]));
                    keyPosition.remove(map[nx][ny] - 'a');
                }
            } else { //문인데 key가 없으면
                List<int[]> position = keyPosition.getOrDefault(map[nx][ny] - 'A', new ArrayList<>());
                position.add(new int[]{nx, ny});
                keyPosition.put(map[nx][ny] - 'A', position);
            }
        }
    }

}
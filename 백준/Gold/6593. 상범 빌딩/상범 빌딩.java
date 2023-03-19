import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static StringBuilder sb = new StringBuilder();
    private static int L, R, C;
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static char[][][] board;
    private static int[] dx = {0, 0, 1, -1, 0, 0};
    private static int[] dy = {1, -1, 0, 0, 0, 0};
    private static int[] dz = {0, 0, 0, 0, 1, -1};
    private static boolean[][][] visit;
    private static int sz, sx, sy, ez, ex, ey;


    public static void main(String[] args) throws IOException {
        while (true) {
            input();
            if (L == 0 && R == 0 && C == 0) {
                break;
            }
            Queue<int[]> queue = new LinkedList<>();
            queue.add(new int[]{sz, sx, sy, 0});
            boolean flag=false;
            while (!queue.isEmpty()) {
                int[] info = queue.poll();
                int z = info[0];
                int x = info[1];
                int y = info[2];
                int cnt = info[3];
                if(z==ez && x==ex && y==ey){
                    sb.append("Escaped in "+cnt+" minute(s).\n");
                    flag=true;
                    break;
                }

                for (int i = 0; i < 6; i++) {
                    int nz = z + dz[i];
                    int nx = x + dx[i];
                    int ny = y + dy[i];

                    if (nz < 0 || ny < 0 || nx < 0 || nz >= L || nx >= R || ny >= C || visit[nz][nx][ny]) continue;
                    if (board[nz][nx][ny] == '.') {
                        visit[nz][nx][ny] = true;
                        queue.add(new int[]{nz,nx,ny,cnt+1});
                    }
                }
            }

            if(!flag){
                sb.append("Trapped!\n");
            }
        }
        System.out.print(sb.toString());
    }

    private static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        board = new char[L][R][C];
        visit = new boolean[L][R][C];

        for (int z = 0; z < L; z++) {
            for (int i = 0; i < R; i++) {
                String s = br.readLine();
                for (int j = 0; j < C; j++) {
                    board[z][i][j] = s.charAt(j);
                    if (board[z][i][j] == 'S') {
                        sz = z;
                        sx = i;
                        sy = j;
                        visit[z][i][j] = true;
                    } else if (board[z][i][j] == 'E') {
                        ez = z;
                        ex = i;
                        ey = j;
                        board[z][i][j]='.';
                    }
                }
            }
            String s = br.readLine();
        }
    }
}


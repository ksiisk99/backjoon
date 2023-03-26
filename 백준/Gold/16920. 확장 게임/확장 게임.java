import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static StringBuilder sb = new StringBuilder();
    private static int N, P, M;
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static char[][] board;
    private static int[] speed, result;
    private static int[] dx = {1, -1, 0, 0};
    private static int[] dy = {0, 0, 1, -1};
    private static Queue<int[]>[] queue;


    public static void main(String[] args) throws IOException {
        input();
        play();
        for(int i=1;i<=P;i++){
            sb.append(result[i]+" ");
        }
        System.out.print(sb.toString());
    }

    private static void play() {
        boolean isPlay=true;
        while (isPlay) {
            isPlay=false;
            for(int i=1;i<=P;i++){
                int dist=speed[i];
                while(!queue[i].isEmpty() && (dist--)>0){
                    isPlay=true;
                    int size=queue[i].size();
                    while((size--)>0){
                        int[] coordinate=queue[i].poll();
                        int x=coordinate[0];
                        int y=coordinate[1];

                        for(int d=0;d<4;d++){
                            int nx=x+dx[d];
                            int ny=y+dy[d];
                            if(nx>=0 && nx<N && ny>=0 && ny<M && board[nx][ny]=='.'){
                                board[nx][ny]=(char)(i+'0');
                                result[i]++;
                                queue[i].add(new int[]{nx,ny});
                            }
                        }
                    }
                }
            }
        }
    }

    private static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());

        board = new char[N][M];
        speed = new int[P + 1];
        result = new int[P + 1];
        queue = new Queue[P + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= P; i++) {
            queue[i] = new LinkedList<>();
            speed[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                board[i][j] = s.charAt(j);
                if (board[i][j] >= '1' && board[i][j] <= '9') {
                    queue[board[i][j] - '0'].add(new int[]{i, j});
                    result[board[i][j]-'0']++;
                }
            }
        }
    }
}


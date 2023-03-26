import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static StringBuilder sb = new StringBuilder();
    private static int N, K;
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        input();
        Queue<Integer> queue = new LinkedList<>();
        queue.add(N);
        boolean[][] visit = new boolean[2][500001];
        visit[0][N] = true;
        int size, mod, time = 0;
        while (!queue.isEmpty()) {
            size = queue.size();
            time++;
            mod = time % 2;

            K += time;
            if(K>500000){
                System.out.print(-1);
                break;
            }
            
            for(int i=0;i<size;i++){
                int cur=queue.poll();
                
                int next=cur-1;
                if(next>=0 && !visit[mod][next]){
                    queue.add(next);
                    visit[mod][next]=true;
                }
                
                next=cur+1;
                if(next<=500000 && !visit[mod][next]){
                    queue.add(next);
                    visit[mod][next]=true;
                }

                next=cur*2;
                if(next<=500000 && !visit[mod][next]){
                    queue.add(next);
                    visit[mod][next]=true;
                }
            }
            
            if(visit[mod][K]){
                System.out.print(time);
                break;
            }
        }
    }

    private static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        if(N==K){
            System.out.print(0);
            System.exit(0);
        }
    }
}


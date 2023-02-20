import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<Integer>[] adjust = new ArrayList[N + 1];
        int[] degree = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            adjust[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int cnt = Integer.parseInt(st.nextToken());
            int node = Integer.parseInt(st.nextToken());
            for (int c = 1; c < cnt; c++) {
                int parentNode = Integer.parseInt(st.nextToken());
                adjust[node].add(parentNode);
                degree[parentNode]++;
                node=parentNode;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        int finishCnt=0;
        for(int i=1;i<=N;i++){
            if(degree[i]==0){
                queue.add(i);
                finishCnt++;
            }
        }

        while(!queue.isEmpty()){
            int n=queue.poll();
            sb.append(n);
            sb.append("\n");

            for(int next:adjust[n]){
                degree[next]--;
                if(degree[next]==0){
                    queue.add(next);
                    finishCnt++;
                }
            }
        }
        if(finishCnt!=N){
            System.out.print("0");
        }else{
            System.out.print(sb.toString());
        }

    }

}
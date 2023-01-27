import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static StringBuilder sb;
    private static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();


        int T;
        T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            int N, M;
            N = Integer.parseInt(br.readLine());
            int[] rank = new int[N + 1];
            int[] degree = new int[N + 1];
            List<Integer> list[] = new ArrayList[N + 1];
            for (int i = 1; i <= N; i++) {
                list[i] = new ArrayList<>();
            }

            st = new StringTokenizer(br.readLine());
            int idx = 0;
            while (st.hasMoreTokens()) {
                rank[idx++] = Integer.parseInt(st.nextToken());
                for (int i = idx - 2; i >= 0; i--) {
                    list[rank[i]].add(rank[idx - 1]);
                    degree[rank[idx - 1]]++;
                }
            }
            M = Integer.parseInt(br.readLine());

            boolean flag=false;
            for (int m = 0; m < M; m++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                boolean check=!list[b].contains((Integer)a);
                boolean check2=!list[a].contains((Integer)b);
                if(check && check2){
                    sb.append("IMPOSSIBLE\n");
                    flag=true;
                    break;
                }
                if(check2){
                    list[b].remove((Integer)a);
                    list[a].add(b);
                    degree[b]++;
                    degree[a]--;
                }else{
                    list[a].remove((Integer)b);
                    list[b].add(a);
                    degree[a]++;
                    degree[b]--;
                }

            }
            if(flag)continue;

            Queue<Integer> queue = new LinkedList<>();
            int check=0;
            for (int i = 1; i <= N; i++) {
                if (degree[i] == 0) {
                    queue.add(i);
                    check++;
                }
            }

            StringBuilder tmpSb = new StringBuilder();
            while (!queue.isEmpty()) {
                int num = queue.poll();
                tmpSb.append(num + " ");
                for (int n : list[num]) {
                    degree[n]--;
                    if(degree[n]==0){
                        queue.add(n);
                        check++;
                    }
                }
            }
            if(check!=N)sb.append("IMPOSSIBLE\n");
            else sb.append(tmpSb.toString() + "\n");

        }

        System.out.print(sb.toString());
    }


}